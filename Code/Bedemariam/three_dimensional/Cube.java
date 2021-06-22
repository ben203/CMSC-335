  /**
  * Name: Bedemariam Degef
  * Project: Project 2 
  * Date: 02/08/21
  * Purpose: This class is used to calculate the volume of the cube
  * 
 */
package Bedemariam.three_dimensional;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

 
public class Cube extends ThreeDimensionalShape {

    private int edge;

 

    /**
     * Uses the formula edge^3 to calculate the volume of a cube
     * 
     * @return The calculate volume based on this edge.
     */
    @Override
    public double volume() {
        return Math.pow(edge, 3);
    }

    /**
     * Used to properly display the required fields of each shape object
     *
     * @return an array of required fields for shape creation
     */
    @Override
    public String[] getSpecifications() {
        return new String[]{"Edge"};
    }

    /**
     * Returns a JPanel containing a drawn shape based on the data passed to the object.
     *
     * @return returns a JPanel containing the shape
     */
    @Override
    public JPanel getShapePanel() throws IOException {
        final BufferedImage image = ImageIO.read(getClass().getResource("/img/cube.jpg"));
        Image reScaledImage = image.getScaledInstance(300, 300, image.getType());

        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString(String.format("Edge: %d", edge), 0, 15);

                int imageX = (this.getWidth() - reScaledImage.getWidth(null)  )/2;
                int imageY = (this.getHeight() - reScaledImage.getHeight(null))/2;
                g.drawImage(reScaledImage, imageX, imageY, null);
                int stringY = imageY + (reScaledImage.getHeight(null)) + 15;
                g.drawString(String.format("The Volume of your Cube is : %.2f", volume()), imageX ,stringY);
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
        this.edge = values.get(0);
    }
}
