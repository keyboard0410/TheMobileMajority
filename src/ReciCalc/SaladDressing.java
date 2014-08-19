package ReciCalc;

import java.math.BigDecimal;

public class SaladDressing extends Recipe {

	public SaladDressing() {
		recipeName = "Salad Dressing";
		ingredientQuantityList.add(new IngredientQuantity(INGREDIENTSNAME.OGARLIC, new BigDecimal("1.0")));
		ingredientQuantityList.add(new IngredientQuantity(INGREDIENTSNAME.LEMON, new BigDecimal("1.0")));
		ingredientQuantityList.add(new IngredientQuantity(INGREDIENTSNAME.OOLIVEOIL, new BigDecimal("0.75")));
		ingredientQuantityList.add(new IngredientQuantity(INGREDIENTSNAME.SALT, new BigDecimal("0.75")));
		ingredientQuantityList.add(new IngredientQuantity(INGREDIENTSNAME.PEPPER, new BigDecimal("0.5")));
	}
}

