package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println("[전체 파라미터 조회] - start");
    req.getParameterNames().asIterator()
            .forEachRemaining(key -> System.out.println(key + " = " + req.getParameter(key)));
    System.out.println("[전체 파라미터 조회] - end");
    System.out.println();

    System.out.println("[단일 파라미터 조회]");
    String username = req.getParameter("username");
    String age = req.getParameter("age");
    System.out.println("username = " + username);
    System.out.println("age = " + age);
  }
}
