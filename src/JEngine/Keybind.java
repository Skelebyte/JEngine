package JEngine;

import java.util.Objects;

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
        if(Objects.equals(_name, "")) {
            name = "New keybind";
        } else {
            name = _name;
        }
        key = _key;
        pressed = false;

        Input.binds.add(this);

    }

}

