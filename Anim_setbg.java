
/**
 * Code taken from: Geeks for Geeks: "Image Processing in Java | Set 1 (Read and Write)"
 * ^some modifications made; program requires an image on-disc to work
 * ^^ file name was written b/c in same folder; if not, need entire directory/path
 * Some comments were added personally
 */

// Java program to demonstrate read and write of image 

/** Classes required:
 * File: read/write image files, representing file and directory path names
 * IOException: used to handle errors
 * BufferedImage: using BufferedImage class, creates object ot hold image
 * ^ object stores image in RAM
 * ImageIO: uses static methods to read and write images
 */


import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;

import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
  
@SuppressWarnings("serial")
public class Anim_setbg extends Canvas
{ 
    public void paint (Graphics g) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img_bg = tk.getImage("orange_cat.jpg");  
        g.drawImage(img_bg, 1800, 1200, this);
    }  
        public static void main(String[] args) {  
        Anim_setbg cat_bg = new Anim_setbg();  
        JFrame f = new JFrame();  
        f.add(cat_bg);  
        f.setSize(1800,1200);  
        f.setVisible(true);
    }

    /**
    public void paintComponent (Graphics g)
    {
        BufferedImage img = null; 
        File f = null; 

        BufferedImage img_bg = null;
        File f_bg = null;
        
        try
        {
            f_bg = new File("orange_cat.jpg");
            img_bg = ImageIO.read(f_bg);
        }
        catch(IOException e) 
        { 
            System.out.println(e); 
        }
        g.drawImage(img_bg, 0, 0, 1800, 1200, null);


        g.drawImage(img, 0, 0, null);

        // read image
        try
        { 
            // **** Changed so that enter input image as command line parameter
            f = new File("orange_cat.jpg"); 
            img = ImageIO.read(f); 
            
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
        //Graphics g = img.createGraphics();

        super.paintComponent(g);
        g.drawImage(img, 1800, 1200, this);
    }
    */

    /** public static void main(final String args[])throws IOException 
    { 
        final int width = 1200;    //width of the image 
        final int height = 1800;   //height of the image 
  
        // For storing image in RAM 
        BufferedImage img_bg = null; 
  
        // READ IMAGE 
        try
        { 
            final File input_file = new File("orange_cat.jpg"); //image file path 
  
            img_bg = new BufferedImage(1800, 1200, BufferedImage.TYPE_INT_ARGB); 
  
             // Reading input file 
            img_bg = ImageIO.read(input_file); 
  
            System.out.println("Reading complete."); 
        } 
        catch(final IOException e) 
        { 
            System.out.println("Error: "+e); 
        } 
        g.drawImage(image_bg, 0, 0, null);
    }
    public static void main(String[] args)
    {
        Anim_setbg t = new Anim_setbg();
        JFrame jf = new JFrame();
        jf.setTitle("Tutorial");
        jf.setSize(1200, 800);
        //t.setBackground(Color.CYAN);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(t);
    }
    */
}