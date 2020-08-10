import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.io.File; 
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;

public class LabelArea extends JLabel {

    int TL_x, TL_y, l_width, l_height;
    public LabelArea(int x, int y, int w, int h) {
        TL_x = x;
        TL_y = y;
        l_width = w;
        l_height = h;
    }

    public boolean inArea(int cursor_x, int cursor_y) {
         if (cursor_x >= TL_x && cursor_x <= (TL_x + l_width)) {
             if (cursor_y >= TL_y && cursor_y <= (TL_y + l_height)) {
                 return true;
             }
             else {
                 return false;
             }
         }
         else {
             return false;
         }
    }
  }