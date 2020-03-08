
public class FactoryB implements Factory {

	@Override
	public Paper createProduct() {
		// TODO 自动生成的方法存根
		System.out.println("生产产品B型");
		return new PaperB();
	}

}
