package hello.datasource;

import java.time.Duration;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import lombok.Getter;

@Getter
@ConfigurationProperties("my.datasource")
public class MyDataSourcePropertiesV2 {

    private final String url;
    private final String username;
    private final String password;
    private final Etc etc;

    // @ConstructorBinding // 스프링 부트 3.0 부터는 생성자가 1개면 생략 가능
    public MyDataSourcePropertiesV2(
            final String url,
            final String username,
            final String password,
            @DefaultValue final Etc etc
    ) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }

    @Getter
    public static class Etc {

        private final int maxConnection;
        private final Duration duration;
        private final List<String> options;

        public Etc(final int maxConnection,
                   final Duration duration,
                   @DefaultValue("DEFAULT") final List<String> options
        ) {
            this.maxConnection = maxConnection;
            this.duration = duration;
            this.options = options;
        }

    }

}
