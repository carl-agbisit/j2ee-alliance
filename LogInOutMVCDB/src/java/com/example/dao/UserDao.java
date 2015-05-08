package com.example.dao;

import com.example.model.UserBean;
import com.example.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;

public class UserDao extends HttpServlet{
    
    public static boolean isValid(UserBean user){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        boolean result = false;
        
        try{
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = (PreparedStatement) 
                    connection.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                result = true;
            }
            
            rs.close();
            stmt.close();
            db.disconnect();
            
        }catch(SQLException e){
            System.out.println("Connection Problem");
            e.printStackTrace();
        }
        return result;
    }
    
    public static void addUser(String username, String password){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            String sql = "INSERT INTO users(username, password) VALUES (?, ?)";
            PreparedStatement stmt = (PreparedStatement) 
                    connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            int rs = stmt.executeUpdate();
            
            stmt.close();
            db.disconnect();
        }catch(SQLException e){
        }
    }
    
    public static boolean deleteUser(int userid){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        boolean result = false;
        
        try{
            String sql = "DELETE FROM users WHERE userid = ?";
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
            stmt.setInt(1, userid);
            
            int rs = stmt.executeUpdate();
            if(rs != 0){
                result = true;
            }
            
            stmt.close();
            db.disconnect();
        }catch(SQLException e){
            
        }
        return result;
    }
    
    public static boolean updateUser(UserBean user){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        boolean result = false;
        
        try{
            String sql = "UPDATE users SET username = ?,password = ? WHERE userid = ?";
            PreparedStatement stmt = (PreparedStatement) 
                    connection.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getUserid());
            
            int rs = stmt.executeUpdate();
            if(rs != 0){
                result = true;
            }
            
            stmt.close();
            db.disconnect();
        }catch(SQLException e){
            
        }
        return result;
    }
    
    public static List<UserBean> getAllUsers(){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        List<UserBean> users = new ArrayList();
        
        try{
            String sql = "SELECT * FROM users";
            Statement stmt = (Statement) connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                UserBean user = new UserBean();
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
            
            rs.close();
            stmt.close();
            db.disconnect();
        }catch(SQLException e){
            
        }
        return users;
    }
    
    public static UserBean getUserById(int userid){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        UserBean user = new UserBean();
        
        try{
            String sql = "select * from users where userid = ?";
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
            stmt.setInt(1, userid);
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            
            rs.close();
            stmt.close();
            db.disconnect();
        }catch(SQLException e){
            
        }
        return user;
    }
    
    public static void main(String[] args){
        UserDao.addUser("blah","bleh");
    }
}
