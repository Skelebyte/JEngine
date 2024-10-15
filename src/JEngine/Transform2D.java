package JEngine;

public class Transform2D {
    public Vector2 position;
    public Vector2 scale;

    public Transform2D() {
        position = Vector2.zero();
        scale = new Vector2(1, 1);
    }

    public Transform2D(Vector2 _position, Vector2 _scale) {
        position = _position;
        scale = _scale;
    }
}
