package com.example.util;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
    private Connection connection = null;
    
    public Connection getConnection(){
        if(connection != null){
            return connection;
        }
        else{
            try{
                Properties prop = new Properties();
                InputStream inputStream = 
                        DbUtil.class.getResourceAsStream("db.properties");
                prop.load(inputStream);
                
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String dbuser = prop.getProperty("dbuser");
                String dbpass = prop.getProperty("dbpass");
                Class.forName(driver);
                
                connection = (Connection) DriverManager.getConnection(url, dbuser, dbpass);
                
            }catch(ClassNotFoundException e){
                System.out.println("Class Not Found");
                e.printStackTrace();
            }catch (SQLException e){
                System.out.println("SQL Exception");
                e.printStackTrace();
            }catch (IOException e) {
                System.out.println("IO Exception");
                e.printStackTrace();
            }catch (Exception e){
                System.out.println("Generic Exception");
                e.printStackTrace();
            }
            return connection;
        }
    }
    
    public boolean disconnect(){
        try{
            connection.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
    
}
