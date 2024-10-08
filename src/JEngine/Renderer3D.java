package JEngine;


import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class Renderer3D extends BufferedImage {


    public Renderer3D(int width, int height, int imageType) {
        super(width, height, imageType);
    }

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
            Debug.logException(e);
        }
    }


    final double[] depthBuffer = new double[getHeight() * getWidth()];
    final double[][] uv = new double[4][3];
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

    

}
