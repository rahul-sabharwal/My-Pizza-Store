package Store;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import Enums.Item;
import Enums.ItemType;
import Enums.Store;
import Items.Pizza;
import Items.SideDish;

public class PizzaStore extends Store {
	private ArrayList<Item> initItem = new ArrayList<Item>();
	private Scanner sc;    
    private HashMap<ItemType, ArrayList<Item>> itemsMap = new HashMap<>();
    private String orderNote = "";
    private int itemsId=1;
    public PizzaStore() {
    	itemsMap.put(ItemType.PIZZA, initItem);
    	itemsMap.put(ItemType.SIDEDISH, initItem);
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

    private void printItems() {
        System.out.println("\t\t\t Your Order\n");
        printItems(ItemType.PIZZA);
        printItems(ItemType.SIDEDISH);
        if(!orderNote.isBlank())
        System.out.println("\n\t\t Note: "+ orderNote +"\n");
    }

    // print all pizzas in order
    private void printItems(ItemType type) {
    	AtomicBoolean containsItem = new AtomicBoolean(false);
    	AtomicInteger serialNumber = new AtomicInteger(1);
    	ArrayList<Item> items = itemsMap.get(type);
    	System.out.println("\n\t\t\t Your "+ type.name() +"\n");
    	if(type.equals(ItemType.PIZZA)) {
    		System.out.println("\tS.no\tItem ID\t\tCrust\t\t Size\t\t Toppings");   
    	} else if(type.equals(ItemType.SIDEDISH)) {
            System.out.println("\tS.no\tItem ID\t\tSideDish\t\tQuantity");
    	}
    	items.stream().filter(i->i.getType().equals(type.toString())).forEach(item -> {
    		System.out.print("\t" +  serialNumber + "\t" + item.getId()+"\t\t");
    		item.printDetails();
    		serialNumber.incrementAndGet();
    	});
		
		if(containsItem.get()) {
			System.out.println("\n\t\tNo "+type.name()+" present in your Order.");
		}
    }

    private void addItem() {
    	Item item = new Pizza();
        item.printItemsMenu();
        System.out.println("What Item you want to add ?");
        int option = sc.nextInt();
        if (option == 1) {
            addItem(ItemType.PIZZA);
        } else if(option ==2) {
            addItem(ItemType.SIDEDISH);
        } else {
            System.out.println("\n\t\tX    INVALID INPUT PLEASE TRY AGAIN    X\n");
        }
    }
    
    private void addItem(ItemType type) {
    	Item item = new Pizza();
    	if(type.equals(ItemType.SIDEDISH)) {
        	item = new SideDish();
    	}
    	item.inputProperties();
        ArrayList<Item> items = itemsMap.get(type);
        item.setId(itemsId);
        itemsId++;
        items.add(item);
        itemsMap.put(type, items);
    }
    

    private void editItem() {
        printItems();
        Item item = new Pizza();
        item.printItemsMenu();
        System.out.println("\nEnter Item that you want to edit : ");
        int option = sc.nextInt();
        if (option == 1) {
            editItem(ItemType.PIZZA);
        } else if(option ==2) {
            editItem(ItemType.SIDEDISH);
        } else {
            System.out.println("\n\t\tX    INVALID INPUT PLEASE TRY AGAIN    X\n");
        }
    }
    
    private void editItem(ItemType type) {
    	Item item = new Pizza();
    	if(type.equals(ItemType.SIDEDISH)) {
        	item = new SideDish();
    	}
        System.out.println("\nEnter Item that you want to edit : ");
        int id = sc.nextInt();
        int pos =0;
    	ArrayList<Item> items = itemsMap.get(type);
    	for(int i=0;i<items.size();i++) {
    		if(items.get(i).getId() == id) {
    			pos = i;
    			break;
    		}if(i==items.size()-1 && items.get(i).getId() == id) {
                System.out.println("\n\t\tX    No Item present with this id    X\n");
    		}
    	}
    	item = items.get(pos);
    	item.updateItem();
    	itemsMap.put(type, items);
    }


    private boolean confirm() {
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
    private void addNote() {
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