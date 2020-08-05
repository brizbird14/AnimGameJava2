
// Source: http://www.java2s.com/Tutorials/Java/Graphics_How_to/Shape/Draw_grid.htm
/**
 * Program creates a gridded canvas that shows the user where they are
 * 
 * Implemented in Anim_gameblueprint.java
 * 
 * Parameters: N/A
 * 
 * When called in Anim_gameblueprint.java, used as JPanel b/c class extends
 */

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class JPanelGrid extends JPanel {
  int width, height;
  int rows;
  int cols;

  JPanelGrid() {
    setSize(width = 1200, height = 800);
    rows = 40;
    cols = 60;
  }

  public void paint(Graphics g) {
    int i;
    width = getSize().width;
    height = getSize().height;

    // draw the rows
    int rowHt = height / (rows);
    for (i = 0; i < rows; i++)
      g.drawLine(0, i * rowHt, width, i * rowHt);

    // draw the columns
    int rowWid = width / (cols);
    for (i = 0; i < cols; i++)
      g.drawLine(i * rowWid, 0, i * rowWid, height);
  }
}