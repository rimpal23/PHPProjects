
package pizzashop;

import java.util.ArrayList;


public class Pizza 
{
    private int bakeTemp = 100;//temp to bake at
    private ArrayList<String> ingredients = new ArrayList();
    public void bake(int temp)
    {
        bakeTemp = temp;
        //do some baking here, code not implemented yet
        //not necessary for the review
    }
    /**
     *  A method to add toppings to the ingredients
     * list
     * @param topping 
     */
    public void addTopping(String topping)
    {
        ingredients.add(topping);
    }
 //   public void setTemp(int temp){
   //     bakeTemp=temp;
   // }
    public int getTemp(){
        return bakeTemp;
    }
}
