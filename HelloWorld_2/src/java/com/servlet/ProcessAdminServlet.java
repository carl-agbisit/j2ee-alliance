/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author asi
 */
public class ProcessAdminServlet extends HttpServlet{
    public void init() throws ServletException{
        
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String course = request.getParameter("course");
        String type = request.getParameter("type");
        String[] languages = request.getParameterValues("lang");
        
        PrintWriter out = response.getWriter();
        out.println("<h1>" + "Hello " + name + ".</h1>");
        out.println("<h2>Your user type is: " + type + ".</h2>");
        out.println("<h2>Are you sure you will graduate from " + course + "?</h2><hr>");
        
        out.println("<b>Languages Learned:</b><br>");
        for (String language : languages) {
            out.println(" " + language);
            out.println("<br>");
        }
        
        out.println("<hr><b>You have selected: </b>");
        String radios = request.getParameter("rad");
        out.println(radios + " as your preference.");
        
        /*
        String color = request.getParameter("col");
        out.println("<hr><b>Your Favorite Color is: </b>" + color + "!");
        String weapon = request.getParameter("wep");
        out.println("<b>Your weapon is: " + weapon + "hr>");
        */
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
    
    public void destroy(){
        
    }
}
