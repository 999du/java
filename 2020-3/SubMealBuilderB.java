import factory.Factory;

public class SubMealBuilderB extends MealBuilder
{
	public void buildFood(Factory factory)
	{
		meal.setFood("麦当劳炸鸡:"+factory.productIngredientsA().ingredientsName());
	}
	public void buildDrink(Factory factory)
	{
		 meal.setDrink("可乐:"+factory.productIngredientsB().ingredientsName());
	}
}