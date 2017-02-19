package salestaxes;

import java.math.BigDecimal;

public class MedicalProduct extends AbstractProduct {

	public MedicalProduct(String description, BigDecimal price, boolean imported) {
		super(description, price, imported);
		
	}

	public void print() {
		System.out.println("sono un prodotto medico");

	}

	@Override
	public BigDecimal getTax() {
		return new BigDecimal("0");
	}
	

}
