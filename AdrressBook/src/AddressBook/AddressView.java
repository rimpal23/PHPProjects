/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class AddressView {

	private AddressController controller;
	/**
	 * 
	 * @param args
	 */
        
        public AddressView() {
		controller=new AddressController();
	}

	public void run() {
            //I will write the code to take input from the user.
            Scanner sc=new Scanner(System.in);
            boolean exitFlag=false;
            
            do{
            System.out.println("Please enter Name:");
            String name=sc.nextLine();
            
            System.out.println("Please enter Street Name:");
            String street=sc.nextLine();
            
            System.out.println("Please enter city:");
            String city=sc.nextLine();
            
            System.out.println("Please enter Postal code:");
            String postalCode=sc.nextLine();
            
            //using method of AddressController Class to add in ArrayList<Adddress>
            controller.addAddress(name, street, city, postalCode);
            
            System.out.println("Would you like to add another address? (yes/no)");
            String ans=sc.nextLine();
            
            if(ans.equalsIgnoreCase("no"))
            {
                exitFlag=true;
            }
            }while(exitFlag != true);
            
            //write code to print the addressbook to the User
            System.out.println(controller.print());
	}
        
        public static void main(String[] args) {
               AddressView av=new AddressView();
               av.run();
	}

}