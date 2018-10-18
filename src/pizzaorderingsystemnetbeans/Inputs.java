package pizzaorderingsystemnetbeans;
import java.util.*;

/**
 * A class that sets the inputs of the ordering system application.
 * @author up831162
 */
public class Inputs 
{
    private ArrayList<String>  questions;
    private String[][] answers;
    private KeyboardInput input;
    
     /**
     * Constructor of the inputs class.
     */
    public Inputs()
    {   
        
        input = new KeyboardInput();
        questions = new ArrayList<>(Arrays.asList(new String[]
        {
            "Choose your pizza by answering the questions underneath," + System.lineSeparator() + 
            "use only 1, 2 and 3 keys to give your answers." + System.lineSeparator() + "" + System.lineSeparator() +
            "What size would you like your pizza to have? (1. Small (10''), 2. Medium (12''), 3. Large (14'')): ",
            "What type of crust would you like to have? (1. Deep Pan , 2. Thin Crust, 3. Stuffed Crust): ",
            "BBQ Sauce instead of tomato? (1. Yes, 2. No): ",
            "How many toppings? (1. One, 2. Two, 3. None): ",
            "What toppings would you like to add to your pizza? (1. Crispy Bacon, 2. Pepper ): "
        }
        ));
        answers = new String[][] {
            {"1", "2", "3"},
            {"1", "2", "3"},
            {"1", "2"},
            {"1", "2", "3"},
            {"1", "2"}
        };
    }
    
    
    /**
    * A method that returns the input of the user and gives an error message
    * if the input is wrong.
    * @param index Index of the questions and answers in the lists.
    */
    public String checkInput(int index)
    {
        boolean right = false;
        String userInput = null;
        
        do{
            System.out.println(questions.get(index));
            userInput = input.getInputString();
            for(int i = 0; i < answers[index].length; i++)
            {
                if(answers[index][i].equals(userInput))
                {
                    right = true;
                    break;
                }
            }
            if(!right)
                System.out.println("Invalid answer! Enter a valid one.");  
        }while(!right);
        return userInput;
    }
    
    /**
    * A method that returns the size of the pizza after the user input.
    */
    public Size getSize()
    {
        Size pizzaSize = null;
        String checkSize = checkInput(0);
        if (checkSize.equals("1"))
        {
            pizzaSize = Size.SMALL;
        } else if (checkSize.equals("2")){
            pizzaSize = Size.MEDIUM;
        } else if (checkSize.equals("3")){
            pizzaSize = Size.LARGE;
        }
        
        return pizzaSize;    
    }
    
    /**
    * A method that returns the crust of the pizza after the user input.
    */
    public Crust getCrust()
    {
        Crust pizzaCrust = null;
        String checkCrust = checkInput(1);
        
        if (checkCrust.equalsIgnoreCase("1"))
        {
            pizzaCrust = Crust.DEEPPAN;
        } else if (checkCrust.equals("2")) {
            pizzaCrust = Crust.THINCRUST;
        } else if (checkCrust.equals("3")) {
            pizzaCrust = Crust.STUFFEDCRUST;
        }
        
        return pizzaCrust;
    }
    
    /**
    * A method that returns the sauce of the pizza after the user input.
    */
    public Sauce getSauce()
    {
        Sauce pizzaSauce = null;
        String checkSauce = checkInput(2);
        
        if (checkSauce.equals("1"))
        {
            pizzaSauce = Sauce.BBQ;
        } else if (checkSauce.equals("2")) {
            pizzaSauce = Sauce.TOMATO;
        }
        
        return pizzaSauce;
    }
    
    /**
    * A method that returns how many toppings the user chose.
    */
    public String getHowManyToppings()
    {
        String howMany = checkInput(3);
        return howMany;
    }
    
    /**
    * A method that returns the toppings the user chose.
    */
    public Toppings getToppings(Canvas win, int xCoord, int yCoord)
    {
        Toppings topping = null;
        String checkToppings = checkInput(4);
        
        if (checkToppings.equals("1"))
        {
            topping = new CrispyBacon(win, xCoord, yCoord);
        } else if (checkToppings.equals("2")) {
            topping = new Pepper(win, xCoord, yCoord);
        }
        return topping;
    }         
}

