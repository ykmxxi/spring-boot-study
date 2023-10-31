package hello;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EnvironmentCheck {

    private final Environment environment;

    public EnvironmentCheck(final Environment environment) {
        this.environment = environment;
    }

    @PostConstruct
    public void init() {
        String url = environment.getProperty("url");
        String username = environment.getProperty("username");
        String password = environment.getProperty("password");

        log.info("env url = {}", url);
        log.info("env username = {}", username);
        log.info("env password = {}", password);
    }

}
