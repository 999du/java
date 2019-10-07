package test;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.*;

public class SpiderTest {
	public static void main(String[] args) throws Exception {
			String http= "https://www.w3.org/Consortium/Member/List";
			URL url;
			StringBuilder mes= new StringBuilder();
			url = new URL(http);
			InputStream is = url.openStream();
			//以UTF-8的形式获取内容
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			String message = null;
			while(null!=(message = br.readLine()))
				mes.append(message);
			Pattern p = Pattern.compile("class=\"member\">(\\D.+?)</a>");
			Matcher m = p.matcher(mes.toString());
			FileWriter fwriter = null;
			fwriter = new FileWriter("D:\\spidertest.txt");
			while(m.find()) {
			     fwriter.write(m.group(1));
			     fwriter.append("\r\n");
			}
			//推送文件流
			fwriter.flush();
			//关闭文件流
			fwriter.close();
		}
}