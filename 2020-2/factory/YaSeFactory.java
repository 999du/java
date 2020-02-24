package factory;

import hero.Hero;
import hero.YaSe;

public class YaSeFactory implements Factory{

	@Override
	public Hero produceHero() {
		System.out.println("亚瑟工厂生产了亚瑟!");
		return new YaSe();
	}

}
