package view;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle
{
    private int radius;
    private int x;
    private int y;
    private Color color;
    private boolean changeAspect;

    public Circle(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }

    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
        color = getNextColor();
        radius = 25;
    }

    public int getRadius() {
        return radius;
    }

    public void draw(Graphics g, int x, int y) {
        this.draw(g);
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        if (changeAspect) {
            color = getNextColor();
            changeAspect = false;
            radius = (int)(200 * Math.random());
        }
        g.setColor(color);
        g.fillOval(x - radius , y - radius, radius * 2, radius * 2);
    }

    public void clickAt(int x, int y) {
        changeAspect = isInsideCircle(x, y);
    }



    private Color getNextColor() {
        int red = (int) (255 * Math.random());
        int green = (int) (255 * Math.random());
        int blue = (int) (255 * Math.random());

        return new Color(red, green, blue);
    }

    public boolean isInsideCircle(int x, int y) {
        int xCenter = this.x;
        int yCenter = this.y;
        double d = Math.hypot(yCenter - y, xCenter - x);
        return d <= radius;
    }
}