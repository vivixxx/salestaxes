package salestaxes;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class ProductTest {

	@Test
	public void test() {
		Book book = new Book("libro",new BigDecimal("15.5"), false);
		assertTrue(book.getTax().equals(new BigDecimal(0)));
	}
	
	@Test
	public void test2() {
		GenericProduct product = new GenericProduct("imported bottle of perfume",new BigDecimal("15.5"), false);
		assertTrue(product.getTax().equals(new BigDecimal("0.10")));
	}

}
