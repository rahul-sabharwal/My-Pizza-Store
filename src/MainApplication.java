import PizzaModal.Pizza;
import java.util.Scanner;
import Store.PizzaStore;

public class MainApplication {
     // Main Driver Code
     public static void main(String[] args) {
        
      Scanner sc = new Scanner(System.in);  
      Pizza[] arr = new Pizza[0]; // array of the order
      PizzaStore store = new PizzaStore();
      boolean b = true;
      store.StoreMenu();

      while(b){

          int opt = sc.nextInt();
          
          switch (opt) {
              case 1:
                  arr = store.addPizza(arr);
                  store.StoreMenu();
                  break;
              case 2:
                  store.printOrder(arr);
                  store.StoreMenu();
                  break;
              case 3:
                  store.editPizza(arr);
                  store.StoreMenu();
                  break;
              default:b=false;
                  break;
          }
      }
      

  }
}
