
package pizzashop;

/**
 * A class that creates different kinds of pizzas
 * depending on their type.
 */
class PizzaFactory 
{
    /**
     * returns a concrete pizza object
     * @param type the type of pizza to return
     * @return 
     */
    public Pizza createPizza(String type)
    {
        Pizza pizza = null;
        if(type.equals("cheese"))
        {
            pizza = new CheesePizza();
        }
        else if (type.equals("pepperoni"))
        {
                pizza = new PepperoniPizza();
        }
        return pizza;
    }
}
