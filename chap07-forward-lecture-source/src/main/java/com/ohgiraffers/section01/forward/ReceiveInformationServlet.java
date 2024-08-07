package com.ohgiraffers.section01.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);

        /* 설명.
        *  이 부분에서는 id와 pw에 해당하는 user의 정보를 select하고 오는 비즈니스 로직(BL)이
        *   수행되어야 한다.(이름을 조회해서 이름을 알게 됨)
        *   우리는 제대로 조회가 되었다는 가정 하에 'xxx님 환영합니다.'와 같은 메시지를 출력하는
        *   화면을 만들어 보자
        * */

        req.setAttribute("userName", "홍길동");

        RequestDispatcher dispatcher = req.getRequestDispatcher("print");
        dispatcher.forward(req, resp);

    }
}
