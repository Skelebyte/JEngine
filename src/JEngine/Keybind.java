package JEngine;

public class Keybind {

    public String name;
    public Key key;

    public boolean pressed;

    public Keybind() {
        name = "New keybind";
        key = Key.KEY_NULL;
        pressed = false;

        Input.binds.add(this);

    }

    public Keybind(String _name, Key _key) {
        name = _name;
        key = _key;
        pressed = false;

        Input.binds.add(this);

    }

}

