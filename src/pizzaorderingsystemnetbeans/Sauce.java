package pizzaorderingsystemnetbeans;

/**
 * An enum class to hold informations about the possible sauce choices.
 * @author up831162
 */
public enum Sauce {
    TOMATO("Tomato", 0), 
    BBQ("BBQ", 0.5);
    
    private String name;
    private double price;
    
    /**
     * Constructor of the enum.
     * @param Name Name of the sauce type.
     * @param Price Price of the sauce type.
     */
    Sauce(String Name, double Price)
    {
        name = Name;
        price = Price;
    }
    
    /**
     * A method that returns the name of the sauce.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * A method that returns the price of the sauce.
     */
    public double getPrice()
    {
        return price;
    }
}
