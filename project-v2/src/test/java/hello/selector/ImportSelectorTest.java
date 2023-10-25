package hello.selector;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

class ImportSelectorTest {

	@Test
	@DisplayName("정적인 방법")
	void staticConfig() {
		// given
		AnnotationConfigApplicationContext appContext =
				new AnnotationConfigApplicationContext(StaticConfig.class);

		// when
		HelloBean bean = appContext.getBean(HelloBean.class);

		// then
		assertThat(bean).isNotNull();
	}

	@Configuration
	@Import(HelloConfig.class)
	public static class StaticConfig {
	}

	@Test
	@DisplayName("동적인 방법")
	void selectorConfig() {
		// given
		AnnotationConfigApplicationContext appContext =
				new AnnotationConfigApplicationContext(SelectorConfig.class);

		// when
		HelloBean bean = appContext.getBean(HelloBean.class);

		// then
		assertThat(bean).isNotNull();
	}

	@Configuration
	@Import(HelloImportSelector.class)
	public static class SelectorConfig {
	}

}
