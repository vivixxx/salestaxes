package salestaxes;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCart {

	private List<? extends AbstractProduct> list;

	public ShoppingCart(List<? extends AbstractProduct> list) {
		this.list = list;
		
	}
	
	public BigDecimal calculateTotal() {
		BigDecimal total= new BigDecimal(0);
		for (AbstractProduct product : list){
			total= total.add(calculateFinalPrice(product));
			
		}
		return total;
	}

	private BigDecimal calculateFinalPrice(AbstractProduct product) {
		// TODO Auto-generated method stub
		return  new ProductOperationManager(product).calculateFinalPrice();
	}
	
	public BigDecimal getTotalTax(){
		BigDecimal totalTax= new BigDecimal(0);
		for (AbstractProduct product : list){
			totalTax= totalTax.add(new ProductOperationManager(product).calculateTotalTaxes());			
		}
		return totalTax;
		
	}

	

}
