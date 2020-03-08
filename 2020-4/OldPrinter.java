
public class OldPrinter {
	//旧的打印机,只能同时打印一份产品
	//指导者,根据客户需求,选择不同的Builder
	Director director=null;
	String print(String file,String type) {
		if(type.equals("A"))
			//选择BuilderA
			director=new Director(new PaperBuilderA());
		if(type.equals("B"))
			//选择BuilderB
			director=new Director(new PaperBuilderB());
		//返回打印信息
		return "已打印:"+director.paperBuilder.PaperBuild().name()+file;
	}
	
}
