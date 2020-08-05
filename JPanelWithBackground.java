/** 
 * Program creates a background panel
 * Implemented in Anim_gameblueprint.java
 * 
 * Parameters: String filename
 * --> If file is found, reads image and stores in var. backgroundImage
 * --> If file not found, reads out error
 * 
 * If image stored successfully, draws image
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

public class JPanelWithBackground extends JPanel {

    private Image backgroundImage;
  
    // Uses constructor method to create background image

    //Original code has String filename as a parameter and then in orange_cat
    public JPanelWithBackground(String filename) throws IOException {
        backgroundImage = ImageIO.read(new File(filename));
    }
  
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
  
      // Draw the background image.
      g.drawImage(backgroundImage, 0, 0, this);
    }
  }