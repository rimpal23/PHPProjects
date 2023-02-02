/*Rimpaldeep Kaur Dhillon
 *991528804
 */
package coinflip;
public class CoinFlip {
    private static boolean flips[]= new boolean[100];//array to by
    // used by all methods
    private static int i=0;//declaring various static variables
    private static int heads=0;
    private static int tails=0;
    private static int roh=0;
    private static int rot=0;
    private static int result=0;
     private static int result1=0;
   /**
    * this method flips the coin
    */  
     public static void flipIt(){
        for(int i=0;i<flips.length;i++){
        if(Math.random()>0.5){
            store(true);//calling store method
            }
        else{
            store(false);
        }}
            }
     /**
     * @param a 
     */
    private static void store(boolean a){
        flips[i]=a;//storing the result
        i++;
        }
     /**
      * prints out the results: no of heads , tails, 
      * longest run of heads and tails
      */  
     public static void display(){
         //calculating result of coinflip
          for(int i=0;i<flips.length;i++){
              if(flips[i]==true){
                  System.out.print(" heads ");
                  ;
                          heads++;
                  }
              else{
                  System.out.print(" Tails ");
                  tails++;
              }
          }
          System.out.println("");
          System.out.println("Heads count is "+heads);
         
          System.out.println("Tails count is "+tails);
          //calculating longest run of heads
          int i=0;
          while(i<flips.length){
          while(i<flips.length && flips[i]==true){
              i++;
              result++;
          }
          if(result>roh){
              roh=result;
              result=0;
          }
          i++;
      }
          System.out.println("Longest run of heads is "+roh);   
        //calculating longest run of tails
          i=0;
          while(i<flips.length){
          while(i<flips.length && flips[i]==false){
              i++;
              result1++;
          }
          if(result1>rot){
              rot=result1;
              result1=0;
          }
          i++;
      }
          System.out.println("Longest run of tails is "+rot);   
    }
    
}

