package com.ohgiraffers.section01;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/context")
public class ContextLinstenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("context listener 확인용 서블릿");

        ServletContext context = req.getServletContext();

        context.setAttribute("test", "value");
        context.setAttribute("test2", "value");
        context.setAttribute("test2", "value2");  //동일 키 값이 다른 밸류 넣어보기
        context.removeAttribute("test");  // 키 값 없애보기
    }
}
