package com.ohgiraffers.section01;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;

@WebListener
public class ContextListener implements ServletContextListener, ServletContextAttributeListener {
    public ContextListener() {
        System.out.println("context listener created");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("context attribute added!! ");
        System.out.println("event.getName() = " + event.getName());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("context attribute removed!! ");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("context attribute replaced!! ");
    }
}
