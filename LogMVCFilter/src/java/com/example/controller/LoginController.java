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
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        UserBean userBean = new UserBean();
        userBean.setPassword(password);
        userBean.setUsername(username);
        
        boolean isUserValid = UserDao.isValid(userBean);
        
        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        
        String val = (String) session.getAttribute("counter");
        int counter = 1;
        if(val!=null){
            counter = Integer.parseInt(val);
            counter++;
        }
        session.setAttribute("counter", String.valueOf(counter));
        
        if(isUserValid){
            session.setAttribute("users", UserDao.getAllUsers());
            RequestDispatcher view = req.getRequestDispatcher("/home.jsp");
            view.forward(req, resp);
        }
        else{
            resp.sendRedirect("index.html");
        }
    }
}
