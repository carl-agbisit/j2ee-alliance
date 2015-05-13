/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author asi
 */
public class TimeOutListener implements HttpSessionListener{

    @Override
    public void sessionCreated(HttpSessionEvent hse) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
    }
    
}
