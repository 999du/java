
public class FactoryA implements Factory {

	@Override
	public Paper createProduct() {
		// TODO 自动生成的方法存根
		System.out.println("生产产品A型");
		return new PaperA();
	}

}
