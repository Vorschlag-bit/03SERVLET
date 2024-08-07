package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class ReidirectServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // Attribute로 담았으므로 Attribute로 꺼낸다, Attribute로 꺼낼 때는 항상 다운 캐스팅을 해줘야 한다.(Object가 기본)
        String firstName = (String) session.getAttribute("firstName");
        String lastName = (String) session.getAttribute("lastName");

        StringBuilder text = new StringBuilder();
        text.append("<h3>your firstname is ")
                .append(firstName)
                .append("\n and lastname is ")
                .append(lastName)
                .append("</h3>");

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print(text);
        writer.flush();
        writer.close();
    }
}
