
/**
 * This program is a basic outline and experimentation for an interactive
 * game in which the user controls a cursor and moves between areas
 * 
 * Variables:
 * win_width (int): window width
 * win_height (int): window height
 * x, y (int, int): x-coordinate and y-coordinate of cursor, respectively
 * velX, velY (int, int): velocities with respect to x and y-axis, respectively
 * c (int): stores keycode for key being pressed
 * stepsize (int): amount of pixels traversed per step
 * 
 * Implements the following custom classes:
 * 
 * JPanelwithBackground (instance: anim_bg)
 * JPanelSketch (instance: sketch)
 * JPanelGrid (instance: gridcanvas)
 * JPanelPictures (instances: display1, display2, display3)
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JLayeredPane;

import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 

@SuppressWarnings("serial")
public class Anim_gameblueprint extends JPanel implements ActionListener, KeyListener
{
    static int win_width = 1200;
    static int win_height = 800;

    Timer tm = new Timer(100, this);

    static JPanelGrid gridcanvas = new JPanelGrid();
    static JPanelPictures display1 = new JPanelPictures("300_1.jpg");
    static JPanelPictures display2 = new JPanelPictures("300_2.jpg");
    static JPanelPictures display3 = new JPanelPictures("300_3.png");

    int x = 0, velX = 0;
    int y = 0, velY = 0;

    public Anim_gameblueprint() {
        // Starts timer and ActionListener
        tm.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        BufferedImage img = null;
        File f = null;
        g.drawImage(img, 0, 0, null);

        // Read image to cursor icon
        try {
            f = new File("plumbob.png");
            img = ImageIO.read(f);

        } catch (IOException e) {
            System.out.println(e);
        }

        super.paintComponent(g);
        g.drawImage(img, x, y, this);
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        int bound_x = win_width - 70;
        int bound_y = win_height - 70;
        if (x < 0) {
            velX = 0;
            x = 0;
        }
        if (x > bound_x) {
            velX = 0;
            x = bound_x;
        }
        if (y < 0) {
            velY = 0;
            y = 0;
        }
        if (y > bound_y) {
            velY = 0;
            y = bound_y;
        }
        x = x + velX;
        y = y + velY;

        //Sets grid layer to visible depending on plumbob location
        if (x > 175 && x < 475) {
            if (y > 100 && y < 400) {
                gridcanvas.setVisible(true);
            } else {
                gridcanvas.setVisible(false);
            }
        } else {
            gridcanvas.setVisible(false);
        }

        //Painting displays based on plumbob location
        //LABEL 1
        if (x > 275 && x < 375) {
            if (y > 100 && y < 140) {
                display1.setVisible(true);
            } else {
                display1.setVisible(false);
            }
        } else {
            display1.setVisible(false);
        }
        //LABEL 2
        if (x > 175 && x < 215) {
            if (y > 200 && y < 300) {
                display2.setVisible(true);
            }
            else {
                display2.setVisible(false);
            }
        }
        else {
            display2.setVisible(false);
        }
        //LABEL 3
        if (x > 360 && x < 400) {
            if (y > 200 && y < 300) {
                display3.setVisible(true);
            } else {
                display3.setVisible(false);
            }
        } else {
            display3.setVisible(false);
        }

        repaint();
    }

    public void keyPressed(java.awt.event.KeyEvent e) {
        int key = e.getKeyCode();
        int stepsize = 20;
        if (key == KeyEvent.VK_LEFT) {
            velX = -stepsize;
            velY = 0;
        }
        if (key == KeyEvent.VK_RIGHT) {
            velX = stepsize;
            velY = 0;
        }
        if (key == KeyEvent.VK_UP) {
            velX = 0;
            velY = -stepsize;
        }
        if (key == KeyEvent.VK_DOWN) {
            velX = 0;
            velY = stepsize;
        }
    }

    public void keyTyped(java.awt.event.KeyEvent e) {
    }

    public void keyReleased(java.awt.event.KeyEvent e) {
        velX = 0;
        velY = 0;
    }

    public static void main(String[] args) {

        Anim_gameblueprint bp = new Anim_gameblueprint();
        JFrame jf = new JFrame();

        JLayeredPane layers = new JLayeredPane();
        JPanelWithBackground anim_bg = null;

        try {
            anim_bg = new JPanelWithBackground("orange_cat.jpg");
        } catch (IOException e) {
            System.out.println(e);
        }

        JPanelSketch sketch = new JPanelSketch();

        //Creates label using JLabel imported class
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        label1.setText("1");
        label2.setText("2");
        label3.setText("3");
        label1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
        label2.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 3));
        label3.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
        label1.setBackground(Color.WHITE);
        label2.setBackground(Color.WHITE);
        label3.setBackground(Color.WHITE);
        
        //Set bounds for JPanels and add lables to JFrame
        anim_bg.setBounds(0, 0, win_width, win_height);
        sketch.setBounds(0, 0, win_width, win_height);
        gridcanvas.setBounds(0, 0, win_width, win_height);
        display1.setBounds(0, 0, win_width, win_height);
        display2.setBounds(0, 0, win_width, win_height);
        display3.setBounds(0, 0, win_width, win_height);
        label1.setBounds(275, 100, 100, 40);
        jf.add(label1);
        label2.setBounds(175, 200, 40, 100);
        jf.add(label2);
        label3.setBounds(435, 200, 40, 100);
        jf.add(label3);
        bp.setBounds(0, 0, win_width, win_height);

        //Set opacity or visiblity for layers
        bp.setOpaque(false);
        label1.setOpaque(true);
        label2.setOpaque(true);
        label3.setOpaque(true);
        sketch.setOpaque(false);
        gridcanvas.setOpaque(false);
        anim_bg.setOpaque(false);
        display1.setOpaque(false);
        display2.setOpaque(false);
        display3.setOpaque(false);
        anim_bg.setVisible(true);
        gridcanvas.setVisible(false);
        display1.setVisible(false);
        display2.setVisible(false);
        display3.setVisible(false);
        label1.setVisible(true);
        label2.setVisible(true);
        label3.setVisible(true);
        sketch.setVisible(true);
        bp.setVisible(true);

        //Add JPanel and label layers to JLayeredPane
        layers.add(anim_bg, Integer.valueOf(2));
        layers.add(gridcanvas, Integer.valueOf(3));
        layers.add(bp, Integer.valueOf(4));
        layers.add(label1, Integer.valueOf(5));
        layers.add(label2, Integer.valueOf(6));
        layers.add(label3, Integer.valueOf(7));
        layers.add(sketch, Integer.valueOf(8));
        layers.add(display1, Integer.valueOf(9));
        layers.add(display2, Integer.valueOf(10));
        layers.add(display3, Integer.valueOf(11));
        jf.setContentPane(layers);

        //Create JFrame with window specifications
        jf.setTitle("Anim Game Blueprint");
        jf.setSize(win_width, win_height);
        //bp.setBackground(Color.BLACK);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}