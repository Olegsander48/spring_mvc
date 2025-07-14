package com.udemy.mvc.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deadlock")
public class DeadLockServlet extends HttpServlet {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                    ignored.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("Thread 1 acquired both locks");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                    ignored.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("Thread 2 acquired both locks");
                }
            }
        });

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        resp.getWriter().println("Threads started");
    }
}
