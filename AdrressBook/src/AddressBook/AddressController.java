
package AddressBook;

import java.util.ArrayList;
import java.util.HashSet;

public class AddressController {

	private ArrayList<AddressModel> addressBook;

	public AddressController() {
		addressBook=new ArrayList<AddressModel>();
	}
        
	public void addAddress(String name, String street, String city, String postalCode) {
            AddressModel a=new AddressModel();
            a.setName(name);
            a.setStreet(street);
            a.setCity(city);
            a.setPostalCode(postalCode);
            
                     
        /*The following logic will add new address in an alphabetical order
        of 'name' --> ascending order*/
        int addIndex = 0; //variable to store index where new address will be stored. 
        if (addressBook.isEmpty()) {
            addressBook.add(a);
        } else {
            for (AddressModel temp : addressBook) {
                if( addIndex == (addressBook.size()-1) && 
                        name.compareToIgnoreCase(temp.getName()) >= 1) {
                    addressBook.add(a);
                    break;
                } else if (name.compareToIgnoreCase(temp.getName()) < 1) {
                    addressBook.add(addIndex, a);
                    break;
                }
                addIndex++;
            }
        }
            
            
	}

	
        //the print method will print all the address of the Addressbook.
        public String print()
        {
            String address="";
            for(AddressModel ad:addressBook)
            {
                address += "\n" + "**************";
                address += "\n Name:" + ad.getName();
                address += "\n Address:" + ad.getStreet() + " " + ad.getCity() + " "+ad.getPostalCode();
            }
            return address;
        }

}