package ReciCalc;

import java.math.BigDecimal;

public class HealthyChickenBreast extends Recipe {
	
	public HealthyChickenBreast() {
		recipeName = "Healthy Chicken Breast";
		ingredientQuantityList.add(new IngredientQuantity(INGREDIENTSNAME.OGARLIC, new BigDecimal("1.0")));
		ingredientQuantityList.add(new IngredientQuantity(INGREDIENTSNAME.CHICKENBREAST, new BigDecimal("4.0")));
		ingredientQuantityList.add(new IngredientQuantity(INGREDIENTSNAME.OOLIVEOIL, new BigDecimal("0.5")));
		ingredientQuantityList.add(new IngredientQuantity(INGREDIENTSNAME.VINEGAR, new BigDecimal("0.5")));
	}


}
