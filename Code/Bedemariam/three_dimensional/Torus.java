  /**
  * Name: Bedemariam Degef
  * Project: Project 2 
  * Date: 02/08/21
  * Purpose: This class is used to calculate the volume of the torus
  * 
 */

package Bedemariam.three_dimensional;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

 
public class Torus extends ThreeDimensionalShape {
    private int innerRadius, outerRadius;

 

    /**
     * Uses the formula 2 * pi^2 * R * r^2 to calculate volume
     * 
     * @return calculated volume of this torus
     */
    @Override
    public double volume() {
        return 2 * Math.pow(Math.PI, 2) * outerRadius * Math.pow(innerRadius, 2);
    }


    /**
     * Used to properly display the required fields of each shape object
     *
     * @return an array of required fields for shape creation
     */
    @Override
    public String[] getSpecifications() {
        return new String[]{"Inner Radius", "Outer Radius"};
    }

    /**
     * Returns a JPanel containing a drawn shape based on the data passed to the object.
     *
     * @return returns a JPanel containing the shape
     */
    @Override
    public JPanel getShapePanel() throws IOException {
        final BufferedImage image = ImageIO.read(getClass().getResource("/img/torus.jpg"));
        Image reScaledImage = image.getScaledInstance(300, 300, Image.SCALE_DEFAULT);

        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString(String.format("Inner Radius: %d, Outer Radius: %d", innerRadius, outerRadius), 0, 15);
                int imageX = (this.getWidth() - reScaledImage.getWidth(null))/2;
                int imageY = (this.getHeight() - reScaledImage.getHeight(null))/2;
                g.drawImage(reScaledImage, imageX, imageY, null);
                int stringY = imageY + (reScaledImage.getHeight(null)) + 15;
                g.drawString(String.format("The Volume of your shape is : %.2f", volume()), imageX ,stringY);
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
        this.innerRadius = values.get(0);
        this.outerRadius = values.get(1);
    }
}
