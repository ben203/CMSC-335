  /**
  * Name: Bedemariam Degef
  * Project: Project 2 
  * Date: 02/08/21
  * Purpose: This class is used to calculate the area of the square
  * 
 */


package Bedemariam.two_dimensional;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

 
public class Square extends TwoDimensionalShape {

    private int side;

 

    /**
     * Uses the formula s^2 to calculate the area of the square.
     * 
     * @return the calculated area of this square
     */
    @Override
    public double area() {
        return side * side;
    }

    /**
     * Used to properly display the required fields of each shape object
     *
     * @return an array of required fields for shape creation
     */
    @Override
    public String[] getSpecifications() {
        return new String[] {"Sides"};
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
                g.drawString(String.format("Side: %d", side), 0, 15);
                String stats = String.format("The Area of your Square is : %.2f", area());
                FontMetrics metrics = g.getFontMetrics();

                int rectX = (this.getWidth()-side)/2;
                int rectY = (this.getHeight()-side )/2;
                int stringX = (this.getWidth()-metrics.stringWidth(stats))/2;
                int stringY = rectY+side+30;

                g.drawRect(rectX, rectY , side, side);
                g.drawString(stats, stringX ,stringY);
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
        this.side = values.get(0);
    }
}
