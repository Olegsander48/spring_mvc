package com.udemy.mvc.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/fail")
public class ExceptionHandlingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //empty
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            chain.doFilter(request, response); // выполняем цепочку фильтров/сервлетов
        } catch (Exception e) {
            // Логирование
            e.printStackTrace();

            // Отправляем простой HTML ответ
            HttpServletResponse httpResp = (HttpServletResponse) response;
            httpResp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpResp.setContentType("text/html;charset=UTF-8");

            //http://localhost:8080/fail
            httpResp.getWriter().write("<h1>Произошла ошибка</h1><p>" + e.getMessage() + "</p>");
        }
    }

    @Override
    public void destroy() {
        //empty
    }
}
