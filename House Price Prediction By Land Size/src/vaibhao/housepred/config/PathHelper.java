package vaibhao.housepred.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PathHelper {
	 static Properties p= new Properties();
	 static {
		 File f= new File(".");
		 String filePath=f.getAbsolutePath();
		 String mainPath=filePath.substring(0,filePath.length()-1)+"src\\vaibhao\\housepred\\config\\db.properties";
		FileInputStream fIn;
		try {
			fIn= new FileInputStream(mainPath);
			p.load(fIn);
		} catch (Exception e) {
			System.out.println("Error is "+e);
		}
	 }
}