package JEngine.Assets;
import JEngine.Asset;
import JEngine.JEngine;
import JEngine.Debug;
import JEngine.Transform3D;
import JEngine.LogType;
import JEngine.Loader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Mesh extends Asset {


    public boolean active = true;

    public Transform3D transform;

    public Texture texture;

    public Mesh(String path, Texture _texture) {
        super(path);
        texture = _texture;
        transform = new Transform3D();

        loadMesh(path);
    }
    public Mesh(String path, Texture _texture, Transform3D _transform) {
        super(path);
        texture = _texture;
        transform = _transform;

        loadMesh(path);

    }



    int[][] faces;
    double[][] vertices;

    double[][] textureVertices;
    void loadMesh(String path) {
        InputStream stream;
        try {
            stream = Loader.load(path);
        } catch(NullPointerException e) {
            Debug.logException(getClass(), e);
            return;
        }


        if(stream == null) {
            Debug.log(LogType.ERROR, "Mesh path is incorrect: " + path);
            return;
        }

        try(Scanner scanner = new Scanner(stream)) {

            List<double[]> verticesTemp = new ArrayList<>();
            List<double[]> textureVertexTemp = new ArrayList<>();
            List<int[]> facesTemp = new ArrayList<>();

            scanner.useDelimiter("[ /\n]");

            while(scanner.hasNext()) {
                String next = scanner.next();

                switch (next) {
                    case "v" ->
                            verticesTemp.add(new double[]{
                                scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()
                            });
                    case "vt" ->
                            textureVertexTemp.add(new double[]{
                                scanner.nextDouble(), scanner.nextDouble()
                            });
                    case "f" -> {
                            int vertex1 = scanner.nextInt() - 1;
                            int vertex2 = scanner.nextInt() - 1;
                            int vertex3 = scanner.nextInt() - 1;
                            int edge1 = scanner.nextInt() - 1;
                            int edge2 = scanner.nextInt() - 1;
                            int edge3 = scanner.nextInt() - 1;
                            facesTemp.add(new int[]{
                                    vertex1, vertex2, vertex3, edge1, edge2, edge3
                            });
                    }
                }

            }

            vertices = verticesTemp.toArray(new double[0][0]);
            faces = facesTemp.toArray(new int[0][0]);

            textureVertices = textureVertexTemp.toArray((new double[0][0]));

            JEngine.addMeshToRenderQueue(this);

        } catch (Exception e) {
            Debug.logException(getClass(), e);
        }
    }

    public int[][] getFaces() {
        return faces;
    }

    public double[][] getVertices() {
        return vertices;
    }

    public double[][] getTextureVertices() {
        return textureVertices;
    }







}
