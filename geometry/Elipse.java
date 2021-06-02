/**
 * Rectangle.Java 
 * Class that creates an elipse object
 * @author Christopher Lo
 * @version 1.0
 * May 12, 2021
 */

import java.awt.Color;
import java.awt.Graphics;

class Elipse extends Shape implements hasHeightAndWidth{
  private int height,width;
  
  /**
   * Elipse constructor
   * @param x The x coordinate of the elipse
   * @param y The y coordinate of the elipse
   * @param color The color of the elipse
   * @param height The height of the elipse
   * @param width The width of the elipse
   */
  Elipse(int x, int y, Color color, int height, int width) {
    super(x,y,color);
    this.height = height;
    this.width = width;
  }
  
  /**
   * draw
   * Method that draws and colors the elipse
   * @param g The graphics object
   */
  public void draw(Graphics g) {
    g.setColor(getColor());
    g.drawOval(250+getX(), 250-getY()-this.height, this.width, this.height);
  }
  
  /**
   * getHeight
   * Getter method that returns the height of the elipse
   * @return int value for the height of the elipse
   */
  public int getHeight() {
    return this.height;
  }
  
  /**
   * getWidth
   * Getter method that returns the width of the elipse
   * @return int value for the width of the elipse
   */
  public int getWidth() {
    return this.width;
  }
  
  /**
   * perimeter
   * Method that uses a formula to approximate the area of the ellipse
   * @return the perimeter/circumference of the elipse
   */
  public double perimeter() {
    double a = this.width/2.0; //a is the horizontal radius
    double b = this.height/2.0; //b is the vertical radius
    double h = (Math.pow(a-b,2))/(Math.pow(a+b,2));//h is part of the formula
    return Math.round(Math.PI*(a+b)*(1+((3*h)/(10+Math.sqrt(4-3*h))))*100.0)/100.0; //return perimeter
  }
  
  /**
   * area
   * Method that calculates the area of the elipse using pi*radius1*radius2
   * @return the area of the elipse
   */
  public double area() {
    return Math.round(Math.PI*(this.width/2)*(this.height/2)*100.0)/100.0;
  }
}

