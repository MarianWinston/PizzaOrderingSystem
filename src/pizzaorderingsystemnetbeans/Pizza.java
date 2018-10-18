package pizzaorderingsystemnetbeans;

import java.awt.*;

/**
 * Class that holds all the information about a single pizza.
 * @author up831162
 */
public class Pizza 
{
    private Canvas window;
    private double CenterX;
    private double CenterY;
    private Toppings topping1 = null;
    private Toppings topping2 = null;
    private Size size;
    private Sauce sauce;
    private Crust crust;

    /**
     * First constructor for pizza, in case the pizza doesn't have any toppings.
     * @param win Window where the pizza will be drawn on.
     * @param startX The top-left x coordinate for the section of screen to draw 
     * pizza on
     * @param startY The top-left y coordinate for the section of screen to draw 
     * pizza on
     * @param siz The Size type parameter that will be passed to the pizza.
     * @param sauc The Sauce type parameter that will be passed to the pizza.
     * @param crus The Crust type parameter that will be passed to the pizza.
     */
    public Pizza(Canvas win, double startX, double startY, Size siz, Sauce sauc,
                 Crust crus)
    {        
        window = win;
        CenterX = startX + 150;
        CenterY = startY + 150;
        size = siz;
        sauce = sauc;
        crust = crus;   
    }
    
    /**
     * Second constructor, for a pizza with only one topping.
     * @param win Window where the pizza will be drawn on.
     * @param startX The top-left x coordinate for the section of screen to 
     * draw pizza the on.
     * @param startY The top-left y coordinate for the section of screen to 
     * draw pizza the on.
     * @param toppingOne The Topping object in case of one topping only choice.
     * @param siz The Size type parameter that will be passed to the pizza.
     * @param sauc The Sauce type parameter that will be passed to the pizza.
     * @param crus The Crust type parameter that will be passed to the pizza.
     */
    public Pizza(Canvas win, double startX, double startY, Size siz, Sauce sauc, 
                 Crust crus, Toppings toppingOne)
    {        
        window = win;
        CenterX = startX + 150;
        CenterY = startY + 150;
        topping1 = toppingOne;
        size = siz;
        sauce = sauc;
        crust = crus;
    }
    
    /**
     * Third constructor. for the pizza with only one topping.
     * @param win Window where the pizza will be drawn on.
     * @param startX The top-left x coordinate for the section of screen to 
     * draw pizza the on.
     * @param startY The top-left y coordinate for the section of screen to 
     * draw pizza the on.
     * @param toppingOne The Topping object in case of one topping only choice.
     * @param toppingTwo The second Topping object in case of two toppings choice.
     * @param siz The Size type parameter that will be passed to the pizza.
     * @param sauc The Sauce type parameter that will be passed to the pizza.
     * @param crus The Crust type parameter that will be passed to the pizza.
     */
    public Pizza(Canvas win, double startX, double startY, Size siz, Sauce sauc, 
                 Crust crus, Toppings toppingOne, Toppings toppingTwo)
    {        
        window = win;
        CenterX = startX + 150;
        CenterY = startY + 150;
        topping1 = toppingOne;
        topping2 = toppingTwo;
        size = siz;
        sauce = sauc;
        crust = crus;
        
    }
    
    /**
     * Empty Constructor, used so I can call a new Pizza object without parameters.
     */
    public Pizza(){}
    
    /**
     * Method to draw the pizza and it's information on the screen.
     * @param index Index of the pizza to display information of.
     */
     public void displayPizza(int index)
    {
        drawPizza();
        drawTopLine(index);
        drawBottomLine();
        drawToppings();
    }
    
    /**
     * Method that returns the price of a pizza considering it's size, crust, 
     * sauce type and price of toppings.
     */ 
    public double getPizzaPrice()
    {
        double totPrice = crust.getPrice() * Math.PI * 
                          Math.pow(size.getRadius(), 2) + sauce.getPrice();
        if(topping1 != null)
        {
            totPrice += 5*topping1.getPrice();
            
            if(topping2 != null)
            {
                totPrice += 4*topping2.getPrice();
            }
        }
        return totPrice;
    }
    
    /**
     * Method that returns the Size of a pizza.
     */ 
    public Size getSize()
    {
        return size;
    }
    
    /**
     * Method to display the pizza on the screen.
     */
    private void drawPizza()
    {
        window.setForegroundColor(Color.YELLOW);
        window.fillCircle(CenterX, CenterY, 200);
        crust.drawCrust(sauce, window, CenterX, CenterY);
    }
    
    /**
     * Method to display the toppings on the pizza.
     */
    private void drawToppings()
    {
        if (topping1 != null){
            double topLeftX = CenterX - 50;
            double topLeftY = CenterY - 50;
            for(int y = 0; y < 3; y++)
            {
                for(int x = 0; x < 3; x++)
                {
                    if((x%2 == 0 && y%2 == 0) || (x%2 == 1 && y%2 == 1))
                        topping1.draw(topLeftX + x*35, topLeftY + y*35); 
                    else if (topping2 != null)
                        topping2.draw(topLeftX + x*35, topLeftY + y*35);
                }
            }
        }
    }
    
    /**
     * Method to write the information shown in the bottom line of the 
     * individual pizza on the screen. 
     * This method will display the pizza number and size at the top of the 
     * screen.
     */
    private void drawTopLine(int index)
    {
        String topLine = "Pizza " + index + ":    " + size.getName();
                
        double stringX = CenterX-140;
        double stringY = CenterY-115;
        
        window.setForegroundColor(Color.BLACK);
        window.setFontSize(15);
        window.drawString(topLine, stringX, stringY);
    }
    
    /**
     * Method to write the information shown in the bottom line of the 
     * individual pizza on the screen.  
     * This method will display the type of crust and sauce ordered.
     */
    private void drawBottomLine()
    {
        String bottomLine = "   Crust: " + crust.getName() + "       Sauce: " 
                + sauce.getName();
                
        double stringX = CenterX-140;
        double stringY = CenterY+140;
        
        window.setForegroundColor(Color.BLACK);
        window.setFontSize(15);
        window.drawString(bottomLine, stringX, stringY);
    }  
}
