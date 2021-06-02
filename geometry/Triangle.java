/**
 * Triangle.Java 
 * Class that creates a equilateral triangle object
 * @author Christopher Lo
 * @version 1.0
 * May 12, 2021
 */

import java.awt.Color;
import java.awt.Graphics;

class Triangle extends Shape {
  private int length;
  
  /**
   * Triangle constructor
   * @param x The x coordinate of the triangle
   * @param y The y coordinate of the triangle
   * @param color The color of the triangle
   * @param length The length of each side of the triangle
   */
  Triangle(int x, int y, Color color, int length) {
    super(x,y,color);
    this.length = length;
  }
  
  /**
   * draw
   * Method that draws and colors an equilateral triangle 
   * @param g The graphics object
   */
  public void draw(Graphics g) {
    //make 2 arrays for the 3 coordinates
    int [] xcords = {250+getX(),(int)Math.round(250+getX()+this.length/2.0),(int)(250+getX()+this.length)};
    int [] ycords = {250-getY(),(int)Math.round(250-getY()-this.length*Math.sin(Math.PI/3)), 250-getY()};
    g.setColor(getColor());
    g.drawPolygon(xcords,ycords,3);
  }
  
  /**
   * getLength
   * Getter method for the side length of the triangle
   * @return int value for the side length of the triangle
   */
  public int getLength() {
    return this.length;
  }
  
  /**
   * perimeter
   * Method that calculates the perimeter of the traingle by multiplying each equal side by 3
   * @return double value for the perimeter
   */
  public double perimeter() {
    return Math.round(3*this.length*100.0)/100.0;
  }
  
  /**
   * area
   * Method that calculates the area of the triangle by using a formula
   * @return double value for the area
   */
  public double area() {
    return Math.round((Math.sqrt(3)/4)*Math.pow(this.length,2)*100.0)/100.0;
  }
}

