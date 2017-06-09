package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

/**
 * Write a description of class DrawingPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DrawingPanel extends JPanel
{
    //private Circle circle;
    private Collection<Circle> circles;
    private Collection<Circle> circlesList;
    private List<Circle> ar = new ArrayList<>();

    public DrawingPanel() {

        //circle = new Circle(25, Color.yellow);
        circles = new Vector<Circle>();
        circlesList = new Vector<Circle>();

        setBackground(Color.GRAY);

        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event) {
                orderList(circles);
                if (!clickIsInsideAnyCircle(event)) {
                    addNewCircle(event);
                }
                repaint();
            }
        });
    }

    private boolean clickIsInsideAnyCircle(MouseEvent event) {
        boolean isInsideAnyCircle = false;
        for (Circle circle: circles) {
            circle.clickAt(event.getX(), event.getY());
            if (circle.isInsideCircle(event.getX(), event.getY())) {
                isInsideAnyCircle = true;
            }
        }
        return isInsideAnyCircle;
    }

    private void addNewCircle(MouseEvent event) {
        circles.add(new Circle(event.getX(), event.getY()));
        orderList(circles);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Circle circle: circles) {
            circle.draw(g);
        }

    }

    private List<Circle> orderList(Collection<Circle> circle) {

        List<Circle> sortedByAgePersons = new ArrayList<Circle>(circle);
        Collections.sort(sortedByAgePersons, new Comparator<Circle>() {
            public int compare(Circle c1, Circle c2) {
                return Integer.valueOf(c1.getRadius()).compareTo(c2.getRadius());
            }
        });
        return sortedByAgePersons;
    }
}