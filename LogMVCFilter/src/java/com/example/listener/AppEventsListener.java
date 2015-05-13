package com.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class AppEventsListener implements ServletContextListener, HttpSessionListener{
    ServletContext context;
    public static int numSessions;

    public static int getNumSessions() {
        return numSessions;
    }

    public void setNumSessions(int numSessions) {
        this.numSessions = numSessions;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void sessionCreated(HttpSessionEvent hse) {
        log("CREATE",hse);
        numSessions++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        HttpSession session = hse.getSession();
        long start = session.getCreationTime();
        long end = session.getLastAccessedTime();
        String counter = (String) session.getAttribute("counter");
        log("DESTROY, Session Duration: " + (end-start) + "ms Counter: " + counter,hse);
        if(numSessions > 0){
            numSessions--;
        }
    }
    
    protected void log(String msg){
        System.out.println("[" + getClass().getName() + "] " + msg);
        
    }

    protected void log(String msg, HttpSessionEvent hse) {
        String id = hse.getSession().getId();
        log("Session ID: " + id + " " + msg);
    }
}
