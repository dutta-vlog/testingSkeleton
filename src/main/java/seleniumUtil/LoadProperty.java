package seleniumUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperty {
	
	private static final String PATH =System.getProperty("user.dir")+"\\src\\test\\resources";

	public static Properties loadProperties() {
		
		Properties properties = new Properties();
		try (InputStream input = new FileInputStream(PATH+"\\globalProperty.properties")) {
			properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
		return properties;
	}

}
