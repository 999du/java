
public class File implements Cloneable{
	public String filename;
	public File(String filename) {
		this.filename=filename;
	}
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
}
