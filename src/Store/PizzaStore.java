package Store;
import java.util.Scanner;
import PizzaModal.Pizza;
import java.util.Arrays;


public class PizzaStore {

    
    // Main menu of App
    public  void StoreMenu() {
        System.out.println("\n");
        System.out.println("        ########################################");
        System.out.println("        #                                      #");
        System.out.println("        #         Choose Your Option:          #");
        System.out.println("        #                                      #");
        System.out.println("        #           1. Add a Pizza             #");
        System.out.println("        #         2. Show your Order           #");
        System.out.println("        #         3. Edit your Order           #");
        System.out.println("        #              4. Exit                 #");
        System.out.println("        #                                      #");
        System.out.println("        ########################################");

        System.out.println("\n");
    }

    // Pizza size menu
    public  void PizzaSizeMenu() {
        System.out.println("\n");
        System.out.println("        ########################################");
        System.out.println("        #                                      #");
        System.out.println("        #         Choose Your Option:          #");
        System.out.println("        #                                      #");
        System.out.println("        #             1. 7 inches              #");
        System.out.println("        #             2. 10 inches             #");
        System.out.println("        #             3. 16 inches             #");
        System.out.println("        #                                      #");
        System.out.println("        ########################################");

        System.out.println("\n");
    }

    // Pizza Crust Menu
    public  void PizzaCrustMenu() {
        System.out.println("\n");
        System.out.println("        ########################################");
        System.out.println("        #                                      #");
        System.out.println("        #         Choose Your Option:          #");
        System.out.println("        #                                      #");
        System.out.println("        #             1. Thin Crust            #");
        System.out.println("        #           2. Regular Crust           #");
        System.out.println("        #                                      #");
        System.out.println("        ########################################");

        System.out.println("\n");
        
    }

    // get size of yout pizza
    public  int getSize(int sopt){
        switch (sopt) {
            case 1:
                return 7;
            case 2:
                return 10;
            case 3:
                return 16;
            default:
                return 7;
        }
    }

    // Get crust
    public  String getCrust(int copt){
        switch (copt) {
            case 1:
                return "Thin";

            case 2:
                return "Thick";

            default:
                return"Thick";
        }
    }



    // Adding Pizza 
    public  Pizza[] addPizza(Pizza[] pizzas){
        int n = pizzas.length;
        Scanner sc = new Scanner(System.in);  
        Pizza[] newPizzas = Arrays.copyOf(pizzas,pizzas.length+1);

        PizzaCrustMenu();
        int copt = Integer.parseInt(sc.nextLine());
        String crust=getCrust(copt);
        

        System.out.println("\n");
        PizzaSizeMenu();
        int sopt = Integer.parseInt(sc.nextLine());
        int size=getSize(sopt);
        

        System.out.println("\n");

        System.out.println("Choose additional Toppings Mushrooms/Cottage/Pineapple/Arugla");
        String toppings = new String();
        System.out.println("\n");
        toppings = sc.nextLine();

 

        newPizzas[n] = new Pizza(size, crust, toppings);

        return newPizzas;
    }


    // Edit any pizza 
    public  void editPizza(Pizza[] pizzas){
        System.out.println("Choose Pizza to Edit");
        printOrder(pizzas);
        
        Scanner sc = new Scanner(System.in);  
        int pos = Integer.parseInt(sc.nextLine());
        System.out.println((pos-1)+"      "+pizzas[pos-1].size+"   "+pizzas[pos-1].crust+"   "+pizzas[pos-1].Toppings);
        System.out.println("\n");
        System.out.println("        ########################################");
        System.out.println("        #                                      #");
        System.out.println("        #            What to Edit :            #");
        System.out.println("        #                                      #");
        System.out.println("        #             1. Size                  #");
        System.out.println("        #             2. Crust                 #");
        System.out.println("        #             3. Toppings              #");
        System.out.println("        #                                      #");
        System.out.println("        ########################################");

        System.out.println("\n");

        int eopt = Integer.parseInt(sc.nextLine());
        int opt;
        switch(eopt){
            case 1: PizzaSizeMenu();
            opt = Integer.parseInt(sc.nextLine());
            pizzas[pos-1].size = getSize(opt);
            break;
            case 2: PizzaCrustMenu();
            opt = Integer.parseInt(sc.nextLine());
            pizzas[pos-1].crust = getCrust(opt);
            break;
            case 3:System.out.println("Choose additional Toppings Mushrooms/Cottage/Pineapple/Arugla");
            String tops = new String();
            
            pizzas[pos-1].Toppings = tops;
            break;
            default: System.out.println("Enter a valid option.");
            editPizza(pizzas); 
        }


        
    }

    // Print order 
    public  void printOrder(Pizza[] pizzas){
        System.out.println("\n ");
        System.out.println("S.no  Size  Crust  Toppings");
        for(int i=0;i<pizzas.length;i++){
            System.out.println((i+1)+"      "+pizzas[i].size+"   "+pizzas[i].crust+"   "+pizzas[i].Toppings);
        }
    }

}