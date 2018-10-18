package pizzaorderingsystemnetbeans;

import java.awt.Color;

/**
 * A class that creates a CrispyBacon object.
 * @author up831162
 */
public class CrispyBacon extends Toppings
{    
     /**
    * Constructor of the CrispyBacon object.
    * @param window The window where the CrispyBacon object will be drawn.
    * @param x The x coordinate of the CrispyBacon object.
    * @param y The y coordiante of the CrispyBacon object.
    */
     public CrispyBacon(Canvas window, double x, double y)
     {
         super("Crispy Bacon", 0.02, window, x, y);
     }
     
     @Override
    public void draw(double xCoords, double yCoords)
     {
         int width = 6;
         int height = 30;
         for (int i = 0; i < 5; i++)
         {
            if (i%2 == 0){
                win.setForegroundColor(Color.red);
            } else {
                win.setForegroundColor(Color.pink);
            }
            win.fillRectangle(i * 6 + xCoords, yCoords, width, height);
         }
     }
}
