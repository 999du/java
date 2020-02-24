package factory;

import ingredients.Chicken;
import ingredients.BaiShiCola;
import ingredients.Ingredients;

public class FactoryA implements Factory{

	@Override
	public Ingredients productIngredientsA() {
		// TODO 自动生成的方法存根
		Chicken chicken=new Chicken();
		chicken.ingredientName="A厂"+chicken.ingredientName;
		return chicken;
	}

	@Override
	public Ingredients productIngredientsB() {
		// TODO 自动生成的方法存根
		BaiShiCola baishi=new BaiShiCola();
		baishi.ingredientName="A厂"+baishi.ingredientName;
		return baishi;
	}

}
