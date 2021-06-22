  /**
  * Name: Bedemariam Degef
  * Project: Project 2 
  * Date: 02/08/21
  * Purpose: JPanel class that will create a JLabel and JTextField for every measurement needed for the chosen shape
  * 
  */
package Bedemariam.gui;

import javax.swing.*;
import java.util.ArrayList;

 
public class SpecificationPanel extends JPanel {

    private final ArrayList<JTextField> textFields = new ArrayList<>();

    /**
     * constructs a JPanel for every measurement needed to draw the shape and calculate area or volume
     * @param itemSpecifications String array of the names of the specifications of the given shape
     */
    public SpecificationPanel(String[] itemSpecifications) {

        for (String spec : itemSpecifications) {
            JLabel itemSpecLabel = new JLabel(spec);
            JTextField itemSpecTextField = new JTextField(2);
            textFields.add(itemSpecTextField);
            this.add(itemSpecLabel);
            this.add(itemSpecTextField);
        }
    }

    /**
     * returns the JTextFields so that the values maybe be grabbed from them.
     * @return an ArrayList of JTextFields for the given shape.
     */
    public ArrayList<JTextField> getTextFields() {
        return textFields;
    }
}
