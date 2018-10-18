package pizzaorderingsystemnetbeans;

/**
 * Class to start the running of the Pizza Ordering System.  You should not 
 * need to change this class
 * @author up831162
 */
public class PizzaMain 
{

    public static void main(String[] args) 
    {
        OrderingSystem orders = new OrderingSystem();
        orders.drawOrderScreen();
        orders.startOrdering();
    }
    
}
