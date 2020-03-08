
public class PaperBuilderB implements PaperBuilder{

	@Override
	public Paper PaperBuild() {
		// TODO 自动生成的方法存根
		//负责提供组装部件和返回成品的方法,但它自身不负责组装的执行
		//组装的执行交给Director来做。
		FactoryB factory=new FactoryB();
		return factory.createProduct();
	}

}
