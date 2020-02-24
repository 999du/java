package factory;


import ingredients.ChickenLeg;
import ingredients.CocaCola;
import ingredients.Ingredients;

public class FactoryB implements Factory{

	@Override
	public Ingredients productIngredientsA() {
		// TODO 自动生成的方法存根
		ChickenLeg chickenleg=new ChickenLeg();
		chickenleg.ingredientName="B厂"+chickenleg.ingredientName;
		return chickenleg;
	}

	@Override
	public Ingredients productIngredientsB() {
		// TODO 自动生成的方法存根
		CocaCola cocaCola=new CocaCola();
		cocaCola.ingredientName="B厂"+cocaCola.ingredientName;
		return cocaCola;
	}

	
}
