package com.ohgiraffers.section01.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("======= 포워딩된 서블릿에서 넘겨 받은 req 객체에 담긴 값 확인 =======");
        System.out.println("name: " + req.getAttribute("userName"));
        System.out.println("password: " + req.getParameter("password"));
        System.out.println("Id: " + req.getParameter("userId"));

        String userName = (String) req.getAttribute("userName");
        StringBuilder respText = new StringBuilder();
        respText.append("<h3 align=\"center\">")
                .append(userName)
                .append("님 환영합니다. </h3>");

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print(respText);
        out.flush();
        out.close();
    }
}
