package Store;
import java.util.Scanner;
import java.util.Arrays;
import Enums.*;
import Items.*;
import Items.Pizza;


public class PizzaStore {
    Item[] items = new Item[0];

    public static void MainMenu() {
        System.out.println("\n");
        System.out.println("        ########################################");
        System.out.println("        #                                      #");
        System.out.println("        #         Choose Your Option:          #");
        System.out.println("        #                                      #");
        System.out.println("        #           1. Add a Pizza             #");
        System.out.println("        #         2. Show your Order           #");
        System.out.println("        #         3. Edit your Order           #");
        System.out.println("        #        4. Confirm your order         #");
        System.out.println("        #               5. Exit                #");
        System.out.println("        #                                      #");
        System.out.println("        ########################################");
        System.out.println("\n");
    }


    public void addPizza(){
        int len = items.length;
        Item[] newItems = Arrays.copyOf(items, items.length+1);
        Item newItem = new Pizza();
        newItem.inputProperties();
        newItems[len] = newItem;
        items = newItems;
    }

    public void printOrder(){
        System.out.println("\t\t\t Your Order");
        System.out.println("\tS.no\tSize\t\tCrust\t\tToppings");
        for (int i = 0; i < items.length; i++) {
			System.out.print("\t"+(i+1)+"\t");
			items[i].printDetails();
		}
    }
    public void edit(){
        printOrder();
        System.out.println("\nEnter Item you want to edit : ");
        Scanner sc = new Scanner(System.in);
        int pos = sc.nextInt();
        Item pizza = items[pos-1];
        pizza.EditMenu();
        int prop = sc.nextInt();
        if(prop == 1){
            System.out.println("\nEnter New Size : ");
            String val = sc.next();
            pizza.updateProperty(ItemPropertyType.SIZE, val);
        }
        else if(prop == 2){
            System.out.println("\nEnter New Crust : ");
            String val = sc.next();
            pizza.updateProperty(ItemPropertyType.CRUST, val);
        }
        else if(prop == 3){
            System.out.println("\nEnter New Toppings : ");
            String val = sc.next();
            pizza.updateProperty(ItemPropertyType.TOPPINGS, val);
        }
    }


    public int confirm(){
        System.out.println("##############################################################################");
        System.out.println("#                                                                            #");
        System.out.println("#                               Final Order                                  #");
        System.out.println("#                                                                            #");
        printOrder();
        System.out.println("#                                                                            #");
        System.out.println("#                                                                            #");
        System.out.println("##############################################################################");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to CONFIRM and 0 to ADD MORE");
        int op = sc.nextInt();
        return op;
    }




    public void processInput() {
		Scanner sc = new Scanner(System.in);
		MainMenu();
        while(true){
            int opt = sc.nextInt();
            if (opt == 1) {
            	addPizza();
                System.out.println("\n");
                MainMenu();

            } else if (opt == 2) {
            	printOrder();
                System.out.println("\n");
                MainMenu();
            } else if (opt == 3) {
            	edit();
                System.out.println("\n");
                MainMenu();
            } else if (opt == 4) {
            	int con = confirm();
                if(con == 1){
                    System.out.println("%    THANK YOU FOR ORDERING    %");
                    break;
                }else{
                    MainMenu();
                }
            } else if(opt == 5) {
                System.out.println("\n%    THANK YOU FOR VISITING YOUR ORDER IS ARRIVING SOON   %");
            	break;
            }else{
                System.out.println("X    INVALID INPUT PLEASE TRY AGAIN    X");
            	MainMenu();
            }
        }
	}
	
    
}