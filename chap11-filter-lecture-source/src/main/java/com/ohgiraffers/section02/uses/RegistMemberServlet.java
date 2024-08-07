package com.ohgiraffers.section02.uses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String  password = req.getParameter("password");
        String name = req.getParameter("name");

        // plain text 넘어오는지 확인
        System.out.println("userId = " + userId);
        System.out.println("password = " + password);
        System.out.println("name = " + name);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("비밀번호가 pass04인지 확인: "
                + passwordEncoder.matches("pass04", password));
        System.out.println("비밀번호가 pass44인지 확인: "
                + passwordEncoder.matches("$2a$10$jpx8To3UAZEWoQXDbFPK4.HIoGoR5c4QglreUVDm5Ic0dZ0rgmQ9O", password));
    }
}
