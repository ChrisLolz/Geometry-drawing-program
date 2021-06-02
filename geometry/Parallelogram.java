/**
 * Parallelogram.Java 
 * Class that creates a quadrilateral with two pairs of parallel sides
 * @author Christopher Lo
 * @version 1.0
 * May 12, 2021
 */

import java.awt.Color;
import java.awt.Graphics;

class Parallelogram extends Shape {
  private int side,base;
  
  /**
   * Parallelogram constructor
   * @param x The x coordinate of the parallelogram
   * @param y The y coordinate of the parallelogram
   * @param color The color of the parallelogram
   * @param side The length of the slanted side 
   * @param base The length of the horizontal side
   */
  Parallelogram(int x, int y, Color color, int side, int base) {
    super(x,y,color);
    this.side = side;
    this.base = base;
  }
  
  /**
   * draw
   * Method that draws and colors the parallelogram
   * @param g The graphics object
   */
  public void draw(Graphics g) {
    g.setColor(getColor());
    int [] xcords = new int[4];//store the 4 x coordinates in an array
    int [] ycords = new int[4];//store the 4 y coordinates in an array
    xcords[0] = 250+getX();//bottom left corner
    ycords[0] = 250-getY();
    xcords[1] = (int)Math.round(250+getX()+this.side*Math.cos(Math.PI/4));//top left corner
    ycords[1] = (int)Math.round(250-getY()-this.side*Math.sin(Math.PI/4));
    xcords[2] = xcords[1]+this.base;//top right corner
    ycords[2] = ycords[1];
    xcords[3] = xcords[0]+this.base;//bottom right corner
    ycords[3] = ycords[0];
    g.drawPolygon(xcords,ycords,4);
  }
  
  /**
   * getBase
   * Getter method that returns the value of the base of the parallelogram
   * @return int value for the base
   */
  public int getBase() {
    return this.base;
  }
  
  /**
   * getSide
   * Getter method that returns the value of the slanted side of the parallelogram
   * @return int value for the side of the parallelogram
   */
  public int getSide() {
    return this.side;
  }
  
  /**
   * perimeter
   * Method that returns the perimeter of the parallelogram using the same formula as the rectangle
   * @return double value for the perimeter of the parallelogram
   */
  public double perimeter() {
    return 2*(this.base+this.side);
  }
  
  /**
   * area
   * Method that returns the area of the parallelogram by getting the height and multiplying it by the base
   * @return double value for the area of the parallelogram
   */
  public double area() {
    return Math.round(this.side*Math.sin(Math.PI/4)*this.base*100.0)/100.0;
  }
}

