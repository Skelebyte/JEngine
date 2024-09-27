package BoneSource;

import javax.swing.*;
import java.awt.*;

public class WindowFrame extends JFrame {
    public WindowFrame(String _name) {
        try {
            this.setName(_name);
            Debug.log(LogType.MESSAGE, "success: " + this.getName());
        } catch(Exception ignored) {
            Debug.log(LogType.ERROR, ignored.getMessage() + " : " + ignored.getCause());
        }
    }

    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;




    }

}
