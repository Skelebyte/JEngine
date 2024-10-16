package JEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Input implements KeyListener {

    public static ArrayList<Keybind> binds = new ArrayList<>(1);

    public static Input Input;

    public Input() {
        binds.add(new Keybind("NULL", Key.KEY_NULL));
        Debug.print("input init");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (binds.isEmpty()) {
            binds.add(new Keybind());
            return;
        }

        for (Keybind bind : binds) {
            if (bind.key.keyCode == e.getKeyCode()) {
                bind.pressed = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (binds.isEmpty()) {
            binds.add(new Keybind());
            return;
        }

        for (Keybind bind : binds) {
            if (bind.key.keyCode == e.getKeyCode()) {
                bind.pressed = false;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (binds.isEmpty()) {
            binds.add(new Keybind());
        }
    }

    public static boolean isKeyJustPressed(String keyName) {

        for (Keybind bind : binds) {
            if(bind.pressed) {
                bind.pressed = false;
                Debug.print("hey! " + bind.name + " is being pressed!");
                return true;
            } else {
                return false;
            }

        }

        return false;
    }

}
