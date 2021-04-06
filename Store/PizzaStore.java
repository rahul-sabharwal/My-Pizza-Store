package Store;
import java.util.Scanner;
import java.util.ArrayList;
import Enums.*;
import Items.*;

public class PizzaStore extends Store {
    private Scanner sc;
    private ArrayList < Item > items = new ArrayList < > ();
    private String orderNote = "";

    public PizzaStore() {
        sc = new Scanner(System.in);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void finalize() throws Throwable {
        sc.close();
        super.finalize();
    }

    // Main Menu of Pizza Store
    public void printStoreMenu() {
        System.out.println("\n");
        System.out.println("        ########################################");
        System.out.println("        #                                      #");
        System.out.println("        #         Choose Your Option:          #");
        System.out.println("        #                                      #");
        System.out.println("        #           1. Add an Item             #");
        System.out.println("        #                                      #");
        System.out.println("        #         2. Show your Order           #");
        System.out.println("        #                                      #");
        System.out.println("        #            3. Edit Item              #");
        System.out.println("        #                                      #");
        System.out.println("        #        4. Confirm your order         #");
        System.out.println("        #                                      #");
        System.out.println("        #            5. Add a Note             #");
        System.out.println("        #                                      #");
        System.out.println("        #               6. Exit                #");
        System.out.println("        #                                      #");
        System.out.println("        ########################################");
        System.out.println("\n");
    }

    public void printItems() {
        System.out.println("\t\t\t Your Order\n");
        printItems(ItemType.PIZZA);
        printItems(ItemType.SIDEDISH);
        if(!orderNote.isBlank())
        System.out.println("\n\t\t Note: "+ orderNote +"\n");
    }

    // print all pizzas in order
    public void printItems(ItemType type) {
    	boolean containsItem = false;
    	int serialNumber = 1;
    	System.out.println("\n\t\t\t Your "+ type.name() +"\n");
    	if(type.equals(ItemType.PIZZA)) {
    		System.out.println("\tS.no\tItem ID\t\tCrust\t\t Size\t\t Toppings");   
    	} else if(type.equals(ItemType.SIDEDISH)) {
            System.out.println("\tS.no\tItem ID\t\tSideDish\t\tQuantity");
    	}
		for(int i=0;i<items.size();i++) {
			if(items.get(i).getType().equals(type.toString())) {
			containsItem = true;
    		System.out.print("\t" + serialNumber + "\t" + items.get(i).getId()+"\t\t");
    		serialNumber++;
    		items.get(i).printDetails();
			}
		}
		if(containsItem==false) {
			System.out.println("\n\t\tNo "+type.name()+" present in your Order.");
		}
    }

    public void addItem() {
        Item item = new Pizza();
        item.printItemsMenu();
        System.out.println("What Item you want to add ?");
        int option = sc.nextInt();
        if (option == 2) {
            item = new SideDish();
        }
        item.inputProperties();
        item.setId(items.size()+1);
        items.add(item);
    }

    public void editItem() {
        printItems();
        System.out.println("\nEnter Item id that you want to edit : ");
        sc = new Scanner(System.in);
        int id = sc.nextInt();
        int pos =0;
        
        for(int i=0;i<items.size();i++) {
        	if(items.get(i).getId() == id) {
        		pos = i;
        	}
        }
        Item item = items.get(pos);
        if (item.getType().equals(ItemType.PIZZA.toString())) {
            item = (Pizza) items.get(pos);
        } else {
            item = (SideDish) items.get(pos);
        }
        item.updateItem();
    }


    public boolean confirm() {
        System.out.println("##############################################################################");
        System.out.println("#                                                                            #");
        System.out.println("#                               Final Order                                  #");
        System.out.println("#                                                                            #");
        printItems();
        System.out.println("#                                                                            #");
        System.out.println("#                                                                            #");
        System.out.println("##############################################################################");

        sc = new Scanner(System.in);
        if (orderNote.equals("")) {
            System.out.println("\n\t\tYou can also add a note for your order\n");
        } else
            System.out.println("\n\t\tNote : " + orderNote + "\n");

        System.out.println("\n\t\tEnter 1 to CONFIRM and 0 to ADD MORE\n");
        int op = sc.nextInt();
        return op == 1 ? true : false;
    }

    // adding a note for order
    public void addNote() {
        System.out.println("\n\t\tType a note if you want to add :");
        sc = new Scanner(System.in);
        String note = sc.nextLine();
        orderNote = note;
    }

    // driving function for ordering in pistore
    public void initiateOrder() {
        sc = new Scanner(System.in);
        printStoreMenu();
        System.out.print("\n");
        while (true) {
            int opt = sc.nextInt();

            if (opt == 1) {
                addItem();
            } else if (opt == 2) {
                printItems();
            } else if (opt == 3) {
                editItem();
            } else if (opt == 4 && confirm()) {
                System.out.println("\n\t\t%    THANK YOU FOR ORDERING YOUR ORDER IS ARRIVING SOON    %\n");
                break;
            } else if (opt == 5) {
                addNote();
            } else if (opt == 6) {
                System.out.println("\n\t\t%    THANK YOU FOR VISITING  %\n");
                break;
            } else {
                System.out.println("\n\t\tX    INVALID INPUT PLEASE TRY AGAIN    X\n");
            }

            System.out.print("\n");
            printStoreMenu();
        }
    }
}