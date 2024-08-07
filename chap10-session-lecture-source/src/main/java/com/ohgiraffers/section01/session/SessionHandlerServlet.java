package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("firstname: " + req.getParameter("firstName"));
        System.out.println("lastName: " + req.getParameter("lastName"));

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        /* 설명.
        *  요청이 서블릿으로 들어올 때 HttpServletRequest의 header에는 JSESSIONID라는 값이 들어있고
        *  이를 활용해 JSESSIONID별로 HttpSession 객체를 생성해서 해당 사용자를 위한 전용 저장 공간을
        *  제공하게 된다.
        * */
        HttpSession session = req.getSession();
        // 30분이 기본값으로 설정되어있다.
        System.out.println("session" + "의 default 유지시간: " + session.getMaxInactiveInterval());
        session.setMaxInactiveInterval(60 * 10);  // 초 단위로 10분
        System.out.println("Session의 JSESSIONID: " + session.getId());

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        resp.sendRedirect("redirect");

    }
}
