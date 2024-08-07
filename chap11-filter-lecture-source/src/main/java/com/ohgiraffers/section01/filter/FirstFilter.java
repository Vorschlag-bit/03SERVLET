package com.ohgiraffers.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

@WebFilter("/first/*")
public class FirstFilter implements Filter {

    public FirstFilter() {
        System.out.println("FirstFilter instantiated!!");
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter destroyed!!");
    }

    // 필터 설치 이유
    // 1. 필터를 통과하면서 log 수집이 가능하다. 2. 필터에서 인코딩 설정을 해줄 수 있음 3. 비밀번호 암호화를 처리할 수 있다
    // 4. 유효성 검사
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FirstFilter doFilter!!");

        /* 설명. FilterChain에서 제공하는 doFilter를 활용하여 다음 필터 또는 서블릿을 진행시킬 수 있다. */
        filterChain.doFilter(servletRequest, servletResponse); // 이 다음 필터 없으면 서블릿으로 넘어가게 한다

        System.out.println("서블릿 다녀온 후 입니다."); // 필터를 수 차례 다녀온 후 실행되는 구문
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter init!!");
    }
}
