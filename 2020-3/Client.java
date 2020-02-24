import java.util.List;

import factory.Factory;

public class Client
{
	public static void main(String args[])
	{
		//动态确定套餐种类
		List<Object>list=XMLUtil.getBean();
	    MealBuilder mb=(MealBuilder)list.get(0);
	    Factory factory=(Factory)list.get(1);
		//服务员是指挥者
		KFCWaiter waiter=new KFCWaiter();
	    //服务员准备套餐
	    waiter.setMealBuilder(mb,factory);
	    //客户获得套餐
	    Meal meal=waiter.construct();
        
        System.out.println("套餐组成：");
        System.out.println(meal.getFood());
        System.out.println(meal.getDrink());
	}
}
