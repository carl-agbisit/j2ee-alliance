/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author asi
 */
public class HelloWorldServlet extends HttpServlet{
    public void init() throws ServletException{
        
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String type = request.getParameter("type");
        if(type.equals("admin")){
            RequestDispatcher rd = request.getRequestDispatcher("/AdminIndexPage.jsp");
            rd.forward(request, response);
        }
        else if(type.equals("user")){
            RequestDispatcher rd = request.getRequestDispatcher("/UserIndexPage.jsp");
            rd.forward(request, response);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
    
    public void destroy(){
        
    }
}
