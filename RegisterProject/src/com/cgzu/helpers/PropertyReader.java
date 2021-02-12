package com.cgzu.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyReader {

	private static PropertyReader pr = new PropertyReader();
    private Properties prop = new Properties();
    private InputStream input = null;

    private PropertyReader() {
        try {
          input = getClass().getClassLoader().getResourceAsStream("connections.properties");
                  	  
            prop.load(input);
       
        } catch (IOException ex) {
            ex.printStackTrace();
        }  finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static PropertyReader getInstance() {
        return pr;
    }

    public String getValue(String key) {
        return prop.getProperty(key);
    }
}
