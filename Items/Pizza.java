package Items;
import java.util.Scanner;

import Enums.*;

public class Pizza extends Item{
	private Scanner sc;
	private String[] pizzaSizes = {"Small", "Medium","Large"};
	private String[] pizzaCrusts = {"Thin", "Regular"};


  public Pizza(){
    super(ItemType.PIZZA);
    sc = new Scanner(System.in);
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
  

    public void printEditMenu() {
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
    

  public void updateItem(){
      System.out.println("\n\n\t\tEnter 1 for YES and 0 for NO\t\t\n\n");
      System.out.print("Do you want to update Size :");
      int decision = sc.nextInt();
      if(decision == 1){
          System.out.println("\nEnter New Size : ");
          int val = sc.nextInt();
          updateProperty(ItemPropertyType.SIZE, pizzaSizes[val-1]);
      }
      System.out.print("Do you want to update Crust :");
      decision = sc.nextInt();
      if(decision == 1){
          System.out.println("\nEnter New Crust : ");
          int val = sc.nextInt();
          updateProperty(ItemPropertyType.CRUST, pizzaCrusts[val-1]);
      }
      System.out.print("Do you want to update Toppings :");
      decision = sc.nextInt();
       if(decision == 1){
          System.out.println("\nEnter New Toppings : ");
          String tval = sc.next();
          updateProperty(ItemPropertyType.TOPPINGS, tval);
      }
  };
   

  public void inputProperties(){
    pizzaCrustMenu();
    sc = new Scanner(System.in);
    int val = sc.nextInt();
    addProperty(ItemPropertyType.CRUST, pizzaCrusts[val-1]);
    pizzaSizeMenu();
    val = sc.nextInt();
    addProperty(ItemPropertyType.SIZE, pizzaSizes[val-1]);
    pizzaToppingsMenu();
    String tval = sc.next();
    addProperty(ItemPropertyType.TOPPINGS, tval);
  };
 

}