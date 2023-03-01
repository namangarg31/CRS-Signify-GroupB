package com.signify.utils;

import java.io.FileInputStream;

//package com.flipcard.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

private static Connection connection = null;
	
	public static Connection getConnection() {
		
        if (connection != null)
            return connection;
        else {
            try {
            	Properties prop = new Properties();
                FileInputStream ip = new FileInputStream("src/main/resources/application.properties");
                prop.load(ip);
                String driver = prop.getProperty("spring.datasource.driver-class-name");
                String url = prop.getProperty("spring.datasource.url");
                String user = prop.getProperty("spring.datasource.username");
                String password = prop.getProperty("spring.datasource.password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(connection==null) System.out.println("NULL");
            return connection;
        }

    }

}
