package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Marco Llano.
 */
public class DrawingPanel extends JPanel
{

    MouseEvent e = null;

    public DrawingPanel() {
        setBackground(Color.GRAY);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event) {
                System.out.println(String.format("click at: %s, %s",
                        event.getX(), event.getY()));
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.yellow);

        int xCenter = getWidth()/2;
        int yCenter = getHeight()/2;

        g.fillOval(xCenter - (50/2) , yCenter - (50/2), 50, 50);

        if (e.getButton() == 1) {
            g.setColor(Color.green);
        }
    }

    public void mouseClicked() {
        if ((e.getButton() == 1) && (e.getX() == getWidth()/2 && e.getY() == getHeight()/2 && e.getXOnScreen() == 50 && e.getYOnScreen() == 50) ) {

            // JOptionPane.showMessageDialog(null,e.getX()+ "\n" + e.getY());
        }
    }
}
