
public class Director {
	//指导者,不负责对象的创建,只负责把生产的产品组装后返回给客户
	PaperBuilder paperBuilder;
	public Director(PaperBuilder paperBuilder) {
		this.paperBuilder=paperBuilder;
	}
	//获取产品
	public Paper getPaper() {
		return paperBuilder.PaperBuild();
	}
}
