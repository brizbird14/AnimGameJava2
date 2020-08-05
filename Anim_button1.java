
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;

import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO;

public class Anim_button1 extends JPanel
{
    Anim_button1()
    {  
		// JFrame f =new JFrame("Button Example");            
        // JButton b=new JButton("Play", new ImageIcon("play.png"));
        JButton b =new JButton("Play");
		b.setBounds(100,100, 140, 40);
		}
		public static void main(String[] args) {    
		    new Anim_button1();    
        }
}
