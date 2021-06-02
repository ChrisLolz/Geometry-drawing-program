/**
 * Shape.Java 
 * Abstract class for 2d shapes, serves as a blueprint for all shapes
 * @author Christopher Lo
 * @version 1.0
 * May 12, 2021
 */

import java.awt.Color;
import java.awt.Graphics;

abstract class Shape {
  private int x,y;
  private Color color;
  
  /**
   * Shape constructor
   * @param x The x coordinate of the shape
   * @param y The y coordinate of the shape
   * @param color The color of the shape
   */
  Shape(int x, int y, Color color) { 
    this.x =x;
    this.y =y;
    this.color = color;
  }
  
  /**
   * getX
   * getter method for the x coordinate
   * @return the x coordinate of the shape
   */
  public int getX() {
    return this.x;
  }
  
  /**
   * getY
   * getter method for the y coordinate
   * @return the y coordinate of the shape
   */
  public int getY() {
    return this.y;
  }
  
  /**
   * getcolor
   * getter method for the color of the shape
   * @return the color of the shape
   */
  public Color getColor() {
    return this.color;
  }
  
  /**
   * translateUp
   * method that moves the y coordinate up
   * @param y The number of pixels the y coordinate should move up
   */
  public void translateUp(int y) {
    this.y+=y;
  }
  /**
   * translateDown
   * method that moves the y coordinate down
   * @param y The number of pixels the y coordinate should move down
   */
  public void translateDown(int y) {
    this.y-=y;
  }
  /**
   * translateRight
   * method that moves the x coordinate right
   * @param x The number of pixels the x coordinate should move right
   */
  public void translateRight(int x){
    this.x+=x;
  }
  /**
   * translateLeft
   * method that moves the x coordinate left
   * @param x The number of pixels the x coordinate should move left
   */
  public void translateLeft(int x) {
    this.x-=x;
  }
  
  /**
   * draw
   * Abstract method for drawing the shape
   * @param g The graphics object
   */
  public abstract void draw(Graphics g);
  
  /**
   * area
   * abstract method for getting the area
   * @return double value for the area
   */
  public abstract double area();
  
  /**
   * perimeter
   * abstract method for getting the perimeter
   * @return double value for the area
   */
  public abstract double perimeter();
}
