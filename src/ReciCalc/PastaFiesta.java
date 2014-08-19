package ReciCalc;

import java.math.BigDecimal;

public class PastaFiesta extends Recipe {
	
	public PastaFiesta() {
		recipeName = "Pasta Fiesta";
		ingredientQuantityList.add(new IngredientQuantity(INGREDIENTSNAME.OGARLIC, new BigDecimal("1.0")));
		ingredientQuantityList.add(new IngredientQuantity(INGREDIENTSNAME.CORN, new BigDecimal("4.0")));
		ingredientQuantityList.add(new IngredientQuantity(INGREDIENTSNAME.BACON, new BigDecimal("4.0")));
		ingredientQuantityList.add(new IngredientQuantity(INGREDIENTSNAME.PASTA, new BigDecimal("8.0")));
		ingredientQuantityList.add(new IngredientQuantity(INGREDIENTSNAME.OOLIVEOIL, new BigDecimal("0.33333")));
		ingredientQuantityList.add(new IngredientQuantity(INGREDIENTSNAME.SALT, new BigDecimal("1.25")));
		ingredientQuantityList.add(new IngredientQuantity(INGREDIENTSNAME.PEPPER, new BigDecimal("0.75")));
	}

}

