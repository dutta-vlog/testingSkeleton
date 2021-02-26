package seleniumUtil;

import java.util.Properties;

public class PropertyFile {

	private static PropertyFile instance;
	private Properties propertyFileInstance ;
	private PropertyFile() {
		propertyFileInstance = LoadProperty.loadProperties();
	}
	
	public static PropertyFile getInstance() {
		if(instance==null) {
			instance = new PropertyFile();
		}
		return instance;
	}
	
	public String getValueOf(String key) {
		return propertyFileInstance.getProperty(key);
	}
	
}
