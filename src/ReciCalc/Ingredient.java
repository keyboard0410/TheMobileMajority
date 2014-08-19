package ReciCalc;

import java.math.BigDecimal;

public class Ingredient {
	String ingredientName;
	String unit;
	BigDecimal unitPrice;
	boolean isOrganic;
	boolean isProduce;
	
	Ingredient(String ingredientName, String unit, BigDecimal unitPrice, boolean isOrganic, boolean isProduce) {
		this.ingredientName = ingredientName;
		this.unit = unit;
		this.unitPrice = unitPrice;
		this.isOrganic = isOrganic;
		this.isProduce = isProduce;
	}

}
