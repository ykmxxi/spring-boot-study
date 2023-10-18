package hello.boot;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;

@Target(ElementType.TYPE) // 클래스, 인터페이스 레벨에 붙음
@Retention(RetentionPolicy.RUNTIME) // 런타임 시점까지 유지(Reflection API 로 애노테이션 정보 조회 가능)
@Documented
@ComponentScan
public @interface MySpringBootApplication {
}
