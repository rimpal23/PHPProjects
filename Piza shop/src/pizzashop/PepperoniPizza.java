/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzashop;

/**
 * A class to model pizzas that have cheese and 
 * pepperoni
 * Note that the following source was used as a reference in 
 * creating this example:
 * Freeman, E.Freeman, E., Sierra, K., & Bates, B. (2004). Head First Design patterns. Sebastopol, CA: O'Reilly.
 * @author dancye
 */
/**
 * Dry principle is not being implemented .
 * The bake method is used twice in pepperoniPizza and cheesePizza class.
 * So there is no need of bake method.
 * Secondly, open closed principle is not implemented . For this, i made the baketemp attribute private
 * and created setter methods for inheriting the value.
 * @author jugra
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
