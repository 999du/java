import java.util.Hashtable;

public class UDisk {
	//原型管理器
	private static Hashtable<Integer,File> filetable=new Hashtable<Integer,File>();
	//向管理器中添加文件
	public void addFile(Integer key,String filename) {
		filetable.put(key,new File(filename));
	}
	//获取文件的克隆,原型模式
	public File getFile(Integer key) {
		File file=(File)filetable.get(key);
		return (File)file.clone();
	}
}
