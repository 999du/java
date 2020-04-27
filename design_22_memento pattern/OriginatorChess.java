package design_22;
/*原发器
 * 他是一个普通类,可以创建一个备忘录,并存储它的当前的内部状态,
 * 也可以使用备忘录来恢复其内部状态,一般将需要保存内部状态的类设计为原发器.
 */
public class OriginatorChess {

	private  MementoChess memchess;
	public OriginatorChess (MementoChess mem) {
		this.memchess=mem;
	}
	public void SetX(int x) {
		memchess.setX(x);
	}
	public void SetY(int y) {
		memchess.setY(y);
	}
	public MementoChess SavetoMemento() {
		return new MementoChess(memchess.getLable(),memchess.getX(),memchess.getY());
	}
	public void Restore(MementoChess mem) {
		this.memchess.setLable(mem.getLable());
		this.memchess.setX(mem.getX());
		this.memchess.setY(mem.getY());
	}
	public void Show() {
		System.out.println("当前棋子状态:"+memchess.getLable()+"("+
											memchess.getX()+","+
											memchess.getY()+")");
	}
}
