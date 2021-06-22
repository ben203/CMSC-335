  /**
  * Name: Bedemariam Degef
  * Project: Project 2 
  * Date: 02/08/21
  * Purpose: Class to be extended by circle, square, triangle, and rectangle. Made
 *           abstract as no instantiations of this class will be needed and implementation
 *           of area() will depend on child class.
 */

package Bedemariam.two_dimensional;

import Bedemariam.Shape;

 
public abstract class TwoDimensionalShape extends Shape {
    /**
     * To be implemented with the area formula specific to each shape.
     * 
     * @return the result from the calculation of area
     */
    public abstract double area();
}
