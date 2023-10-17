package hello.embed;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import hello.servlet.HelloServlet;

public class EmbedTomcatServletMain {

	public static void main(String[] args) throws LifecycleException {
		System.out.println("EmbedTomcatServletMain.main");

		// 톰캣 설정
		Tomcat tomcat = new Tomcat(); // 내장 톰캣 생성
		Connector connector = new Connector(); // 톰캣이 제공하는 커넥터 사용
		connector.setPort(8080); // 포트 번호 설정
		tomcat.setConnector(connector); // 톰캣에 커넥터 등록

		// 서블릿 등록
		Context context = tomcat.addContext("", "/");
		tomcat.addServlet("", "helloServlet", new HelloServlet());
		context.addServletMappingDecoded("/hello-servlet", "helloServlet");
		tomcat.start(); // LifecycleException 던지기
	}

}
