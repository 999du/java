import factory.Factory;

public class SubMealBuilderA extends MealBuilder
{
	public void buildFood(Factory factory)
	{
		meal.setFood("华莱士鸡肉卷:"+factory.productIngredientsA().ingredientsName());
	}
	public void buildDrink(Factory factory)
	{
	    meal.setDrink("可乐:"+factory.productIngredientsB().ingredientsName());
	}
}