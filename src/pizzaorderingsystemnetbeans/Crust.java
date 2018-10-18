package pizzaorderingsystemnetbeans;

import java.awt.Color;

/**
 * An enum class to hold informations about the possible crust choices.
 * @author up831162
 */
public enum Crust 
{
    THINCRUST("Thin crust", 0.08),
    DEEPPAN("Deep pan", 0.11),  
    STUFFEDCRUST("Stuffed crust", 0.14);
    
    private String name;
    private double price;
    
     /**
     * Constructor of the enum.
     * @param Name Name of the crust type.
     * @param Price Price of the crust type.
     */
    Crust(String Name, double Price)
    {
        name = Name;
        price = Price;
    }
    
    /**
     * A method that returns the name of the crust.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * A method that returns the price of the crust.
     */
    public double getPrice()
    {
        return price;
    }
    
    /**
     * A method that draws the crust and the sauce.
     * @param sauce Sauce the pizza will have.
     * @param win Window the crust will be drawn on.
     * @param x X coordinates it will be drawn at.
     * @param y Y coordinates it will be drawn at.
     */
    public void drawCrust(Sauce sauce, Canvas win, double x, double y)
    {
        if(sauce.getName() == "Tomato") 
        {
            win.setForegroundColor(Color.RED);
        } else {
            win.setForegroundColor(Color.ORANGE);
        }
        
        win.fillCircle(x, y, 175);
        win.setForegroundColor(Color.WHITE);
        win.fillCircle(x, y, 150);
    }
}
