
package pizzashop;

/**
 * A class to model pizzas that have cheese and 
 * pepperoni
 */
/**
 * Dry principle is not being implemented .
 * The bake method is used twice in pepperoniPizza and cheesePizza class.
 * So there is no need of bake method.
 * Secondly, open closed principle is not implemented . For this, i made the baketemp attribute private
 * and created setter methods for inheriting the value.
 */
public class PepperoniPizza extends Pizza
{
    public PepperoniPizza()
    {
        super();
        super.addTopping("cheese");
        super.addTopping("pepperoni");
        super.getTemp();
    }
    
    /**public void bake(int temp)
    {
        super.getTemp();
        //do some baking here, code not implemented yet
        //not necessary for the review
    }*/
}
