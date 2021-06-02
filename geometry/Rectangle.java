/**
 * Rectangle.Java 
 * Class that creates a quadrilateral with four equal angles
 * @author Christopher Lo
 * @version 1.0
 * May 12, 2021
 */

import java.awt.Color;
import java.awt.Graphics;

class Rectangle extends Shape implements hasHeightAndWidth {
  private int height,width;
  
  /**
   * Rectangle constructor
   * @param x The x coordinate of the rectangle
   * @param y The y coordinate of the rectangle
   * @param color The color of the rectangle
   * @param height The height of the rectangle
   * @param wdith The width of the rectangle
   */
  Rectangle(int x, int y, Color color, int height, int width) {
    super(x,y,color);
    this.height = height;
    this.width = width;
  }
  
  /**
   * draw
   * Method that draws and colors the rectangle
   * @param g The graphics object;
   */
  public void draw(Graphics g) {
    g.setColor(getColor());
    g.drawRect(250+getX(), 250-getY()-this.height, this.width, this.height);
  }
  
  /**
   * getheight
   * Getter method for the height of the rectangle
   * @return int value for the height of the rectangle
   */
  public int getHeight() {
    return this.height;
  }
  
  /**
   * getWidth
   * Getter method for the width of the rectangle
   * @return int value for the width of the rectangle
   */
  public int getWidth() {
    return this.width;
  }
  
  /**
   * perimeter
   * Method that returns the perimeter of the rectangle using the formula 2(w+h)
   * @return double value for the perimeter of the rectangle
   */
  public double perimeter() {
    return Math.round(2*(this.width+this.height)*100.0)/100.0;
  }
  
  /**
   * area
   * Method that returns the area of the of the rectangle using the formula width*height
   * @return double value for the area of the rectangle
   */
  public double area() {
    return Math.round(this.height*this.width*100.0)/100.0;
  }
}

