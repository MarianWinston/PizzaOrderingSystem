package pizzaorderingsystemnetbeans;

import java.awt.Color;

/**
 * A class that creates a Pepper object.
 * @author up831162
 */
public class Pepper extends Toppings
{   
    
    /**
    * Constructor of the Pepper object.
    * @param window The window where the Pepper object will be drawn.
    * @param x The x coordinate of the Pepper object.
    * @param y The y coordiante of the Pepper object.
    */
    public Pepper(Canvas window, double x, double y)
    {
        super("Pepper", 0.02, window, x, y);
    }
    
    @Override
    public void draw(double xCoords, double yCoords)
    {
        win.setForegroundColor(Color.orange);
        win.fillCircle(10 + xCoords, 10 + yCoords, 20);
        win.fillCircle(25 + xCoords, 10 + yCoords, 20);
        win.fillCircle(17.5 + xCoords, 20 + yCoords, 20);
        
        win.setForegroundColor(Color.white);
        win.fillCircle(10 + xCoords, 10 + yCoords, 16);
        win.fillCircle(25 + xCoords, 10 + yCoords, 16);
        win.fillCircle(17.5 + xCoords, 20 + yCoords, 16);
    }
}   

