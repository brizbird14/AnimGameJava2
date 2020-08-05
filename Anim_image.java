import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.*;

import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class Anim_image extends JPanel implements ActionListener
{
    
    //2 args: sleep for -5- ms, and -this- refers to ActionListener
    Timer tm = new Timer(100, this);
    //2 variables: x represents position, velX represents velocity/speed
    int x = 0, velX = 2;
    int y = 0, velY = 2;

    public void paintComponent (Graphics g)
    {
        BufferedImage img = null; 
        File f = null; 
  
        // read image
        try
        { 
            // **** Changed so that enter input image as command line parameter
            f = new File("smiley.png"); 
            img = ImageIO.read(f); 
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
        //Graphics g = img.createGraphics();

        super.paintComponent(g);
        g.drawImage(img, x, y, this);
        
        //g.setColor(Color.RED);
        //g.fillRect(x, y, 50, 30);

        //Starts timer and ActionListener
        tm.start();
    }

    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        double direc = 150;
        if (velX < 0)
        {
            velX = (int) (Math.random() * direc * (-1)) - 1;
        }
        else
        {
            velX = (int) (Math.random() * direc) + 1;
        }
        
        if (velY < 0)
        {
            velY = (int) (Math.random() * direc * (-1)) - 1;
        }
        else
        {
            velY = (int) (Math.random() * direc) + 1;
        }
        // x is limited to 550 b/c counting from top left of rectangle,
        // therefore width is 50, and height limited by 30
        // However, is 350 instead of 370 b/c title bar ccounts for 20 pixels
        if ((x+velX) < 0 || (x+velX) > 550)
        {
            velX = -velX;
        }
        if ((y+velY) < 0 || (y+velY) > 350)
        {
            velY = -velY;
        }
        x = x + velX;
        y = y + velY;
        //Repaints the rectangle ever -5- ms
        repaint();
    }

    public static void main(String[] args)
    {
        Anim_image t = new Anim_image();
        JFrame jf = new JFrame();
        jf.setTitle("Tutorial");
        jf.setSize(600, 400);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(t);
    }
}