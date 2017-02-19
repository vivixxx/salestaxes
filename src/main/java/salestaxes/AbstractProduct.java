package salestaxes;

import java.math.BigDecimal;

public abstract class AbstractProduct {
	private final String description;
	private final BigDecimal price;
	private final boolean imported;
	public abstract void print();
	public abstract BigDecimal getTax();
	
	public String getDescription() {
		return description;
	}


	public BigDecimal getPrice() {
		return price;
	}

	public boolean isImported() {
		return imported;
	}

	public AbstractProduct(String description, BigDecimal price, boolean imported) {
		super();
		this.description = description;
		this.price = price;
		this.imported = imported;
	}
	
	

}
