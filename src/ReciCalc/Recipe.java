package ReciCalc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public abstract class Recipe {
	protected String recipeName = "";
	protected ArrayList<IngredientQuantity> ingredientQuantityList = new ArrayList<IngredientQuantity>();
	
	//For easy updating and maintaining ingredients, a static ArrayList<Ingredient> was created. 
	//There only needs to update this ArrayList and enum for any change in the future(such as, change of unit price, addition of new gredients).
	public static ArrayList<Ingredient> INGREDIENTS = new ArrayList<Ingredient>();
	static {
		INGREDIENTS.add(new Ingredient("Organic Garlic", "clove", new BigDecimal("0.67"), true, true));
		INGREDIENTS.add(new Ingredient("Lemon", "per", new BigDecimal("2.03"), false, true));
		INGREDIENTS.add(new Ingredient("Corn", "cup", new BigDecimal("0.87"), false, true));
		INGREDIENTS.add(new Ingredient("Chicken Breast", "piece", new BigDecimal("2.19"), false, false));
		INGREDIENTS.add(new Ingredient("Bacon", "slice", new BigDecimal("0.24"), false, false));
		INGREDIENTS.add(new Ingredient("Pasta", "ounce", new BigDecimal("0.31"), false, false));
		INGREDIENTS.add(new Ingredient("Organic Olive Oil", "cup", new BigDecimal("1.92"), true, false));
		INGREDIENTS.add(new Ingredient("Vinegar", "teaspoon", new BigDecimal("1.26"), false, false));
		INGREDIENTS.add(new Ingredient("Salt", "teaspoon", new BigDecimal("0.16"), false, false));
		INGREDIENTS.add(new Ingredient("Pepper", "teaspoon",new BigDecimal("0.17"), false, false));
	}
	
	protected static enum INGREDIENTSNAME {OGARLIC, LEMON, CORN, CHICKENBREAST, BACON, PASTA, OOLIVEOIL, VINEGAR, SALT, PEPPER};
	
	protected class IngredientQuantity {
		INGREDIENTSNAME IngreName;
		BigDecimal quantity;
		
		IngredientQuantity(INGREDIENTSNAME IngreName, BigDecimal quantity) {
			this.IngreName = IngreName;
			this.quantity = quantity;
		}
	} 
	
	protected BigDecimal[] getCostBreakdown(Recipe recipe) {
		BigDecimal price = new BigDecimal("0");
		BigDecimal totalPrice = new BigDecimal("0");
		
		BigDecimal salesTax = new BigDecimal("0");
		BigDecimal totalSalesTax = new BigDecimal("0");
		
		BigDecimal wellnessDiscount =new BigDecimal("0");
		BigDecimal totalWellnessDiscount =new BigDecimal("0");
		
		BigDecimal totalCost =new BigDecimal("0");
		
		for(int i = 0; i < recipe.ingredientQuantityList.size(); i++) {
			BigDecimal uPrice = INGREDIENTS.get(recipe.ingredientQuantityList.get(i).IngreName.ordinal()).unitPrice;
			BigDecimal uQuantity = recipe.ingredientQuantityList.get(i).quantity;
			
			price = uPrice.multiply(uQuantity);
			
			if(!INGREDIENTS.get(recipe.ingredientQuantityList.get(i).IngreName.ordinal()).isProduce) {
				salesTax =price.multiply(new BigDecimal("0.086"));
			} else {
				salesTax =new BigDecimal("0");
			}	
			
			if(INGREDIENTS.get(recipe.ingredientQuantityList.get(i).IngreName.ordinal()).isOrganic) {
				wellnessDiscount =price.multiply(new BigDecimal("0.05"));
			} else {
				wellnessDiscount =new BigDecimal("0");
			}	
			
			totalPrice = totalPrice.add(price);
			totalSalesTax = totalSalesTax.add(salesTax);
			totalWellnessDiscount = totalWellnessDiscount.add(wellnessDiscount);
			
		}
		
		totalSalesTax = roundSalesTax(totalSalesTax);
		totalWellnessDiscount = roundOthers(totalWellnessDiscount);
		totalCost = roundOthers(totalPrice).add(totalSalesTax).subtract(totalWellnessDiscount);
		
		BigDecimal[] values = new BigDecimal[3];
		values[0] = totalSalesTax;
		values[1] = totalWellnessDiscount;
		values[2] = totalCost;
		return values;
		
	}
	
	protected static BigDecimal round(BigDecimal value, BigDecimal increment, RoundingMode roundingMode) {
		if (increment.signum() == 0) {
        	return value;
    	} else {
        	BigDecimal divided = value.divide(increment, 0, roundingMode);
        	BigDecimal result = divided.multiply(increment);
        	return result;
    	}
	}
	
	protected BigDecimal roundSalesTax(BigDecimal value) {
		return round(value, new BigDecimal("0.07"), RoundingMode.UP);
	}
	
	protected BigDecimal roundOthers(BigDecimal value) {
		return value.setScale(2, RoundingMode.UP);
	}
	
}