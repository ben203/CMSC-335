  /**
  * Name: Bedemariam Degef
  * Project: Project 2 
  * Date: 02/08/21
  * Purpose: This class is used to calculate the volume of the cone
  */
package Bedemariam.three_dimensional;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

 
public class Cone extends ThreeDimensionalShape {

    private int baseRadius, height;

 
    /**
     * Uses the formula pi * r^2 * h / 3 to calculate the volume of a cone
     * 
     * @return The calculate volume based on this cone.
     */
    @Override
    public double volume() {
        return Math.PI * Math.pow(baseRadius, 2) * height / 3;
    }

    /**
     * Used to properly display the required fields of each shape object
     *
     * @return an array of required fields for shape creation
     */
    @Override
    public String[] getSpecifications() {
        return new String[]{"Radius", "Height"};
    }

    /**
     * Returns a JPanel containing a drawn shape based on the data passed to the object.
     *
     * @return returns a JPanel containing the shape
     */
    @Override
    public JPanel getShapePanel() throws IOException {

        final BufferedImage image = ImageIO.read(getClass().getResource("/img/cone.jpg"));
        Image reScaledImage = image.getScaledInstance(300, 300, Image.SCALE_DEFAULT);

        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString(String.format("Base radius: %d, Height: %d", baseRadius, height), 0, 15);
                //centering with fast maffs
                int imageX = (this.getWidth() - reScaledImage.getWidth(null))/2;
                int imageY = (this.getHeight() - reScaledImage.getHeight(null))/2;
                g.drawImage(reScaledImage, imageX, imageY, null);
                int stringY = imageY + reScaledImage.getHeight(null) + 15;
                g.drawString(String.format("The Volume of your Cone is : %.2f", volume()), imageX ,stringY);
            }
        };

    }

    /**
     * Passes values to the objects in a way that shapes with varying parameter counts can implement.
     * @param values an arraylist of integers. First index is the first initialized data member and so on.
     */
    @Override
    public void passValues(ArrayList<Integer> values) {
        this.baseRadius = values.get(0);
        this.height = values.get(1);

    }
}
