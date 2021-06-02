/**
 * GeometryDrawingProgram.Java 
 * Program that allows you to draw 2 dimensional shapes on a canvas
 * @author Christopher Lo
 * @version 1.0
 * May 12, 2021
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

class GeometryDrawingProgram {
  
  static JFrame frame;
  static ArrayList<Shape> shapes = new ArrayList<Shape>();//arraylist containing the shapes
  
  //Main method
  public static void main(String[] args) {  
    GeometryScreen gs = new GeometryScreen();
    Scanner input = new Scanner(System.in);
    int option; //This variable is used to store which option is picked in the menu
    boolean running = true;//condition to keep running the program
    
    System.out.println("Welcome to the Gr11 Geometry Drawing Program!(All input is integers, so don't enter non-integers)");
    
    do {
      
      //This deletes the shape if it's too small because if you set a dimension to 0, you won't see anything
      if (shapes.size() > 0) {
        if (shapes.get(shapes.size()-1).area() == 0) {
          shapes.remove(shapes.get(shapes.size()-1));
          System.out.println("The shape you attempted to add was too small, so it has been removed from the list.\n");
        }
      }
   
      try {//try is used to make sure no error happens when entering input in the menu
        System.out.println("Please enter in '1' to display all shapes to console w/ relevant data.");
        System.out.println("Please enter in '2' to add a shape.");
        System.out.println("Please enter in '3' to remove a shape.");
        System.out.println("Please enter in '4' to translate a single shape.");
        System.out.println("Please enter in '5' to translate the entire drawing.");
        System.out.println("Please enter in '6' to quit the program.");
        option = input.nextInt();
        
        if (option == 1) { //display all shapes option
          if (shapes.size() == 0) {//can't show any shapes if you got no shapes
            System.out.println("You have no shapes, please add shapes!\n");
          } else {
            listShapes();
          } 
        }else if (option == 2) {//add shape option
          System.out.println("Please enter in your selection:");
          System.out.println("Please enter in '1' for Circle.");
          System.out.println("Please enter in '2' for Rectangle.");
          System.out.println("Please enter in '3' for Elipse.");
          System.out.println("Please enter in '4' for Square.");
          System.out.println("Please enter in '5' for Rhombus.");
          System.out.println("Please enter in '6' for Parallelogram.");
          System.out.println("Please enter in '7' for Triangle.");
          option = input.nextInt();
          
          System.out.println("Red color(0-255)?");
          int red = input.nextInt(); 
          //if the color is out of range, it will default to 0 to stop errors
          if ( (red > 255) || (red<0) ) {
            System.out.println("There is an invalid red color, red will be set to 0");
            red = 0;
          }
          System.out.println("Green color(0-255)?");
          int green = input.nextInt();
          if ( (green > 255) || (green<0) ) {
            System.out.println("There is an invalid green color, green will be set to 0");
            green = 0;
          }
          System.out.println("Blue color(0-255)?");
          int blue = input.nextInt();
          if ( (blue > 255) || (blue<0) ) {
            System.out.println("There is an invalid blue color, blue will be set to 0");
            blue = 0;
          }
          System.out.println("x-coordinate?");
          int x = input.nextInt();
          System.out.println("y-coordnate?");
          int y = input.nextInt();
          if (option == 1) {//add circle
            System.out.println("Diameter? (must be >=2)");
            int diameter = input.nextInt();
            shapes.add(new Circle(x,y,new Color(red,green,blue),diameter));
          } else if (option == 2) {//add rectangle
            System.out.println("Height? (must be >=1)");
            int height = input.nextInt();
            System.out.println("Width? (must be >=1)");
            int width = input.nextInt();
            shapes.add(new Rectangle(x,y,new Color(red,green,blue),height,width));
          } else if (option == 3) {//add elipse
            System.out.println("Height? (must be >=2)");
            int height = input.nextInt();
            System.out.println("Width? (must be >=2)");
            int width = input.nextInt();
            shapes.add(new Elipse(x,y,new Color(red,green,blue),height,width));
          } else if (option == 4) {//add square
            System.out.println("Side length? (must be >=1)");
            int length = input.nextInt();
            shapes.add(new Square(x,y,new Color(red,green,blue),length));
          } else if (option == 5) {//add rhombus
            System.out.println("Side length? (must be >=1)");
            int length = input.nextInt();
            shapes.add(new Rhombus(x,y,new Color(red,green,blue),length));
          } else if (option == 6) {//add parallelogram
            System.out.println("Side length? (must be >=1)");
            int side = input.nextInt();
            System.out.println("Base? (must be >=1)");
            int base = input.nextInt();
            shapes.add(new Parallelogram(x,y,new Color(red,green,blue),side,base));
          } else if (option == 7) {//add triangle
            System.out.println("Side length? (must be >=1)");
            int length = input.nextInt();
            shapes.add(new Triangle(x,y,new Color(red,green,blue),length));
          }
        } else if (option == 3) {//remove shape option
          if (shapes.size() == 0) {
            System.out.println("You have no shapes, please add shapes!\n");
          } else {
            listShapes();
            System.out.println("Select the shape you want to delete or enter 0 to cancel");
            option = input.nextInt();
            try {
              if (option != 0) {
                shapes.remove(option-1);
                System.out.println("Shape removed sucessfully!\n");
              }
            } catch (ArrayIndexOutOfBoundsException e) { //catch error for entering a gigantic number
              System.out.println("Invalid selection, please try again.\n");
            } catch (IndexOutOfBoundsException e) {//catch error for entering a shape that doesn't exist in that index
              System.out.println("Invalid selection, please try again.\n");
            }
          }
        } else if (option == 4) {//translate a shape option
          if (shapes.size() == 0) {
            System.out.println("You have no shapes, please add shapes!\n");
          } else {
            listShapes();
            System.out.println("Chose a shape you want to translate:");
            option = input.nextInt();
            try {
              shapes.get(option-1);//make sure the shape actually exists to check for error
              System.out.println("How many pixels do you want to translate up?");
              shapes.get(option-1).translateUp(input.nextInt()); 
              System.out.println("How many pixels do you want to translate down?");
              shapes.get(option-1).translateDown(input.nextInt());
              System.out.println("How many pixels do you want to translate right?");
              shapes.get(option-1).translateRight(input.nextInt());
              System.out.println("How many pixels do you want to translate left?");
              shapes.get(option-1).translateLeft(input.nextInt());
              System.out.println("Shape successfully translated!\n");
            } catch (ArrayIndexOutOfBoundsException e) {//catch error for entering a gigantic number
              System.out.println("Invalid selection, please try again.\n");
            } catch (IndexOutOfBoundsException e) {//catch error for entering a shape that doesn't exist in that index
              System.out.println("Invalid selection, please try again.\n");
            }
          }
        } else if (option == 5) {//translate all shapes in canvas option
          if (shapes.size() == 0) {
            System.out.println("You have no shapes, please add shapes!\n");
          } else {
            listShapes();
            System.out.println("How many pixels do you want to translate up?");
            option = input.nextInt();
            for (int i=0; i<shapes.size(); i++) {//loop through all shapes and translate each one
              shapes.get(i).translateUp(option); 
            }
            System.out.println("How many pixels do you want to translate down?");
            option = input.nextInt();
            for (int i=0; i<shapes.size(); i++) {
              shapes.get(i).translateDown(option); 
            }
            System.out.println("How many pixels do you want to translate right?");
            option = input.nextInt();
            for (int i=0; i<shapes.size(); i++) {
              shapes.get(i).translateRight(option); 
            }
            System.out.println("How many pixels do you want to translate left?");
            option = input.nextInt();
            for (int i=0; i<shapes.size(); i++) {
              shapes.get(i).translateLeft(option); 
            }
            System.out.println("Shapes successfully translated!\n");
          }
        } else if (option == 6) {//quit option
          running = false;//program is no longer running
          System.out.println("\nThank you for using my program!");
        } else {//else statement if the user doesn't select the an option from the menu
          System.out.println("Please enter a valid option");
        }
      } catch (InputMismatchException e) {//catch any errors in the program if the user enters a non-integer such as entering string by mistake
        System.out.println("Error: User entered a non-integer, please try again.\n");
        input.nextLine();//takes the non-integer number to throw it away
      }
      frame.repaint(); //update the screen
    }while(running == true);
    
    input.close();//close input 
    frame.dispose();//close screen
  }

  /**
   * listShapes
   * Method that displays all shapes in the array to the menu
   */
  public static void listShapes() {
    for (int i = 0; i<shapes.size(); i++) {
      Shape shape = shapes.get(i);//shortcut variable to refer to the shape
      System.out.print("# " + (i+1));
      System.out.print(" Type: " + shape.getClass().getName() + ", ");
      System.out.print("Area: " + shape.area() + ", ");
      System.out.print("Perimeter: " + shape.perimeter() + ", ");
      System.out.print("Color RGB: " + "(" + shape.getColor().getRed() + "," + shape.getColor().getGreen() + "," + shape.getColor().getBlue() + "), ");
      System.out.print("Bottom Left Vertex:" + "(" + shape.getX() + "," + shape.getY() + "), ");
      if (shape instanceof Rectangle) {//Also includes squares
        System.out.print("Height: " + ((Rectangle)shape).getHeight() + ", ");
        System.out.println("Width: " + ((Rectangle)shape).getWidth());
      } else if (shape instanceof Elipse){//Also includes circles
        System.out.print("Height: " + ((Elipse)shape).getHeight() + ", ");
        System.out.println("Width: " + ((Elipse)shape).getWidth());
      }else if (shape instanceof Parallelogram) {//Also includes rhombus's
        System.out.print("Side length: " + ((Parallelogram)shape).getSide() + ", ");
        System.out.println("Base: " + ((Parallelogram)shape).getBase());
      } else if (shape instanceof Triangle) {
        System.out.println("Side length: " + ((Triangle)shape).getLength());
      }
    }
  }
  
  /**
   * GeometryScreen.java
   * Creates the canvas for drawing
   * @author Christopher
   * May 12, 2021
   */
  public static class GeometryScreen {
    
    /**
     * GeometryScreen constructor
     * Creates the JFrame
     */
    GeometryScreen() {
      frame = new JFrame("Geometry Drawing Program 1.0");
      
      //Create a new "custom" panel for graphics based on the inner class below
      JPanel graphicsPanel = new GraphicsPanel();
      
      //Add the panel and the frame to the window
      frame.getContentPane().add(graphicsPanel);
      
      // Set the frame to full screen 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(520,540);
      frame.setUndecorated(false);  //Set to true to remove title bar
      frame.setVisible(true);
    }
  } 
  
  /**
   * GraphicsPanel.java
   * This is an inner class which contains all the details about drawing to screen.
   * @author Christopher Lo
   * May 12, 2021
   */
  public static class GraphicsPanel extends JPanel {
    
    /**
     * paintComponent
     * The method that draws to the screen
     * @param g The graphics object
     */
    public void paintComponent(Graphics g) {          
      setDoubleBuffered(true);   
      g.setColor(Color.BLACK);
      //draw the X/Y Axis
      g.drawLine(250, 0, 250, 500);
      g.drawLine(0, 250, 500, 250);
      for (int i =0; i<shapes.size(); i++) {
        shapes.get(i).draw(g);//draws all shapes in the list every loop
      }
    }
  }
}