package design_22;
/*
 * 存储原发器的内部状态,跟据原发器来决定保存那些内部状态.
 */
public class MementoChess {
		private String lable;
		private int x,y;
		public MementoChess(String lable ,int x,int y) {
			this.lable=lable;
			this.x=x;
			this.y=y;
		}
		public String getLable() {
			return lable;
		}
		public void setLable(String lable) {
			this.lable=lable;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getX() {
			return x;
		}
}
