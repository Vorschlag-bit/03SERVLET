package com.ohgiraffers.section02.delete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        System.out.println("attribute 확인(만료 전 = 로그인): " + session.getAttribute("firstName"));
        System.out.println("attribute 확인(만료 전 = 로그인): " + session.getAttribute("lastName"));

        // 사물함을 파괴, HttpSession 무효화
        session.invalidate();
        System.out.println("attribute 확인(만료 후 = 로그아웃): " + session.getAttribute("firstName"));
        System.out.println("attribute 확인(만료 후 = 로그아웃): " + session.getAttribute("lastName"));
    }
}
