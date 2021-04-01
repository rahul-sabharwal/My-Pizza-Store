package Items;
import java.util.Scanner;

import Enums.*;

public class Pizza extends Item{

  public Pizza(){
    super(ItemType.PIZZA);
  }

  // Pizza size menu
  private  void pizzaSizeMenu() {
    System.out.println("\n");
    System.out.println("        ########################################");
    System.out.println("        #                                      #");
    System.out.println("        #             Size Menu :              #");
    System.out.println("        #                                      #");
    System.out.println("        #             1. Small                 #");
    System.out.println("        #             2. Medium                #");
    System.out.println("        #             3. Large                 #");
    System.out.println("        #                                      #");
    System.out.println("        ########################################");
    System.out.println("\n");
    System.out.print("Please Type the Size you want to add : ");

  }

  // Pizza Crust Menu
  private  void pizzaCrustMenu() {
    System.out.println("\n");
    System.out.println("        ########################################");
    System.out.println("        #                                      #");
    System.out.println("        #              Crust Menu :            #");
    System.out.println("        #                                      #");
    System.out.println("        #             1. Thin Crust            #");
    System.out.println("        #           2. Regular Crust           #");
    System.out.println("        #                                      #");
    System.out.println("        ########################################");
    System.out.println("\n");
    System.out.print("Please Type the Crust you want to add : ");

  }

    // Pizza size menu
    private  void pizzaToppingsMenu() {
      System.out.println("\n");
      System.out.println("        ########################################");
      System.out.println("        #                                      #");
      System.out.println("        #             Toppings Menu :          #");
      System.out.println("        #                                      #");
      System.out.println("        #             1. Mushrooms             #");
      System.out.println("        #             2. Cottage Cheese        #");
      System.out.println("        #             3. Pinapple              #");
      System.out.println("        #             4. Arugla                #");
      System.out.println("        #                                      #");
      System.out.println("        ########################################");
      System.out.println("\n");
      System.out.print("Please Type the Toppings you want to add : ");
    }
  

    public void editMenu() {
      System.out.println("\n");
      System.out.println("        ########################################");
      System.out.println("        #                                      #");
      System.out.println("        #         Choose Your to edit :        #");
      System.out.println("        #                                      #");
      System.out.println("        #           1. Size                    #");
      System.out.println("        #           2. Crust                   #");
      System.out.println("        #           3. Toppings                #");
      System.out.println("        #           4. Cancel                  #");
      System.out.println("        #                                      #");
      System.out.println("        ########################################");
      System.out.println("\n");

  }

  public void inputProperties(){
    pizzaCrustMenu();
    Scanner scanner = new Scanner(System.in);
    String val = scanner.nextLine();
    addProperty(ItemPropertyType.CRUST, val);
    pizzaSizeMenu();
    val = scanner.nextLine();
    addProperty(ItemPropertyType.SIZE, val);
    pizzaToppingsMenu();
    val = scanner.nextLine();
    addProperty(ItemPropertyType.TOPPINGS, val);
  };
 

}