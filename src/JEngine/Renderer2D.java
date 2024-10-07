package JEngine;


import javax.swing.*;
import java.awt.*;

public class Renderer2D extends JPanel {


    public void paint(Graphics graphics){
        graphics.drawString("JEngine!", 100, 100);
    }
    int[] pixels;

    public Renderer2D() {

    }
}
