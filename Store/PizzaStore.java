package Store;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import Enums.*;
import Items.*;


public class PizzaStore {

    Item[] pizzas = new Item[0];
    String orderNote = "";
    ArrayList<Item> sideDishes = new ArrayList<>();

    // Main Menu of Pizza Store
    public static void mainMenu() {
        System.out.println("\n");
        System.out.println("        ########################################");
        System.out.println("        #                                      #");
        System.out.println("        #         Choose Your Option:          #");
        System.out.println("        #                                      #");
        System.out.println("        #           1. Add a Pizza             #");
        System.out.println("        #                                      #");
        System.out.println("        #           2. Add a SideDish          #");
        System.out.println("        #                                      #");
        System.out.println("        #         3. Show your Order           #");
        System.out.println("        #                                      #");
        System.out.println("        #            4. Edit Pizza             #");
        System.out.println("        #                                      #");
        System.out.println("        #         5. Edit Side-Dishes          #");
        System.out.println("        #                                      #");
        System.out.println("        #        6. Confirm your order         #");
        System.out.println("        #                                      #");
        System.out.println("        #            7. Add a Note             #");
        System.out.println("        #                                      #");
        System.out.println("        #               8. Exit                #");
        System.out.println("        #                                      #");
        System.out.println("        ########################################");
        System.out.println("\n");
    }


    // PIZZAS FUNCTIONS

    // push pizza to the end of pizza array
    public void pushToPizzas(Item newItem){
        int len = pizzas.length;
        Item[] newItems = Arrays.copyOf(pizzas, pizzas.length+1);
        newItems[len] = newItem;
        pizzas = newItems;
    }

    // print all pizzas in order
    public void printPizzas(){
        if(pizzas.length > 0){
            System.out.println("\t\t\t \n\nYour Pizzas\n");
            System.out.println("\tS.no\tSize\t\tCrust\t\tToppings");
            for (int i = 0; i < pizzas.length; i++) {
                System.out.print("\t"+(i+1)+"\t");
                pizzas[i].printDetails();
            }
        }else{
            System.out.println("No Pizzas in your Order");
        }
    }

    // add new pizza to order
    public void addPizza(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\tEnter 1 to CONTINUE and 0 to CANCEL\n");
        int confirm = sc.nextInt();
        if(confirm ==1){
            Pizza newItem = new Pizza();
            newItem.inputProperties();
            pushToPizzas(newItem);
        }
        else{
            System.out.println("\n\t\tX   Adding Pizza Cancelled   X\n");
        }
       
    }

    
    // edit a pizza in order
    public void editPizza(){
        printPizzas();
        System.out.println("\nEnter Item you want to edit : ");
        Scanner sc = new Scanner(System.in);
        int pos = sc.nextInt();
        Item pizza = pizzas[pos-1];

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
        } else{
            System.out.println("\tX\tInvalid Input\tX\n");
        }

        printPizzas();
    }


    // SIDE DISH FUNCTIONS


    // add new sidedish to order
    public void addSideDish(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\tEnter 1 to CONTINUE and 0 to CANCEL\n");
        int confirm = sc.nextInt();
        if(confirm ==1){
            SideDish newSideDish = new SideDish();
            newSideDish.inputProperties();
            if(newSideDish.getLength() == 0){
                return;
            }
            pushToSideDishes(newSideDish);
        }
        else{
            System.out.println("\n\t\tX   Adding Side-Dish Cancelled   X\n");
        }
    }

    // push sidedish in sidedishes array
    public void pushToSideDishes(SideDish newSideDish){
        sideDishes.add(newSideDish);
    }

    // print all sidedishes in order
    public void printSideDishes(){
        if(sideDishes.size()>0){
            System.out.println("\t\t\t Your SideDishes\n");
            int sernum =1;
            System.out.println("\tS.no\tSideDish\tQuantity");
            for(Item i : sideDishes){
                System.out.print("\t"+(sernum)+"\t");
			    i.printDetails();
                sernum++;
            }
        } else {
            System.out.println("No SideDishes in your Order");

        }
    }


    // print order
    public void printOrder(){
        System.out.println("\t\t\t Your Order\n");
        
        printPizzas();
        printSideDishes();

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


    // adding a note for order
    public void addNote(){
        System.out.println("\n\t\tType a note if you want to add :");
        Scanner sc =  new Scanner(System.in);
        String note = sc.nextLine();
        orderNote = note;
    }

    // edit sidedish in order
    public void editSideDish(){
        printSideDishes();

        System.out.println("\nEnter Item you want to edit : ");
        Scanner sc = new Scanner(System.in);
        int pos = sc.nextInt();
        Item sideDish = sideDishes.get(pos-1);

        ((SideDish) sideDish).editMenu();

        int prop = sc.nextInt();
        if(prop == 1){

            System.out.println("\nEnter New SideDish : ");
            ((SideDish) sideDish).sideDishMenu();
            String val = sc.nextLine();
            sideDish.updateProperty(ItemPropertyType.SDNAME, val);
        } else if(prop == 2){
            System.out.println("\nEnter New Quantity : ");
            int val = sc.nextInt();
            if(val == 0){
                sideDishes.remove(pos-1);
            }
            sideDish.updateProperty(ItemPropertyType.SDQUANTITY, val);
        } else{
            System.out.println("\tX\tInvalid Input\tX\n");
        }
    }



    // driving function for ordering in pistore
    public void processInput() {
		Scanner sc = new Scanner(System.in);
		mainMenu();
        while(true){
            int opt = sc.nextInt();
            if (opt == 1) {
            	addPizza();
                System.out.println("\n");
                mainMenu();

            }else if(opt==2){
                addSideDish();
                System.out.println("\n");
                mainMenu();
            }
             else if (opt == 3) {
            	printOrder();
                System.out.println("\n");
                mainMenu();
            } else if (opt == 4) {
            	editPizza();
                System.out.println("\n");
                mainMenu();
            } else if (opt == 5) {
            	editSideDish();
                System.out.println("\n");
                mainMenu();
            } else if (opt == 6) {
            	int con = confirm();
                if(con == 1){
                    System.out.println("\n\t\t%    THANK YOU FOR ORDERING    %\n");
                    break;
                }else{
                    mainMenu();
                }
            }
            else if(opt == 7) {
                addNote();
                mainMenu();
            } else if(opt == 8) {
                System.out.println("\n\t\t%    THANK YOU FOR VISITING YOUR ORDER IS ARRIVING SOON   %\n");
            	break;
            }else{
                System.out.println("\n\t\tX    INVALID INPUT PLEASE TRY AGAIN    X\n");
            	mainMenu();
            }
        }
	}
	
    
}