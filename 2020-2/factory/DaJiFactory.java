package factory;
import hero.DaJi;
import hero.Hero;

public class DaJiFactory implements Factory{

	@Override
	public Hero produceHero() {
		// TODO 自动生成的方法存根
		System.out.println("妲己工厂生产了妲己!");
		return new DaJi();
	}

}
