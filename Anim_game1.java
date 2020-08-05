
// YouTube: Java Tutorial 45 (GUI) - Moving Object with
// Keyboard Inputs (KeyListener) | John Gizdich

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.*;

import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
import java.awt.Graphics2D;

/**
 * Step notes:
 * If you want smooth steps, set 5ms intervals with velocity 1
 * If you want incremented steps, set 100ms w/ velocity 40
 */

@SuppressWarnings("serial")
public class Anim_game1 extends JPanel implements ActionListener, KeyListener
{
    
    //2 args: sleep for -5- ms, and -this- refers to ActionListener
    Timer tm = new Timer(100, this);
    //2 variables: x represents position, velX represents velocity/speed
    int x = 0, velX = 0;
    int y = 0, velY = 0;

    public Anim_game1()
    {
        tm.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent (Graphics g)
    {
        BufferedImage img = null; 
        File f = null; 
  
        // read image
        try
        { 
            // **** Changed so that enter input image as command line parameter
            f = new File("plumbob.png"); 
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
    }

    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        if (x < 0)
        {
            velX = 0;
            x = 0;
        }
        if (x > 1130)
        {
            velX = 0;
            x = 1130;
        }
        if (y < 0)
        {
            velY = 0;
            y = 0;
        }
        if (y > 730)
        {
            velY = 0;
            y = 730;
        }
        x = x + velX;
        y = y + velY;
        repaint();
    }

    public void keyPressed(java.awt.event.KeyEvent e)
    {
        int c = e.getKeyCode();
        int stepsize = 40;
        if (c == KeyEvent.VK_LEFT)
        {
             velX = -stepsize;
             velY = 0;
        }
        if (c == KeyEvent.VK_RIGHT)
        {
            velX = stepsize;
            velY = 0;
        }
        if (c == KeyEvent.VK_UP)
        {
            velX = 0;
            velY = -stepsize;
        }
        if (c == KeyEvent.VK_DOWN)
        {
            velX = 0;
            velY = stepsize;
        }
    }

    public void keyTyped(java.awt.event.KeyEvent e) {}
    public void keyReleased(java.awt.event.KeyEvent e)
    {
        velX = 0;
        velY = 0;
    }

    public static void main(String[] args)
    {
        Anim_game1 t = new Anim_game1();
        JFrame jf = new JFrame();
        jf.setTitle("Tutorial");
        jf.setSize(1200, 800);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(t);
    }
}