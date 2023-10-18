package hello.boot;

import java.util.List;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {

	/**
	 * 이 메서드를 실행하면 자동으로 톰캣과 스프링 연동 설정이 되고 실행됨
	 */
	public static void run(Class configClass, String[] args) {
		System.out.println("MySpringApplication.run" + List.of(args));

		// 톰캣 설정
		Tomcat tomcat = new Tomcat();
		Connector connector = new Connector();
		connector.setPort(8080);
		tomcat.setConnector(connector);

		// 스프링 컨테이너 생성
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(configClass);

		// 스프링 MVC 디스패처 서블릿 생성, 스프링 컨테이너 연결
		DispatcherServlet dispatcher = new DispatcherServlet(appContext);

		// 디스패처 서블릿 등록
		Context context = tomcat.addContext("", "/");
		tomcat.addServlet("", "dispatcher", dispatcher);
		context.addServletMappingDecoded("/", "dispatcher");

		try {
			tomcat.start();
		} catch (LifecycleException e) {
			throw new RuntimeException(e);
		}
	}

}
