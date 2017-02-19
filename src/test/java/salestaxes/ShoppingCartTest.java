package salestaxes;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import org.hamcrest.Matchers;
import org.junit.Test;

public class ShoppingCartTest {

	@Test
	public void caseShoppingCartWithOneProduct() {
		BigDecimal total = new ShoppingCart(Arrays.asList(new Book("libro",new BigDecimal("15.50"), false))).calculateTotal();
		assertTrue(total.equals(new BigDecimal("15.50")));
	}
	
	@Test
	public void caseShoppingCartWithTowProducts() {
		AbstractProduct product = new Book("libro",new BigDecimal("15.50"), false);
		AbstractProduct product2 = new Book("libro",new BigDecimal("18.50"), false);
		BigDecimal total = new ShoppingCart(Arrays.asList(product, product2)).calculateTotal();
		assertTrue(total.equals(new BigDecimal("34.00")));
	}

//	CASE 1
//	Input 1:
//	1 book at 12.49
//	1 music CD at 14.99
//	1 chocolate bar at 0.85

	
	@Test
	public void caseShoppingCartWithOneTaxedProductAndTwoUntaxedProducts() {
		System.out.println("Output 1");
		
		AbstractProduct product1 = new Book("book", new BigDecimal("12.49"), false);
		BigDecimal finalPriceP1 = new ProductOperationManager(product1).calculateFinalPrice();
		assertThat(finalPriceP1, Matchers.equalTo(new BigDecimal("12.49")));

		System.out.println("1 "+ product1.getDescription() + ": " + finalPriceP1);
		
		
		AbstractProduct product2 = new GenericProduct("music CD", new BigDecimal("14.99"),false);
		BigDecimal finalPriceP2 = new ProductOperationManager(product2).calculateFinalPrice();
		assertThat(finalPriceP2, Matchers.equalTo(new BigDecimal("16.49")));

		System.out.println("1 "+ product2.getDescription() + ": " + finalPriceP2);
		
		AbstractProduct product3 = new Food("chocolate bar", new BigDecimal("0.85"), false);
		BigDecimal finalPriceP3 = new ProductOperationManager(product3).calculateFinalPrice();
		assertThat(finalPriceP3, Matchers.equalTo(new BigDecimal("0.85")));
		
		System.out.println("1 "+ product3.getDescription() + ": " + finalPriceP3);
		

		ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(product1, product2, product3));
		
		
		BigDecimal totalTaxes = shoppingCart.getTotalTax();
		assertThat(totalTaxes, Matchers.equalTo(new BigDecimal("1.50")));
		System.out.println("Sales Taxes: " + totalTaxes);
		
		
		BigDecimal total = shoppingCart.calculateTotal();
		assertTrue(total.equals(new BigDecimal("29.83")));		
		System.out.println("Total: " + total);
		System.out.println("");		
	}
	
	@Test
	public void caseShoppingCartWithOneImportedAndTaxedProduct() {
		AbstractProduct product = new GenericProduct("imported bottle of perfume",new BigDecimal("27.99"),true);
		BigDecimal total = new ShoppingCart(Arrays.asList(product)).calculateTotal();
		assertTrue(total.equals(new BigDecimal("32.19")));
	}
	
//	CASE 2
//	Input 2:
//	1 imported box of chocolates at 10.00
//	1 imported bottle of perfume at 47.50

	@Test
	public void caseShoppingCartWithTwoTaxedProducts() {
		System.out.println("Output 2");
		
		AbstractProduct product1 = new Food("imported box of chocolates",new BigDecimal("10.00"), true);
		BigDecimal finalPriceP1 = new ProductOperationManager(product1).calculateFinalPrice();
		assertThat(finalPriceP1, Matchers.equalTo(new BigDecimal("10.50")));
		
		System.out.println("1 "+ product1.getDescription() + ": " + finalPriceP1);		
		
		AbstractProduct product2 = new GenericProduct("imported bottle of perfume",new BigDecimal("47.50"),true);
		BigDecimal finalPriceP2 = new ProductOperationManager(product2).calculateFinalPrice();
		assertThat(finalPriceP2, Matchers.equalTo(new BigDecimal("54.65")));

		System.out.println("1 "+ product2.getDescription() + ": " + finalPriceP2);		
		
		
		ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(product1, product2));
		
		BigDecimal totalTaxes = shoppingCart.getTotalTax();
		assertThat(totalTaxes, Matchers.equalTo(new BigDecimal("7.65")));
		System.out.println("Sales Taxes: " + totalTaxes);
		
		BigDecimal total = shoppingCart.calculateTotal();
		assertThat(total, Matchers.equalTo(new BigDecimal("65.15")));
		System.out.println("Total: " + total);
		System.out.println("");	
	}
	
//	CASE 3
//	1 imported bottle of perfume at 27.99
//	1 bottle of perfume at 18.99
//	1 packet of headache pills at 9.75
//	1 box of imported chocolates at 11.25
	
	@Test
	public void caseShoppingCartWithTwoTaxedProductsAndTwoProduct() {
		
		System.out.println("Output 3");
		
		AbstractProduct product1 = new GenericProduct("imported bottle of perfume",new BigDecimal("27.99"),true);
		BigDecimal finalPriceP1 = new ProductOperationManager(product1).calculateFinalPrice();
		assertThat(finalPriceP1, Matchers.equalTo(new BigDecimal("32.19")));
		System.out.println("1 "+ product1.getDescription() + ": " + finalPriceP1);	
		
		AbstractProduct product2 = new GenericProduct("bottle of perfume",new BigDecimal("18.99"),false);
		BigDecimal finalPriceP2 = new ProductOperationManager(product2).calculateFinalPrice();
		assertThat(finalPriceP2, Matchers.equalTo(new BigDecimal("20.89")));
		System.out.println("1 "+ product2.getDescription() + ": " + finalPriceP2);
		
		
		AbstractProduct product3 = new MedicalProduct("packet of headache pills",new BigDecimal("9.75"), false);
		BigDecimal finalPriceP3 = new ProductOperationManager(product3).calculateFinalPrice();
		assertThat(finalPriceP3, Matchers.equalTo(new BigDecimal("9.75")));
		System.out.println("1 "+ product3.getDescription() + ": " + finalPriceP3);
		
		AbstractProduct product4 = new Food("1 box of imported chocolates ",new BigDecimal("11.25"), true);
		BigDecimal finalPriceP4 = new ProductOperationManager(product4).calculateFinalPrice();
		assertThat(finalPriceP4, Matchers.equalTo(new BigDecimal("11.85")));
		System.out.println("1 "+ product4.getDescription() + ": " + finalPriceP4);
		
		ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(product1, product2, product3, product4));
		
		BigDecimal totalTaxes = shoppingCart.getTotalTax();
		assertThat(totalTaxes, Matchers.equalTo(new BigDecimal("6.70")));
		System.out.println("Sales Taxes: " + totalTaxes);
		
		BigDecimal total = shoppingCart.calculateTotal();
		assertThat(total, Matchers.equalTo(new BigDecimal("74.68")));
		System.out.println("Total: " + total);
		System.out.println("");

	}

}
