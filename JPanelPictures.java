/** 
 * Program creates the "museum" pictures
 * Implemented in Anim_gameblueprint.java
 * 
 * Takes a String for a file name (var. filename)
 * If file is found, reads image and stores in var. backgroundImage
 * If file not found, reads out error
 * 
 * If image stored successfully, draws image
 * When called in Anim_gameblueprint.java, used as JPanel b/c class extends
*/

/** 
 * Program creates a "museum" of pictures
 * Implemented in Anim_gameblueprint.java
 * 
 * Parameters: String img
 * --> If file is found, reads image and stores in var. backgroundImage
 * --> If file not found, reads out error
 * 
 * When called in Anim_gameblueprint.java, used as JPanel b/c class extends
 * --> Multiple instances can be called to create different pictures
*/

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.File; 
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;

public class JPanelPictures extends JPanel {

    private Image display_img;

    int TL_x, TL_y;
    public JPanelPictures(String img, int x, int y) {
        try {
            File pos_img = new File(img);
            display_img = ImageIO.read(pos_img);
        } catch (IOException e) {
            System.out.println(e);
        }
        TL_x = x;
        TL_y = y;
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(display_img, TL_x, TL_y, this);
    }
}