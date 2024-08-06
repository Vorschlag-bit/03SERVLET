package com.ohgiraffers.section02.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

@WebServlet("/header")
public class ResponseHeaderPrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 설명. 서버의 현재 시간을 동적 페이지로 만들어 내보내 보자. */
        resp.setContentType("text/plain");

        PrintWriter writer = resp.getWriter(); // 스트림 열기 이 통로로 나갈 때는 위의 정보가 나감

        long currentTime = System.currentTimeMillis();
        writer.print("<h1>" + currentTime + "</h1>");
        writer.print("<h1>" + new java.util.Date(currentTime) + "</h1>");
        writer.flush();
        writer.close();

        /* 설명. response 객체의 header 값에 대한 키값과 value 값을 한 번에 확인해 보기 */
        Collection<String> respHeaders = resp.getHeaderNames();
        Iterator<String> iterator = respHeaders.iterator();
        while (iterator.hasNext()) {
            String headerName = iterator.next();
            System.out.println("headerName = " + resp.getHeader(headerName));
        }
    }
}
