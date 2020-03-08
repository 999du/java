
public class NewPrinter extends OldPrinter implements NewPort{
	
	@Override
	//适配器,利用旧的打印机来实现双份打印
	public String print(String file1, String type1,String file2,String type2) {
		// TODO 自动生成的方法存根
		//返回新的打印信息
		return print(file1,type1)+"\n"+print(file2,type2);
	}
	
}
