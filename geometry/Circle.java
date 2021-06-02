/**
 * Circle.Java 
 * Class that creates a circle object
 * @author Christopher Lo
 * @version 1.0
 * May 12, 2021
 */

import java.awt.Color;

class Circle extends Elipse {
  
  /**
   * Circle constructor
   * @param x The x coordinate of the circle
   * @param y The y coordinate of the circle
   * @param color The color of the circle
   * @param diameter The diameter of the circle
   */
  Circle(int x, int y, Color color, int diameter) {
    super(x,y,color,diameter,diameter); //A circle is just an ellipse but with the same height and width
  }
  
}