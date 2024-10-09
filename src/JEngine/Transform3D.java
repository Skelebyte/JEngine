package JEngine;

public class Transform3D {

    public Vector3 position;
    public Vector3 scale;

    public Transform3D() {
        position = Vector3.zero();
        scale = new Vector3(1, 1, 1);
    }

    public Transform3D(Vector3 _position, Vector3 _scale) {
        position = _position;
        scale = _scale;
    }

}
