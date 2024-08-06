package com.ohgiraffers.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder responsebuilder = new StringBuilder();
        responsebuilder.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>한글 servlet Response Test</h1>\n")
                .append("</body>\n")
                .append("</html>\n");

        /* 설명. tomcat 10버전 이후 MIME 생략 가능 */
//        resp.setContentType("text/plain");  지금 내보내는 문자열은 단순한 텍스트라는 MIME
        /* 설명. tomcat 10 버전부터는 최소 MIME 타입이라도 알려주자 */
        resp.setContentType("text/html;");    // MIME 타입은 생략해도 되나 생략했을 시 한글은 깨짐
        /* 설명. 1. tomcat 버전 상관없이 내보내는 데이터의 종류와 인코딩을 명시 */
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8"); // 쌉정석
        /* 설명. 1-1. 한 줄로 줄이기도 가능 */
//        resp.setContentType("text/html;charset=UTF-8");  한 줄 코딩도 가능하다

        /* 설명. 2. tomcat 10버전 이후부턴 최소 MIME 타입이라도 명시 */
        resp.setContentType("text/html");


        // 왔던 정보를 가져와서 String으로 바꾼 후 출력
        PrintWriter out = resp.getWriter();
        out.print(responsebuilder.toString());
        out.flush(); // stream을 써서 버퍼를 사용했다면 flush를 명시적으로 적용해주자
        out.close();
    }
}
