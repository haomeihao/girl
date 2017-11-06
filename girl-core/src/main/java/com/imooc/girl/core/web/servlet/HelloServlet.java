package com.imooc.girl.core.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hmh on 2017/8/17.
 */
@WebServlet(urlPatterns = "/helloServlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("GBK");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Servlet实例</title></head>");
        out.println("<body>");
        out.print("Servlet实例：");
        out.print(this.getClass());
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
}
