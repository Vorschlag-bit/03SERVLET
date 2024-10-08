package com.ohgiraffers.section01.xml;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

public class LifeCycleTestServlet extends HttpServlet {

    /* 설명. 기본 생성자 */
    public LifeCycleTestServlet(){
        System.out.println("xml 방식 기본 생성자 실행!");
    }

    /* 설명. Servlet의 요청이 최초인 경우 Servlet 객체를 생성하고 처음으로 호출하게 되는 메서드 */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("xml 매핑 Service() 메서드 호출!");
        System.out.println("실제로는 요청에 따라 doGet() 또는 doPost()가 실행됌");
    }

    /* 설명.
    *  서블릿 컨테이너에 의해 호출되며 최초 요청 시에만 init() 이후에 동작하고,
    *   두번째 요청부터는 바로 service()만 호출하게 된다. */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("xml 매핑 init() 메서드 호출!");
    }

    /* 설명. 컨테이너가 종료될 때 호출하는 메소드이며 주로 자원을 반납하는 용도로 사용된다. */
    @Override
    public void destroy() {
        System.out.println("xml 매핑 destroy()호출됌!");
    }


}
