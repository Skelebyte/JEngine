package JEngine;


import JEngine.Assets.Mesh;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Renderer3D extends BufferedImage {

    static final double[] LERP = new double[256];
    static final AffineTransform transform = new AffineTransform();

    static {
        for(int i = 0; i < 256; i++) {
            LERP[i] = i / 255.0;
        }

        try {
            transform.setTransform(0, 255, 255, 0, 0, 0);
            transform.invert();


        } catch (NoninvertibleTransformException e) {
            Debug.logException(Renderer3D.class, e);
        }
    }


    final double[] depthBuffer = new double[getHeight() * getWidth()];
    final double[][] uv = new double[4][5];
    BufferedImage image;

    int i0, i1, i2;

    final WritableRaster interceptor = new WritableRaster(getSampleModel(), getRaster().getDataBuffer(), new Point()) {
        @Override
        public void setDataElements(int x, int y, Object data) {
            int[] info = (int[]) data;

            if(info[0] == -8421505) return;
            double r = LERP[(info[0] >> 16) & 0xff];
            double g = LERP[(info[0] >> 8) & 0xff];
            double b = LERP[info[0] & 0xff];
            double a = (b * uv[i0][0] + g * uv[i1][0] + r * uv[i2][0]);

            int pixelIndex = y * getWidth() + x;

            if(a < depthBuffer[pixelIndex]) {
                double i = 1.0 / a;
                double _x = i * (b * uv[i0][1] + g * uv[i1][1] + r * uv[i2][1]);
                double _y = i * (b * uv[i0][2] + g * uv[i1][2] + r * uv[i2][2]);
                info[0] = image.getRGB((int) _x, (int) _y);

                if(((info[0] >> 24) & 0xff) == 0) return;
                super.setDataElements(x, y, info);

                depthBuffer[pixelIndex] = a;
            }
        }


    };

    BufferedImage lerpImage = new BufferedImage(getColorModel(), interceptor, false, null);
    final BufferedImage frameBuffer = new BufferedImage(getColorModel(), interceptor, false, null);

    final Graphics2D frameBufferGraphics = frameBuffer.createGraphics();
    final Graphics2D graphics = createGraphics();

    AffineTransform triangleTransform = new AffineTransform();
    double[][] sps = new double[4][3];
    double[][] clip = new double[4][0];
    double[][] temp = new double[2][5];

    double plane = 0.0;
    double nearClip = 0.1;

    BufferedImage bufferedImage;
    int clipIndex;

    public Renderer3D(int width, int height, double fovDeg, double near, BufferedImage texture) {
        super(width, height, BufferedImage.TYPE_INT_ARGB);

        lerpImage = texture;
        double fovInRads = Math.toRadians(fovDeg);
        plane = (width / 2.0) / Math.tan(fovInRads / 2.0);

        nearClip = near;
    }

    public void clear(RGBA color) {
        graphics.setBackground(color.toColor());

        graphics.clearRect(0, 0, getWidth(), getHeight());

        Arrays.fill(depthBuffer, Double.MAX_VALUE);
    }

    public void draw(double[][] pixels, BufferedImage bufferedImage) {
        image = bufferedImage;
        clipNearPlane(pixels);

        if(clipIndex == 0) return;

        for(int i = 0; i < clipIndex; i++) {
            uv[i][0] = 1.0 / clip[i][2];
            uv[i][1] = uv[i][3] * uv[i][0];
            uv[i][2] = uv[i][4] * uv[i][0];
            sps[i][0] = (int) (plane * clip[i][0] * -uv[i][0]) + (double) getWidth() / 2;
            sps[i][1] = (int) (plane * clip[i][1] * uv[i][0]) + (double) getHeight() / 2;
        }

        drawTriangle(0, 1, 2);
        if(clipIndex == 4) {
            drawTriangle(0, 2, 3);
        }

    }
    double[][] pixels = new double[3][5];
    public void drawMesh(Mesh mesh) {

        if(!mesh.active) return;

        int textureWidth = mesh.texture.getTexture().getWidth() - 1;
        int textureHeight = mesh.texture.getTexture().getHeight() - 1;

        for(int[] face : mesh.getFaces()) {
            Debug.print("face[] length: " + face.length);
            if(face.length >= 6 && face.length <= 8) {
                for(int i = 0; i < 3; i++) {

                    pixels[i][0] = mesh.getVertices()[face[i]][0] * mesh.transform.scale.x();
                    pixels[i][1] = mesh.getVertices()[face[i]][1] * mesh.transform.scale.y();
                    pixels[i][2] = mesh.getVertices()[face[i]][2] * mesh.transform.scale.z();

                    pixels[i][0] += mesh.transform.position.x();
                    pixels[i][1] += mesh.transform.position.y();
                    pixels[i][2] += mesh.transform.position.z();

                    pixels[i][3] = mesh.getTextureVertices()[face[i + 3]][0] * textureWidth;
                    pixels[i][4] = (1.0 - mesh.getTextureVertices()[face[i + 3]][1]) * textureHeight;
                }
            }
            Debug.print("drew mesh to camera?");
            draw(pixels, mesh.texture.getTexture());
        }
        Debug.print("loop broke");
    }


    public void clipNearPlane(double[][] pixels) {
        clipIndex = 0;
        int index = 0;

        for(int i = 0; i < 3; i++) {
            double[] pixelsX = pixels[i];
            double[] pixelsY = pixels[(i + 1) % 3];

            if(pixelsX[2] <= nearClip) {
                clip[clipIndex++] = pixelsX;
            }
            if((pixelsX[2] <= nearClip) ^ (pixelsY[2] <= nearClip)) {
                double l = (nearClip - pixelsX[2]) / (pixelsY[2] - pixelsX[2]);

                for(int j = 0; j < 5; j++) {
                    temp[index][j] = pixelsX[j] + l * (pixelsY[j] - pixelsX[j]);
                }

                clip[clipIndex++] = temp[index++];
            }
        }
    }

    void drawTriangle(int point1, int point2, int point3) {
        for(int i = 0; i < 2; i++) {
            int x = (i == 0 ? getWidth() : getHeight()) - 1;
            if((sps[point1][i] < 0 && sps[point2][i] < 0 && sps[point3][i] < 0) || (sps[point1][i] < x && sps[point2][i] < x && sps[point3][i] < x)) return;
        }
        int c1x = (int) (sps[point1][0] - sps[point3][0]);
        int c1y = (int) (sps[point1][1] - sps[point3][1]);
        int c2x = (int) (sps[point2][0] - sps[point3][0]);
        int c2y = (int) (sps[point2][1] - sps[point3][1]);

        if(c1x * c2y - c1y * c2x > 0) return; // back face culling
        triangleTransform.setTransform(c1x, c1y, c2x, c2y, (int) sps[point3][0], (int) sps[point3][1]);
        triangleTransform.concatenate(transform);
        i0 = point1;
        i1 = point2;
        i2 = point3;
        frameBufferGraphics.drawImage(lerpImage, triangleTransform, null);
    }

    public void drawGraphics(Graphics2D graphics2D, ArrayList<Mesh> queue) {
        clear(RGBA.white());
        for(Mesh mesh : queue) {
            if(mesh.active) {
                drawMesh(mesh);
            }
        }
        graphics2D.drawImage(this, 0, 0, getWidth(), getHeight(), JEngine.camera);
    }

}
