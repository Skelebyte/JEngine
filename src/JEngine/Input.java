package JEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Input implements KeyListener {

    public static ArrayList<Keybind> binds = new ArrayList<>(1);

    public static Input Input;

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
            return;
        }
    }

    public static boolean isKeyJustPressed(String keyName) {

        for (Keybind bind : binds) {
            if(bind.pressed) {
                bind.pressed = false;
                return true;
            } else {
                return false;
            }

        }

        return false;
    }

}
