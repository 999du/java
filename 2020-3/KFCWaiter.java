import factory.Factory;

public class KFCWaiter
{
	private MealBuilder mb;
	Factory factory;
	public void setMealBuilder(MealBuilder mb, Factory factory)
	{
		this.mb=mb;
		this.factory=factory;
	}
	public Meal construct()
	{
		mb.buildFood(this.factory);
		mb.buildDrink(this.factory);
		return mb.getMeal();
	}
}