package pizzaorderingsystemnetbeans;

/**
 * A super class that holds general information about the Pepper and CrispyBacon
 * classes.
 * @author up831162
 */
public class Toppings 
{
    protected Canvas win;
    protected String name;
    protected double price;
    protected double startX;
    protected double startY;
    
     /**
     * Constructor of the super class.
     * @param Name name of the topping.
     * @param Price price of the topping.
     * @param x X coordinate of where to start the topping from.
     * @param y Y coordinate of where to start the topping from.
     */
    public Toppings(String Name, double Price, Canvas window, double x, double y)
    {
        win = window;
        name = Name;
        price = Price;
        startX = x;
        startY = y;
    }
    
    /**
     * Method that returns the name of the topping. 
     */ 
    public String getName()
    {
        return name;
    }
    
    /**
     * Method that returns the price of the topping. 
     */ 
    public double getPrice()
    {
        return price;
    }
    
    /**
     * A method that draws the topping, it will be overriden in the Pepper 
     * and CrispyBacon classes.
     * @param xCoords X coordinates to add to the coordinates of the object that 
     * overrides
     * @param yCoords Y coordinates to add to the coordinates of the object that 
     * overrides
     */
    public void draw(double xCoords, double yCoords){};
} 
