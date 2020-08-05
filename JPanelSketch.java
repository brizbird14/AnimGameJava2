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
        g.drawRect(0, 500, 1200, 100);
        g.drawRect(275, 400, 100, 100);
        g.drawRect(750, 400, 100, 100);

        g.setColor(Color.CYAN);
        g.drawRect(175, 100, 300, 300);
        g.drawRect(650, 100, 300, 300);

        super.paintComponent(g);
    }
  }