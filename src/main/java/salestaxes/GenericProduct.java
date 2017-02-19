package salestaxes;

import java.math.BigDecimal;

public class GenericProduct extends AbstractProduct {

	public GenericProduct(String description, BigDecimal price, boolean imported) {
		super(description, price, imported);
		
	}

	public void print(){
		System.out.println("sono un prodotto generico");
	}

	@Override
	public BigDecimal getTax() {
		return new BigDecimal("0.10");
		
		
	}

}
