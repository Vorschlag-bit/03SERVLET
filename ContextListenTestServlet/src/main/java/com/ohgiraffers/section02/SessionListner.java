package com.ohgiraffers.section02;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListner implements HttpSessionListener, HttpSessionAttributeListener {

    public SessionListner() {
        System.out.println("session listener instance created!");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session created!");
        System.out.println("생성 sessionId: " + se.getSession().getId());
        System.out.println("session 객체 타입: " +se.getSession().getClass().getName());
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("attribute added!");
        System.out.println("session 추가된 attr: " + event.getName() + ", " + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("session attribute replaced!");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("session attribute removed!");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session destroyed!");
    }
}
