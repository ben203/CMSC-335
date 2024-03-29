  /**
  * Name: Bedemariam Degef
  * Project: Project 2 
  * Date: 02/08/21
  * Purpose: This class is used to calculate the area of the circle
  * 
 */

package Bedemariam.two_dimensional;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

 
public class Circle extends TwoDimensionalShape {

    private int radius;

 

    /**
     * Uses formula: pi * r^2 to calculate the area of this circle
     *
     * @return the area of a circle based on given radius
     */
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Used to properly display the required fields of each shape object
     *
     * @return an array of required fields for shape creation
     */
    @Override
    public String[] getSpecifications() {
        return new String[]{"Radius"};
    }

    /**
     * Returns a JPanel containing a drawn shape based on the data passed to the object.
     *
     * @return returns a JPanel containing the shape
     */
    @Override
    public JPanel getShapePanel(){
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString(String.format("Radius: %d", radius), 0, 15);
                String stats = String.format("The Area of your Circle is : %.2f", area());
                FontMetrics metrics = g.getFontMetrics();

                int diameter = radius * 2;
                int circleX = (this.getWidth()-diameter)/2;
                int circleY = (this.getHeight()-diameter)/2;
                int stringX = (this.getWidth()-metrics.stringWidth(stats))/2;
                int stringY = circleY+diameter+30;

                g.drawOval(circleX, circleY, diameter, diameter);
                g.drawString(stats, stringX, stringY);

            }
        };
    }
    /**
     * Passes values to the objects in a way that shapes with varying parameter counts can implement.
     *
     * @param values an arraylist of integers. First index is the first initialized data member and so on.
     */
    @Override
    public void passValues(ArrayList<Integer> values) {
        this.radius = values.get(0);
    }
}