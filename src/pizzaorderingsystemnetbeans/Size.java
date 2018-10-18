package pizzaorderingsystemnetbeans;

/**
 * An enum class to hold informations about the possible size choices.
 * @author up831162
 */
public enum Size {
    SMALL("Small", 5),
    MEDIUM("Medium", 6), 
    LARGE("Large", 7);
    
    private String name;
    private int radius;
    
    /**
     * Constructor of the enum.
     * @param Name Name of the size type.
     * @param Radius Radius of the pizza.
     */
    Size(String Name, int Radius)
    {
        name = Name;
        radius = Radius;
    }
    
    /**
     * A method that returns the radius of the pizza.
     */
    public int getRadius()
    {
        return radius;
    }
    
    /**
     * A method that returns the name of the size.
     */
    public String getName()
    {
        return name;
    }
}
