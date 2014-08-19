package ReciCalc;

import java.math.BigDecimal;

public class CustomizedRecipe extends Recipe{
	
	public CustomizedRecipe() {
		recipeName = "Customized Recipe";
	}
		
	protected void addIngredients(INGREDIENTSNAME ingr, BigDecimal quan) {
		IngredientQuantity ingrQuan = new IngredientQuantity(ingr, quan);
		ingredientQuantityList.add(ingrQuan);
	}
}
 