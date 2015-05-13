package com.example.controller;

import com.example.dao.UserDao;
import com.example.model.UserBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserControlServlet extends HttpServlet{
    
    private static final String addOrEdit = "/user.jsp";
    private static final String home = "/home.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = req.getParameter("mode");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        if(mode.equals("add")){
            UserDao.addUser(username, password);
        }
        else if(mode.equals("edit")){
            UserBean nUser = new UserBean();
            int id = Integer.parseInt(req.getParameter("id"));
            nUser.setUsername(username);
            nUser.setPassword(password);
            nUser.setUserid(id);
            UserDao.updateUser(nUser);
        }
        
        HttpSession session = req.getSession();
        session.setAttribute("users", UserDao.getAllUsers());
        RequestDispatcher rd = req.getRequestDispatcher(home);
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward ="";
        
        String action = req.getParameter("action");
        if(action.equals("add")){
            forward = addOrEdit;
        }
        else if(action.equals("edit")){
            int userid = Integer.parseInt(req.getParameter("userid"));
            UserBean user = UserDao.getUserById(userid);
            req.setAttribute("user", user);
            forward = addOrEdit;
        }
        else if(action.equals("delete")){
            int userid = Integer.parseInt(req.getParameter("userid"));
            UserDao.deleteUser(userid);
            forward = home;
            HttpSession session = req.getSession();
            session.setAttribute("users", UserDao.getAllUsers());
        }
        req.setAttribute("mode", action);
        RequestDispatcher rd = req.getRequestDispatcher(forward);
        rd.forward(req, resp);
    }
    
}
