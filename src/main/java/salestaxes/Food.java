package salestaxes;

import java.math.BigDecimal;

public class Food extends AbstractProduct {

	public Food(String description, BigDecimal price, boolean imported) {
		super(description, price, imported);
		
	}

	public void print() {
		System.out.println("Sono un cibo");


	}

	@Override
	public BigDecimal getTax() {
		return new BigDecimal("0");
	}

}
