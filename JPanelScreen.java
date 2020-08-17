/**
 * Program creates a panel with outline of scenery
 * Implemented in Anim_gameblueprint.java
 * 
 * Parameters: N/A
 * 
 * No need for error handling; no files to find, all objects created
 * manually in paintComponent method using Graphics
 * 
 * 
 * When called in Anim_gameblueprint.java, used as JPanel b/c class extends
 */

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.File; 
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;

public class JPanelScreen extends JPanel {

    int w, h;
    public JPanelScreen(int width, int height) {
        w = width;
        h = height;
    }

    public void paintComponent(Graphics g) {
        
        g.setColor(new Color(0, 0, 0, 150));
        g.drawRect(0, 0, w, h);
        g.fillRect(0, 0, w, h);

        super.paintComponent(g);
    }
  }