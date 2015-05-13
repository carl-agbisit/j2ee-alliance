package com.example.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter{
    private ServletContext context;

    @Override
    public void init(FilterConfig fc) throws ServletException {
        this.context = fc.getServletContext();
        this.context.log("Authentication Filter initialized");
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) sr;
        HttpServletResponse res = (HttpServletResponse) sr1;
        
        String uri = req.getRequestURI();
        this.context.log("Requested resource: " + uri);
        
        HttpSession session = req.getSession(false);
        if(session == null && !(uri.endsWith("html") || uri.endsWith("login"))){
            this.context.log("Unauthorized Access Request");
            res.sendRedirect("index.html");
        }
        else{
            fc.doFilter(sr, sr1);
        }
    }

    @Override
    public void destroy() {
    }
    
}
