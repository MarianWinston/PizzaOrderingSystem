package pizzaorderingsystemnetbeans;

import java.awt.*;
import java.util.*;

/**
 * Class that manages the pizza orders.
 * @author up831162
 */
public class OrderingSystem 
{
    private Canvas window;
    private ArrayList<Pizza> pizzas;
    private KeyboardInput queries;
    private int x = 0;
    private int y = 0;
    
    /**
     * Constructor for the pizza ordering system.
     */
    public OrderingSystem()
    {
        window = new Canvas("Pizza Ordering", 900, 650);
        pizzas = new ArrayList<>();
        queries = new KeyboardInput();
    }
    
    /**
     * Method to draw the outline of the order screen.
     */
    public void drawOrderScreen()
    {
        window.setForegroundColor(Color.BLACK);
        // vertical dividers
        window.drawLine(300, 0, 300, 600);
        window.drawLine(600, 0, 600, 600);
        
        // halfway divider
        window.drawLine(0, 300, 900, 300);
        
        // total price line
        window.drawLine(0, 600, 900, 600);
        window.setFontSize(25);
        window.drawString("Total Price of the Order: £0.00", 10, 640);
        
    }
    
    /**
     * Method to draw a white rectangle on top of the bottom pricing string.
     */
    public void drawtotprice()
    {   
        window.setForegroundColor(Color.white);
        window.fillRectangle(0, 601, 899, 649);
    }
    
    /**
     * Method to change the x and y coordinates of the pizzas as a new order is 
     * made.
     */
    public void modifyXY()
    {
        if(x<600)
        {
            x+=300;
        } else if (y == 0)
        {
            x = 0;
            y += 300;
        }      
    }
    
    /**
     * Method to manage the ordering of each pizza.
     */
    public void startOrdering()
    {   
        boolean anyMorePizzas = false;
        
        while (!anyMorePizzas && pizzas.size() < 6)
        {
            Inputs inputs = new Inputs();
            Pizza pizza = new Pizza();
            Size size = inputs.getSize();
            Sauce sauce = inputs.getSauce();
            Crust crust = inputs.getCrust();
            String howMany = inputs.getHowManyToppings();
            
            if (howMany.equals("1"))
            
            {
                Toppings toppings = inputs.getToppings(window, x, y);
                pizza = new Pizza(window, x, y, size, sauce, crust, toppings);
                pizzas.add(pizza);
                
            } else if (howMany.equals("2")) {
                
                Toppings toppings = inputs.getToppings(window, x, y);
                Toppings toppings2 = inputs.getToppings(window, x, y);
                pizza = new Pizza(window, x, y, size, sauce, crust, toppings, toppings2);
                pizzas.add(pizza);
                
            } else {
            
                pizza = new Pizza(window, x, y, size, sauce, crust);
                pizzas.add(pizza);
            }
            
            pizza.displayPizza(pizzas.indexOf(pizza) + 1);
            modifyXY();
            
            double totPrice = 0;
            
            for (Pizza element: pizzas) 
            {
                totPrice += element.getPizzaPrice();
                double totPrice2 = Math.round(totPrice * 100.0) / 100.0;
                String totPriceString = String.valueOf(totPrice2);
                
                drawtotprice();
                
                window.setForegroundColor(Color.BLACK);
                window.setFontSize(25);
                window.drawString("Total Price of the Order: £" + totPriceString, 10, 640);
            }
            
            System.out.println("Would you like to order another pizza? (1. Yes, 2. No)");
            String anotherPizza = queries.getInputString();

            if (!anotherPizza.equals("1")) 
            {
                anyMorePizzas = true;
            }    
        }
    }
}
