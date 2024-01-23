package com.searchframework.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    public static Properties properties;
    public FileInputStream fileInputStream = null;

    public PropertiesUtils(String propertiesFileName) {
        try {
            fileInputStream = new FileInputStream(propertiesFileName);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}