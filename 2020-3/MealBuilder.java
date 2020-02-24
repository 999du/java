import factory.Factory;

public abstract class MealBuilder
{

	protected Meal meal=new Meal();
	public abstract void buildFood(Factory factory);
	public abstract void buildDrink(Factory factory);
	public Meal getMeal()
	{
		return meal;
	}
}