
public class Client {

	//在抽象工厂中Factory中是产品族,如:小米手机,小米平板;Product中是产品等级结构,如小米手机A型,小米手机B型;
	//在建造者模式中,Builder只负责各部件的建造,Director负责把各部件组装成一个实体;
	//建造者和抽象工厂的结合的关键在于在Builder中使用Factory生产的部件;
	//建造者模式中的一个部件对应抽象工厂的一个产品实体
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		UDisk udisk=new UDisk();
		udisk.addFile(1, "大学物理试卷");
		udisk.addFile(2, "大学英语试卷");
		udisk.addFile(3, "大学高数试卷");
		
		NewPrinter printer=new NewPrinter();
		String printinformation=printer.print(udisk.getFile(3).filename, "A", udisk.getFile(2).filename, "B");
		System.out.println(printinformation);
	}

}
