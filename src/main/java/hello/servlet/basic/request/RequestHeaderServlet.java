package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    printStartLine(req);
    printHeaders(req);
    printHeaderUtils(req);

    printEtc(req);
  }

  private void printEtc(HttpServletRequest req) {
    System.out.println("--- 기타 조회 start ---");

    System.out.println("[Remote 정보]");
    System.out.println("req.getRemoteHost() = " + req.getRemoteHost());
    System.out.println("req.getRemoteAddr() = " + req.getRemoteAddr());
    System.out.println("req.getRemotePort() = " + req.getRemotePort());
    System.out.println();

    System.out.println("[Local 정보]");
    System.out.println("req.getLocalName() = " + req.getLocalName());
    System.out.println("req.getLocalAddr() = " + req.getLocalAddr());
    System.out.println("req.getLocalPort() = " + req.getLocalPort());

    System.out.println("--- 기타 조회 end ---");
    System.out.println();
  }

  private void printHeaderUtils(HttpServletRequest req) {
    System.out.println("--- Header 편의 조회 start ---");
    System.out.println("[Host 편의 조회]");
    System.out.println("req.getServerName() = " + req.getServerName()); //Host 헤더
    System.out.println("req.getServerPort() = " + req.getServerPort()); //Host 헤더 System.out.println();

    System.out.println("[Accept-Language 편의 조회]");
    req.getLocales().asIterator().forEachRemaining(locale -> System.out.println("locale = " + locale));
    System.out.println("req.getLocale() = " + req.getLocale());
    System.out.println();

    System.out.println("[cookie 편의 조회]");
    if (req.getCookies() != null) {
      for (Cookie cookie : req.getCookies()) {
        System.out.println(cookie.getName() + ": " + cookie.getValue());
      }
    }
    System.out.println();
    System.out.println("[Content 편의 조회]");
    System.out.println("req.getContentType() = " + req.getContentType());
    System.out.println("req.getContentLength() = " + req.getContentLength());
    System.out.println("req.getCharacterEncoding() = " + req.getCharacterEncoding());

    System.out.println("--- Header 편의 조회 end ---");
    System.out.println();
  }

  private void printHeaders(HttpServletRequest req) {
    System.out.println("--- Headers - start ---");
    req.getHeaderNames().asIterator()
            .forEachRemaining(headerName -> System.out.println(headerName + ": " +
                    "" + req.getHeader(headerName)));
    System.out.println("--- Headers - end ---");
    System.out.println();
  }

  private void printStartLine(HttpServletRequest req) {
    System.out.println("--- REQUEST-LINE - start ---");
    System.out.println("req.getMethod() = " + req.getMethod()); //GET
    System.out.println("req.getProtocal() = " + req.getProtocol()); // HTTP/1.1
    System.out.println("req.getScheme() = " + req.getScheme()); //http // http://localhost:8080/req-header
    System.out.println("req.getRequestURL() = " + req.getRequestURL()); // /req-test
    System.out.println("req.getRequestURI() = " + req.getRequestURI()); //username=hi
    System.out.println("req.getQueryString() = " + req.getQueryString());
    System.out.println("req.isSecure() = " + req.isSecure()); //https 사용 유무
    System.out.println("--- REQUEST-LINE - end ---");
    System.out.println();
  }
}
