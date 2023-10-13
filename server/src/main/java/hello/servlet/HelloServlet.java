package hello.servlet;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 프로그래밍 방식 서블릿 등록
 */
public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("HelloServlet.service");
		resp.getWriter().println("hello servlet!");
	}

}
