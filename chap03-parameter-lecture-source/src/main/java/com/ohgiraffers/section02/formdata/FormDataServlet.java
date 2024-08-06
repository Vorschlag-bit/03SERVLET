package com.ohgiraffers.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/formdata")
public class FormDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 설명. tomcat 9버전 이하는 post 요청일 시 인코딩 설정을 하지 않으면 한글이 깨진다 */
//        req.setCharacterEncoding("UTF-8"); 우린 10버전이긴 하나, 현업에선 어떤 걸 쓸지 모르니 알아두자

        /* 설명. get 방식과 동일 */
        String name = req.getParameter("name");
        System.out.println("name = " + name);

        /* 설명. 요청으로 사용자가 넘겨준 모든 parameter들의 키값 추출 */
        // 프론트의 키값을 다 아는 건 아니고 서버 입장에서 키값을 일일이 확인하기 힘들 때 사용(키 값만 뽑기)
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }
    }
}
