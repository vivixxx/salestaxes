package salestaxes;

import java.math.BigDecimal;

public class Book extends AbstractProduct {

	public Book(String description, BigDecimal price, boolean imported) {
		super(description, price, imported);
		
	}

	public void print() {
		System.out.println("Sono un Libro");
	}

	@Override
	public BigDecimal getTax() {
		return new BigDecimal("0");
	}

}
