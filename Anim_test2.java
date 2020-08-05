import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Anim_test2 extends JPanel implements ActionListener
{
    
    //2 args: sleep for -5- ms, and -this- refers to ActionListener
    Timer tm = new Timer(5, this);
    //2 variables: x represents position, velX represents velocity/speed
    int x = 0, velX = 2;
    int y = 0, velY = 2;
    
    public void paintComponent (Graphics g, int rec_width, int rec_height)
    {
        super.paintComponent(g);
        
        g.setColor(Color.RED);
        g.fillRect(x, y, rec_width, rec_height);

        //Starts timer and ActionListener
        tm.start();
    }

    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        // x is limited to 550 b/c counting from top left of rectangle,
        // therefore width is 50, and height limited by 30
        // However, is 350 instead of 370 b/c title bar ccounts for 20 pixels
        if (x<0 || x > 550)
        {
            velX = -velX;
        }
        if (y<0 || y>350)
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
        if (args.length != 2) {
            System.out.println("Error: expects two parameters");
            System.out.println("Please enter width and height of rectangle");
            System.exit(1);
        }

        int rec_width = Integer.parseInt(args[0]);
        int rec_height = Integer.parseInt(args[1]);

        Anim_test2 t = new Anim_test2();
        JFrame jf = new JFrame();
        jf.setTitle("Tutorial");
        jf.setSize(600, 400);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(t);
    }
}