package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/member/*")
public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // encoding Filter 예제클라스
        /* 설명. 우린 톰캣 10버전인데 톰캣 10버전 미만일 경우 post 요청에 대해 인코딩 설정을 해 주어야 한다. */
        /* 설명. 필터를 활용해 request 객체에 인코딩 설정을 적용하고(전처리) 다음 필터나 서블릿으로 넘겨준다. */
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if("POST".equals(request.getMethod())) {
            request.setCharacterEncoding("UTF-8");  // request는 다운캐스팅을 함(set을 거쳐)
        }

        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
