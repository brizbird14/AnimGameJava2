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

public class JPanelSketch extends JPanel {

    private Image backgroundImage;

    public void paintComponent(Graphics g) {
        
        g.setColor(Color.PINK);
        g.drawRect(0, 600, 1200, 100);
        g.drawRect(550, 500, 100, 100);

        g.setColor(Color.CYAN);
        g.drawRect(100, 100, 1000, 400);

        super.paintComponent(g);
    }
  }