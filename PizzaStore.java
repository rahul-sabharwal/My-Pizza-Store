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

    public static void PizzaSizeMenu() {
        System.out.println("\n");
        System.out.println("Choose Your Option for crust size:");
        System.out.println("1. 7\"");
        System.out.println("2. 10\"");
        System.out.println("3. 16\"");
    }

    public static void PizzaCrustMenu() {
        System.out.println("\n");
        System.out.println("Choose Your Option for crust:");
        System.out.println("1. Thin");
        System.out.println("2. Thick");
        System.out.println("3. Exit");
    }

    // Menu of App
    public static void menu() {
        System.out.println("\n");
        System.out.println("Choose Your Option:");
        System.out.println("1. Add a Pizza");
        System.out.println("2. Show your Order");
        System.out.println("3. Exit");
        System.out.println("\n");
    }

    // Adding Pizza 
    public static Pizza[] addPizza(Pizza[] pizzas){
        int n = pizzas.length;
        Scanner sc = new Scanner(System.in);  
        Pizza[] newPizzas = Arrays.copyOf(pizzas,pizzas.length+1);

        PizzaCrustMenu();
        int copt = Integer.parseInt(sc.nextLine());
        String crust="";
        switch (copt) {
            case 1:
                crust="Thin";
                break;

            case 2:
                crust="Thick";
                break;

            default:
                crust="Thick";
                break;
        }

        System.out.println("\n");
        PizzaSizeMenu();
        int sopt = Integer.parseInt(sc.nextLine());
        int size=7;
        switch (sopt) {
            case 1:
                size=7;
                break;
            
            case 2:
                size=10;
                break;
            case 3:
                size=16;
                break;
            default:
                crust="Thick";
                break;
        }

        System.out.println("\n");

        System.out.println("Choose additional Toppings Mushrooms/Cottage/Pineapple/Arugla");
        String toppings = new String();
        System.out.println("\n");
        toppings = sc.nextLine();

    

        newPizzas[n] = new Pizza(size, crust, toppings);

        menu();
        return newPizzas;
    }

    // show order 
    public static void showOrder(Pizza[] pizzas){
        System.out.println("\n ");
        System.out.println("S.no  Size  Crust  Toppings");
        for(int i=0;i<pizzas.length;i++){
            System.out.println((i+1)+"      "+pizzas[i].size+"   "+pizzas[i].crust+"   "+pizzas[i].Toppings);
        }
        System.out.println("\n Enter 1 to Add more pizza or 3 to Exit");
    }

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
                default:b=false;
                    break;
            }
        }
    }
}
