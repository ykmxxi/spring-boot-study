package hello.container;

import java.util.Set;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public class MyContainerV1 implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		System.out.println("MyContainerV1.onStartup");
		System.out.println("MyContainerV1 c = " + c);
		System.out.println("MyContainerV1 ctx = " + ctx);
	}

}
