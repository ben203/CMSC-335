  /**
  * Name: Bedemariam Degef
  * Project: Project 2 
  * Date: 02/08/21
  * Purpose: This class is used to calculate the area of the rectangle
  * 
 */


package Bedemariam.two_dimensional;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

 
public class Rectangle extends TwoDimensionalShape {

    private int width, height;

 

    /**
     * Uses the formula w * h to calculate the area of this rectangle
     * 
     * @return the area of the given rectangle
     */
    @Override
    public double area() {
        return width * height;
    }

    /**
     * Used to properly display the required fields of each shape object
     *
     * @return an array of required fields for shape creation
     */
    @Override
    public String[] getSpecifications() {
        return new String[]{"Width", "Height"};
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
                g.drawString(String.format("Width: %d, Height: %d", width, height), 0, 15);
                String stats = String.format("The Area of your Rectangle is : %.2f", area());
                FontMetrics metrics = g.getFontMetrics();

                int rectX = (this.getWidth()-width)/2;
                int rectY = (this.getHeight()-height )/2;
                int stringX = (this.getWidth()-metrics.stringWidth(stats))/2;
                int stringY = rectY+height+30;

                g.drawRect(rectX, rectY , width, height);
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
        this.width = values.get(0);
        this.height = values.get(1);
    }
}
