/**
 * Rhombus.Java 
 * Class that creates a quadrilateral object with four equal sides and two pairs of parallel sides
 * @author Christopher Lo
 * @version 1.0
 * May 11, 2021
 */

import java.awt.Color;

class Rhombus extends Parallelogram {
  
  /**
   * Rhombus constructor
   * @param x The x coordinate of the rhombus
   * @param y The y coordinate of the rhombus
   * @param color The color of the rhombus
   * @param length The length of each of the rhombus
   */
  Rhombus(int x, int y, Color color, int length) {
    super(x,y,color,length,length);//Rhombus is just a parallelogram with the same base and side length
  }
  
}