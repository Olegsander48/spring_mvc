package com.udemy.mvc.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/error-example")
public class ErrorHandlingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        try {
            String param = req.getParameter("num");
            if (param == null) {
                throw new IllegalArgumentException("Параметр 'num' обязателен.");
            }

            int number = Integer.parseInt(param);
            int result = 100 / number;

            //http://localhost:8080/error-example?num=12
            out.println("<h1>Результат: " + result + "</h1>");

        } catch (NumberFormatException e) {
            //http://localhost:8080/error-example?num=ADSF
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("<h2 style='color:red;'>Ошибка: параметр 'num' должен быть числом.</h2>");
        } catch (ArithmeticException e) {
            //http://localhost:8080/error-example?num=0
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("<h2 style='color:red;'>Ошибка: деление на ноль.</h2>");
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("<h2 style='color:red;'>Произошла ошибка: " + e.getMessage() + "</h2>");
        } finally {
            out.close();
        }
    }
}
