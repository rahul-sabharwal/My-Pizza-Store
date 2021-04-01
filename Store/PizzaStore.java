package Store;
import java.util.Scanner;
import java.util.Arrays;
import Enums.*;
import Items.*;


public class PizzaStore {

    Item[] items = new Item[0];
    String orderNote = "";

    public static void mainMenu() {
        System.out.println("\n");
        System.out.println("        ########################################");
        System.out.println("        #                                      #");
        System.out.println("        #         Choose Your Option:          #");
        System.out.println("        #                                      #");
        System.out.println("        #           1. Add a Pizza             #");
        System.out.println("        #         2. Show your Order           #");
        System.out.println("        #         3. Edit your Order           #");
        System.out.println("        #        4. Confirm your order         #");
        System.out.println("        #            5. Add a Note             #");
        System.out.println("        #               6. Exit                #");
        System.out.println("        #                                      #");
        System.out.println("        ########################################");
        System.out.println("\n");
    }


    public void pushToItems(Item newItem){
        int len = items.length;
        Item[] newItems = Arrays.copyOf(items, items.length+1);
        newItems[len] = newItem;
        items = newItems;
    }

    public void addPizza(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\tEnter 1 to CONTINUE and 0 to CANCEL\n");
        int confirm = sc.nextInt();
        if(confirm ==1){
            Pizza newItem = new Pizza();
            newItem.inputProperties();
            pushToItems(newItem);
        }
        else{
            System.out.println("\n\t\tX   Adding Pizza Cancelled   X\n");
        }
       
    }

    public void printOrder(){
        System.out.println("\t\t\t Your Order");
        System.out.println("\tS.no\tSize\t\tCrust\t\tToppings");
        for (int i = 0; i < items.length; i++) {
			System.out.print("\t"+(i+1)+"\t");
			items[i].printDetails();
		}
    }

    public void editItem(){
        printOrder();
        System.out.println("\nEnter Item you want to edit : ");
        Scanner sc = new Scanner(System.in);
        int pos = sc.nextInt();
        Item pizza = items[pos-1];

        ((Pizza) pizza).editMenu();

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
        if(orderNote.equals("")){
            System.out.println("\n\t\tYou can also add a note for your order\n");
        }else
        System.out.println("\n\t\tNote : "+orderNote+"\n");
        System.out.println("\n\t\tEnter 1 to CONFIRM and 0 to ADD MORE\n");
        int op = sc.nextInt();
        return op;
    }


    public void addNote(){
        System.out.println("\n\t\tType a note if you want to add :");
        Scanner sc =  new Scanner(System.in);
        String note = sc.nextLine();
        orderNote = note;
    }


    public void processInput() {
		Scanner sc = new Scanner(System.in);
		mainMenu();
        while(true){
            int opt = sc.nextInt();
            if (opt == 1) {
            	addPizza();
                System.out.println("\n");
                mainMenu();

            } else if (opt == 2) {
            	printOrder();
                System.out.println("\n");
                mainMenu();
            } else if (opt == 3) {
            	editItem();
                System.out.println("\n");
                mainMenu();
            } else if (opt == 4) {
            	int con = confirm();
                if(con == 1){
                    System.out.println("\n\t\t%    THANK YOU FOR ORDERING    %\n");
                    break;
                }else{
                    mainMenu();
                }
            }
            else if(opt == 5) {
                addNote();
                mainMenu();
            } else if(opt == 6) {
                System.out.println("\n\t\t%    THANK YOU FOR VISITING YOUR ORDER IS ARRIVING SOON   %\n");
            	break;
            }else{
                System.out.println("\n\t\tX    INVALID INPUT PLEASE TRY AGAIN    X\n");
            	mainMenu();
            }
        }
	}
	
    
}