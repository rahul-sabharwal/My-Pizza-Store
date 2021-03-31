import java.util.Scanner;
import Store.PizzaStore;
import Enums.*;

public class MainApplication {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        Item[] arr = new Item[0]; // array of the order
        boolean b = true;
        PizzaStore st = new PizzaStore();

            st.processInput();

    }

}
