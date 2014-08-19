package ReciCalc;

import java.math.BigDecimal;
import java.util.Scanner;

public class ReciCalc {
	
	protected void getCostBreakdown(Recipe recipe) {
		BigDecimal[] valuesOriginalRecipe = recipe.getCostBreakdown(recipe);
		System.out.println(recipe.recipeName + ":");
		print(valuesOriginalRecipe);
	}
	
	protected void print(BigDecimal[] values) {
		System.out.println("Sales Tax: $" + (values[0])); //values[0] is salesTax
		System.out.println("Wellness Discount: $" + (values[1])); //values[1] is wellnessDiscount
		System.out.println("Total Cost: $" + (values[2])); //values[2] is totalCost
		System.out.println();
	}
	

		
	public static void main(String[] args) {
		ReciCalc test = new ReciCalc();
		
		System.out.println("Please select your recipe:\n\n"
				+ "0: Salad Dressing" + "\n" + "1: Healthy Chicken Breast" + "\n" + "2: Pasta Fiesta" + "\n" + "3: Creat Your Own Recipe" + "\n");
		
		Scanner scan = new Scanner(System.in);
		int selection = scan.nextInt();
	
		switch (selection) {
			case 0: test.getCostBreakdown(new SaladDressing());break;
			case 1: test.getCostBreakdown(new HealthyChickenBreast());break;
			case 2: test.getCostBreakdown(new PastaFiesta());break;
			case 3: 
					CustomizedRecipe customized = new CustomizedRecipe();
					
					int finish = 0;
					
					while(finish == 0) {
						System.out.println("Please select your Ingredients:\n");
						for(int i = 0; i < Recipe.INGREDIENTS.size(); i++) {
							System.out.println(i+":" + Recipe.INGREDIENTS.get(i).ingredientName+"\n");
						}
						
						int gredient = scan.nextInt();
						System.out.println("how many once of"+ Recipe.INGREDIENTS.get(gredient).ingredientName + " you want to add into your recipe");
						double qantity = scan.nextDouble();
						customized.addIngredients(Recipe.INGREDIENTSNAME.values()[gredient], new BigDecimal(qantity) );
						System.out.println("Are you done with the selection? Yes: input 1 / No: input 0");
						finish = scan.nextInt();
						test.getCostBreakdown(customized);
					}
					break;
		}
		scan.close();
	}

}

/**
 * Test Case 1: Salad Dressing
 * Test Case 2: Healthy Chicken Breast
 * Test Case 3: Pasta Fiesta
 * 
 * Test Case 1-3 got same cost breakdowns as shown in the assignment
 * 
 * 
 * Test Case 4: Creat Your Own Recipe with Ingredients including {1 Cup of Corn, 
 *                                                                5 Slices of Bacon, 
 *                                                                0.5 teaspoon of Salt,
 *                                                                0.5 teaspoon of Pepper}
 * 
 * Test Case 4 cost breakdown:
 * Customized Recipe:
 * Sales Tax: $0.14
 * Wellness Discount: $0.00
 * Total Cost: $2.38
 * 
 * 
 * Test Case 5: Creat Your Own Recipe with Ingredients including {1 clove of Organic Garlic, 
 *                                                                10 Slices of Bacon, 
 *                                                                0.75 cup of Organic Olive Oil,
 *                                                                0.5 teaspoon of Salt,
 *                                                                0.75 teaspoon of Pepper}
 * 
 * Test Case 5 cost breakdown: 
 * Customized Recipe:
 * Sales Tax: $0.35
 * Wellness Discount: $0.11
 * Total Cost: $4.96
 * 
 * 
 */


