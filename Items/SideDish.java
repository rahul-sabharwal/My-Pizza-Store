package Items;

import java.util.Scanner;

import Enums.Item;
import Enums.ItemPropertyType;
import Enums.ItemType;

public class SideDish extends Item{
  public SideDish(){
    super(ItemType.SIDEDISH);
  }

  public void sideDishMenu(){
    System.out.println("\n");
    System.out.println("        ########################################");
    System.out.println("        #                                      #");
    System.out.println("        #             Toppings Menu :          #");
    System.out.println("        #                                      #");
    System.out.println("        #             1. Soup                  #");
    System.out.println("        #             2. Garlic Bread          #");
    System.out.println("        #             3. Cheese Dip            #");
    System.out.println("        #             4. Garlic Dip            #");
    System.out.println("        #             5. Caeser Salad          #");
    System.out.println("        #             6. Roasted Veggies       #");
    System.out.println("        #                                      #");
    System.out.println("        ########################################");
    System.out.println("\n");
    System.out.print("Please Type the SideDish you want to add : ");
  }

  public void editMenu() {
    System.out.println("\n");
    System.out.println("        ########################################");
    System.out.println("        #                                      #");
    System.out.println("        #         Choose Your to edit :        #");
    System.out.println("        #                                      #");
    System.out.println("        #           1. Side Dish               #");
    System.out.println("        #           2. Quantity                #");
    System.out.println("        #                                      #");
    System.out.println("        ########################################");
    System.out.println("\n");

}
  
  public void inputProperties(){
    sideDishMenu();
    Scanner sc = new Scanner(System.in);
    String val = sc.nextLine();
    addProperty(ItemPropertyType.SDNAME, val);
    System.out.println("Please enter the quantity for this SideDish");
    int qval = sc.nextInt();
    if(qval == 0){
      deleteAll();
      return;
    }
    addProperty(ItemPropertyType.SDQUANTITY, qval);
  }

}
