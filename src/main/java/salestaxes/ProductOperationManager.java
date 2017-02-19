package salestaxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductOperationManager {
	AbstractProduct product;
	
	
	
	public ProductOperationManager(AbstractProduct product) {
		super();
		this.product = product;
	}

	public BigDecimal calculateFinalPrice(){
		return product.getPrice().add(calculateTotalTaxes());

	}
	
	private BigDecimal calculateImportedTax() {
		BigDecimal price = product.getPrice();
		if (product.isImported())
			return price.multiply(new BigDecimal("0.05")).setScale(1, RoundingMode.HALF_UP);
		
		return new BigDecimal("0");
	}
	
	public BigDecimal calculateTotalTaxes(){
		return calculateTax().add(calculateImportedTax()).setScale(2, RoundingMode.HALF_DOWN);
	}

	private BigDecimal calculateTax() {
		 BigDecimal price = product.getPrice();
		 return price.multiply(product.getTax());
	}

	

}
