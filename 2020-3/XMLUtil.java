import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
public class XMLUtil
{
//该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
	public static List<Object> getBean()
	{
		try
		{
			List<Object>list=new LinkedList<Object>();
			//创建文档对象
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;							
			doc = builder.parse(new File("config.xml")); 
		
			//获取包含类名的文本节点
			NodeList nl = doc.getElementsByTagName("className");
            Node classNode=nl.item(0).getFirstChild();
            String cName=classNode.getNodeValue();
            System.out.println(cName);
            //
            Node classNode1=nl.item(1).getFirstChild();
            String cName1=classNode1.getNodeValue();
            System.out.println(cName1);
            
            //通过类名生成实例对象并将其返回
            
            Class<?> c=Class.forName(cName);
	  	    Object obj=c.getDeclaredConstructor().newInstance();
	  	    
	  	    Class<?> c1=Class.forName(cName1);
	  	    Object obj1=c1.getDeclaredConstructor().newInstance();
	  	    
	  	    list.add(obj);
	  	    list.add(obj1);
            return list;
           }   
           	catch(Exception e)
           	{
           		e.printStackTrace();
           		return null;
           	}
		}
}
