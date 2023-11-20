package hello.datasource;

import java.time.Duration;
import java.util.List;

import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
@ConfigurationProperties("my.datasource")
@Validated
public class MyDataSourcePropertiesV3 {

    @NotEmpty
    private final String url;
    @NotEmpty
    private final String username;
    @NotEmpty
    private final String password;
    private final Etc etc;

    public MyDataSourcePropertiesV3(
            final String url,
            final String username,
            final String password,
            final Etc etc
    ) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }

    @Getter
    public static class Etc {

        @Min(1) @Max(999)
        private final int maxConnection;
        @DurationMin(seconds = 1) @DurationMax(seconds = 60)
        private final Duration timeout;
        private final List<String> options;

        public Etc(final int maxConnection,
                   final Duration timeout,
                   @DefaultValue("DEFAULT") final List<String> options
        ) {
            this.maxConnection = maxConnection;
            this.timeout = timeout;
            this.options = options;
        }

    }

}
