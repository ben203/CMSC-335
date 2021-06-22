  /**
  * Name: Bedemariam Degef
  * Project: Project 2 
  * Date: 02/08/21
  * Purpose: Class to be extended by Sphere, Cube, Cone, Cylinder, and Torus. Made
 * 			 abstract as no instantiations of this class will be needed and implementation
 * 			of the volume() will depend on child class.
 */

package Bedemariam.three_dimensional;

import Bedemariam.Shape;

 

public abstract class ThreeDimensionalShape extends Shape {
   /**
    * To be implemented with the volume formula specific to each shape.
    * 
    * @return the result from the calculation of volume
    */
   public abstract double volume();
}
