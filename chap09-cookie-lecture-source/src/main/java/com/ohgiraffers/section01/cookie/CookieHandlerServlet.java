package com.ohgiraffers.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("lastName = " + lastName);
        System.out.println("firstName = " + firstName);

        /* 설명.
        *   쿠키(클라이언트의 브라우저에 저장)를 생성하고 사용하는 방법
        *  1. 쿠키 인스턴스를 생성한다.
        *  2. 해당 쿠키의 만료시간을 설정한다.
        *  3. 응답 헤더에 쿠키를 담는다.
        *  4. 응답한다.
        *  */

        Cookie firstnameCookie = new Cookie("firstName", firstName);
        Cookie lastnameCookie = new Cookie("lastName", lastName);

        firstnameCookie.setMaxAge(60 * 60 * 24);  // 초, 시간, 일수 단위
        lastnameCookie.setMaxAge(60 * 60 * 12);   // 12hours

        /* 설명. Reponse Header에 추가 */
        resp.addCookie(firstnameCookie);
        resp.addCookie(lastnameCookie);

        resp.sendRedirect("redirect");
    }
}
