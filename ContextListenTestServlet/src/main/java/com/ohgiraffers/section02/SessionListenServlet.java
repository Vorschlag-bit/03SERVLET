package com.ohgiraffers.section02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionListenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("서블릿에서 Session 출력: " + session.getClass().getName());

        session.setAttribute("userName", "honggildong");
        session.setAttribute("age", 20);
        session.setAttribute("gender", "M");

        session.setAttribute("userName", "hong");
        session.setAttribute("user", new UserDTD(20, "honggildong"));

        session.removeAttribute("user");

        session.invalidate();
    }
}
