
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

 /* Global Variables */
 
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

    static int x_pic_left = 650;
    static int x_pic_right = 50;
    static int y_pic = 50;
    static JPanelGrid gridcanvas = new JPanelGrid();
    static JPanelScreen screencanvas = new JPanelScreen(win_width, win_height);

    static int piccount = 14;

    static LabelArea[] labels = new LabelArea[piccount];

    static JPanelPictures[] pictures = new JPanelPictures[piccount];

    int x = 0, velX = 0;
    int y = 0, velY = 0;

    public Anim_gameblueprint() {
        // Starts timer and ActionListener
        tm.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(final Graphics g) {
        BufferedImage img = null;
        File f = null;
        g.drawImage(img, 0, 0, null);

        // Read image to cursor icon
        try {
            f = new File("plumbob.png");
            img = ImageIO.read(f);

        } catch (final IOException e) {
            System.out.println(e);
        }

        super.paintComponent(g);
        g.drawImage(img, x, y, this);
    }

    public void actionPerformed(final java.awt.event.ActionEvent e) {
        final int bound_x = win_width - 128;
        final int bound_y = win_height - 128;
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

        // Painting displays based on plumbob location
        boolean hitLabel = false;
        for (int counter = 0; counter < piccount; counter++) {
            if (labels[counter] != null && labels[counter].inArea(x, y) == true) {
                if (pictures[counter] != null) {
                    pictures[counter].setVisible(true);
                    hitLabel = true;
                }
            } else {
                if (pictures[counter] != null) {
                    pictures[counter].setVisible(false);
                }
            }
        }

        if (hitLabel == true) {
            screencanvas.setVisible(true);
        } else {
            screencanvas.setVisible(false);
        }
        repaint();
    }

    public void keyPressed(final java.awt.event.KeyEvent e) {
        final int key = e.getKeyCode();
        final int stepsize = 20;
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

    public void keyTyped(final java.awt.event.KeyEvent e) {
    }

    public void keyReleased(final java.awt.event.KeyEvent e) {
        velX = 0;
        velY = 0;
    }

    public static void main(final String[] args) {

        final Anim_gameblueprint bp = new Anim_gameblueprint();
        final JFrame jf = new JFrame();

        final JLayeredPane layers = new JLayeredPane();
        JPanelWithBackground anim_bg = null;

        try {
            anim_bg = new JPanelWithBackground("Untitled_Artwork.jpg");
        } catch (final IOException e) {
            System.out.println(e);
        }

        final JPanelSketch sketch = new JPanelSketch();

        //Creates label using JLabel imported class
        /** JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel(); */
        labels[0] = new LabelArea(200, 100,100, 20);
        labels[1] = new LabelArea (350, 100, 100, 20);
        labels[2] = new LabelArea (750, 100, 100, 20);
        labels[3] = new LabelArea (900, 100, 100, 20);
        labels[4] = new LabelArea (200, 290, 100, 20);
        labels[5] = new LabelArea (350, 290, 100, 20);
        labels[6] = new LabelArea (750, 290, 100, 20);
        labels[7] = new LabelArea (900, 290, 100, 20);
        labels[8] = new LabelArea (200, 480, 100, 20);
        labels[9] = new LabelArea (900, 480, 100, 20);
        labels[10] = new LabelArea (100, 150, 20, 100);
        labels[11] = new LabelArea (100, 350, 20, 100);
        labels[12] = new LabelArea (1080, 150, 20, 100);
        labels[13] = new LabelArea (1080, 350, 20, 100);

        pictures[0] = new JPanelPictures("500_1.png", x_pic_left, y_pic);
        pictures[1] = new JPanelPictures("500_2.png", x_pic_left, y_pic);
        pictures[2] = new JPanelPictures("500_3.png", x_pic_right, y_pic);
        pictures[3] = new JPanelPictures("500_4.png", x_pic_right, y_pic);
        pictures[4] = new JPanelPictures("500_5.png", x_pic_left, y_pic);
        pictures[5] = new JPanelPictures("500_6.png", x_pic_left, y_pic);
        pictures[6] = new JPanelPictures("500_7.png", x_pic_right, y_pic);
        pictures[7] = new JPanelPictures("500_8.png", x_pic_right, y_pic);
        pictures[8] = new JPanelPictures("500_9.png", x_pic_left, y_pic);
        pictures[9] = new JPanelPictures("500_10.png", x_pic_right, y_pic);
        pictures[10] = new JPanelPictures("500_11.png", x_pic_left, y_pic);
        pictures[11] = new JPanelPictures("500_12.png", x_pic_left, y_pic);
        pictures[12] = new JPanelPictures("500_13.png", x_pic_right, y_pic);
        pictures[13] = new JPanelPictures("500_14.png", x_pic_right, y_pic);
        
        for (int i_text = 0; i_text < piccount; i_text++) {
            labels[i_text].setText(Integer.toString(i_text+1));
        }
        for (int i_bg = 0; i_bg < piccount; i_bg++) {
            labels[i_bg].setBackground(Color.WHITE);
        }
        for (int i_add = 0; i_add < piccount; i_add++) {
            jf.add(labels[i_add]);
        }

        labels[0].setBounds(200, 100, 100, 20);
        labels[1].setBounds(350, 100, 100, 20);
        labels[2].setBounds(750, 100, 100, 20);
        labels[3].setBounds(900, 100, 100, 20);
        labels[4].setBounds(200, 290, 100, 20);
        labels[5].setBounds(350, 290, 100, 20);
        labels[6].setBounds(750, 290, 100, 20);
        labels[7].setBounds(900, 290, 100, 20);
        labels[8].setBounds(200, 480, 100, 20);
        labels[9].setBounds(900, 480, 100, 20);
        labels[10].setBounds(100, 150, 20, 100);
        labels[11].setBounds(100, 350, 20, 100);
        labels[12].setBounds(1080, 150, 20, 100);
        labels[13].setBounds(1080, 350, 20, 100);
        
        //Set bounds for JPanels and add lables to JFrame
        anim_bg.setBounds(0, 0, win_width, win_height);
        sketch.setBounds(0, 0, win_width, win_height);
        gridcanvas.setBounds(0, 0, win_width, win_height);
        screencanvas.setBounds(0, 0, win_width, win_height);
        for (int j_bounds = 0; j_bounds < piccount; j_bounds++) {
            pictures[j_bounds].setBounds(0, 0, win_width, win_height);
        }
        /** pictures[0].setBounds(0, 0, win_width, win_height);
        pictures[1].setBounds(0, 0, win_width, win_height);
        pictures[2].setBounds(0, 0, win_width, win_height);
        pictures[3].setBounds(0, 0, win_width, win_height);
        pictures[4].setBounds(0, 0, win_width, win_height);
        pictures[5].setBounds(0, 0, win_width, win_height);
        pictures[6].setBounds(0, 0, win_width, win_height);
        pictures[7].setBounds(0, 0, win_width, win_height);
        pictures[8].setBounds(0, 0, win_width, win_height);
        pictures[9].setBounds(0, 0, win_width, win_height);
        pictures[10].setBounds(0, 0, win_width, win_height);
        pictures[11].setBounds(0, 0, win_width, win_height);
        pictures[12].setBounds(0, 0, win_width, win_height);
        pictures[13].setBounds(0, 0, win_width, win_height); */

        bp.setBounds(0, 0, win_width, win_height);

        //Set opacity or visiblity for layers
        bp.setOpaque(false);
        for (int i_opaque = 0; i_opaque < piccount; i_opaque++) {
            labels[i_opaque].setOpaque(true);
            pictures[i_opaque].setOpaque(false);
        }
        for (int i_visible = 0; i_visible < piccount; i_visible++) {
            labels[i_visible].setOpaque(true);
            pictures[i_visible].setVisible(false);
        }

        sketch.setOpaque(false);
        gridcanvas.setOpaque(false);
        screencanvas.setOpaque(false);
        anim_bg.setOpaque(false);

        anim_bg.setVisible(true);
        gridcanvas.setVisible(true);
        screencanvas.setVisible(false);
        bp.setVisible(true);

        //Add JPanel and label layers to JLayeredPane
        layers.add(anim_bg, Integer.valueOf(2));
        layers.add(gridcanvas, Integer.valueOf(3));
        layers.add(bp, Integer.valueOf(5));
        for (int i_panel = 0; i_panel < piccount; i_panel++) {
            layers.add(labels[i_panel], Integer.valueOf(4));
            layers.add(pictures[i_panel], Integer.valueOf(7));
        }
        layers.add(sketch, Integer.valueOf(8));
        layers.add(screencanvas, Integer.valueOf(6));
        
        jf.setContentPane(layers);

        //Create JFrame with window specifications
        jf.setTitle("Anim Game Blueprint");
        jf.setSize(win_width, win_height);
        //bp.setBackground(Color.BLACK);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}