package com.example.controller;

import com.example.dao.UserDao;
import com.example.model.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UserBean userBean = new UserBean();
        userBean.setPassword(password);
        userBean.setUsername(username);
        
        boolean isUserValid = UserDao.isValid(userBean);
        
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        
        if(isUserValid){
            session.setAttribute("users", UserDao.getAllUsers());
            RequestDispatcher view = request.getRequestDispatcher("/home.jsp");
            view.forward(request, response);
        }
        else{
            response.sendRedirect("index.html");
        }
    }
}
