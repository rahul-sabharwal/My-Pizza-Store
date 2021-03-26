import java.util.Scanner;
import java.util.Arrays;

// Class for Pizza with pizza properties
class Pizza{
    public int size;
    public String crust;
    public String Toppings;
    Pizza(int size, String crust, String Toppings){
        this.size = size;;
        this.crust = crust;
        this.Toppings = Toppings;
    }
}

// Pizza Store
public class PizzaStore {

    // Pizza size menu
    public static void PizzaSizeMenu() {
        System.out.println("\n");
        System.out.println("Choose Your Option for crust size:");
        System.out.println("1. 7\"");
        System.out.println("2. 10\"");
        System.out.println("3. 16\"");
    }

    // Pizza Crust Menu
    public static void PizzaCrustMenu() {
        System.out.println("\n");
        System.out.println("Choose Your Option for crust:");
        System.out.println("1. Thin");
        System.out.println("2. Thick");
        System.out.println("3. Exit");
    }

    // get size of yout pizza
    public static int getSize(int sopt){
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
    public static String getCrust(int copt){
        switch (copt) {
            case 1:
                return "Thin";

            case 2:
                return "Thick";

            default:
                return"Thick";
        }
    }


    // Main menu of App
    public static void menu() {
        System.out.println("\n");
        System.out.println("Choose Your Option:");
        System.out.println("1. Add a Pizza");
        System.out.println("2. Show your Order");
        System.out.println("3. Edit your Order");
        System.out.println("4. Exit");
        System.out.println("\n");
    }

    // Adding Pizza 
    public static Pizza[] addPizza(Pizza[] pizzas){
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

        menu();
        return newPizzas;
    }


    // Edit any pizza 
    public static void editPizza(Pizza[] pizzas){
        System.out.println("Choose Pizza to Edit");
        showOrder(pizzas);
        
        Scanner sc = new Scanner(System.in);  
        int pos = Integer.parseInt(sc.nextLine());
        System.out.println((pos-1)+"      "+pizzas[pos-1].size+"   "+pizzas[pos-1].crust+"   "+pizzas[pos-1].Toppings);
        System.out.println("What You want to edit ?");
        System.out.println("1. Size");
        System.out.println("2. Crust");
        System.out.println("3. Toppings");

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
            case 3:System.out.println("Choose additional Toppings Mushrooms/Cottage/Pineapple/Arugla");
            String tops = new String();
            pizzas[pos-1].Toppings = tops;
        }
        menu();
    }

    // Print order 
    public static void showOrder(Pizza[] pizzas){
        System.out.println("\n ");
        System.out.println("S.no  Size  Crust  Toppings");
        for(int i=0;i<pizzas.length;i++){
            System.out.println((i+1)+"      "+pizzas[i].size+"   "+pizzas[i].crust+"   "+pizzas[i].Toppings);
        }
        menu();
    }

    

    // Main Driver Code
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);  
        Pizza[] arr = new Pizza[0]; // array of the order
        boolean b = true;
        menu();

        while(b){
            int opt = sc.nextInt();
            
            switch (opt) {
                case 1:
                    arr = addPizza(arr);
                    break;
                case 2:
                    showOrder(arr);
                    break;
                case 3:
                    editPizza(arr);
                    break;
                default:b=false;
                    break;
            }
        }
    }



}
