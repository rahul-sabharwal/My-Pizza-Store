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

        System.out.println("Pizza Crust");
        String crust = new String();
        crust = sc.nextLine();

        System.out.println("\n");
        System.out.println("Pizza Size");
        int size = sc.nextInt();

        System.out.println("\n");
        System.out.println("Toppings");
        String toppings = new String();
        toppings = sc.next();

    

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
