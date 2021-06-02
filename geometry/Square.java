/**
 * Square.Java 
 * Class that creates a quadrilateral with four equal angles and sides
 * @author Christopher Lo
 * @version 1.0
 * May 12, 2021
 */

import java.awt.Color;

class Square extends Rectangle {
  
  /**
   * Square constructor
   * @param x The x coordinate of the square
   * @param y The y coordinate of the square
   * @param color The color of the square
   * @param length The length of each side of the square
   */
  Square(int x, int y, Color color, int length) {
    super(x,y,color,length,length);//A square is just a rectangle with the same height and width
  }
  
}