package ShoppingCart2.ShoppingCart2;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import ShoppingCart2.ShoppingCart2.Product;
import ShoppingCart2.ShoppingCart2.ProductNotFoundException;
import ShoppingCart2.ShoppingCart2.ShoppingCart;
/**
 * Unit test for simple App.
 */
public class ShoppingCartTest2 
{	
	   private static ShoppingCart sc;
	   private static Product p;
	   private static Product p2;
	   private static Product p3;
	   
	   @BeforeEach
	   public void init() {
	   	sc = new ShoppingCart();
	   	p = new Product("queso", 2.50);
	   	p2 = new Product("cereales", 3.75);
	   	p3 = new Product("cereales", 3.75);
	   }
	   
	   @Test 
	   public void shoppingCartEmpty() {
		   assertTrue(sc.getItemCount() == 0);
	   }
	   
	   @Test 
	   public void isEmpty() {
		   sc.empty();
		   assertTrue(sc.getItemCount() == 0);
	   }
	   
	   @Test
	   public void equals() {
		   assertEquals(p.equals(p2), false);
		   assertEquals(p2.equals(p3), true);
	   }
	   
	   @Test
	   public void getBalance() {
		   double result = sc.getBalance() + p.getPrice();
		   sc.addItem(p);
		   assertTrue(sc.getBalance() == result);
	   }
	   
	   @Test
	   public void getItemCount() throws ProductNotFoundException {
		   int counter = sc.getItemCount();
		   sc.addItem(p);
		   sc.addItem(p2);
		   sc.removeItem(p);
		   sc.removeItem(p2);
		   assertTrue(sc.getItemCount() < counter);
		   
		   try {
			   sc.removeItem(p3);
			   fail("ProductNotFoundException");
		   } catch (ProductNotFoundException e){  
		   }
	   }
	   
	   
	   @AfterEach
		public void finish() {
			ShoppingCart sc = null;
			Product p = null;
			Product p2 = null;
			Product p3 = null;
		}
	   

	}




