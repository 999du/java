import factory.Factory;
import hero.Hero;

public class test {
	 public static void main(String args[]) {
	try {
		Hero hero;
		Factory factory=(Factory)XMLUtils.getBean();
		hero=factory.produceHero();
		hero.heroName();
	}
	 catch(Exception e)
     {
     	System.out.println(e.getMessage());
     }
	 }
}
