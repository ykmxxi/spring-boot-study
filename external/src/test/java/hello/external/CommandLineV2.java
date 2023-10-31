package hello.external;

import java.util.List;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommandLineV2 {

    public static void main(String[] args) {
        for (String arg : args) {
            log.info("arg {}", arg);
        }

        // 스프링에 파싱할 수 있도록 객체를 생성
        ApplicationArguments appArgs = new DefaultApplicationArguments(args);
        printArgumentsSource(appArgs);
        printNonOptionArguments(appArgs);
        printOptionArgumentsName(appArgs);
        printEachOptionNameWithValue(appArgs);
        printAllArgumentsValue(appArgs);
    }

    private static void printArgumentsSource(final ApplicationArguments appArgs) {
        log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs()));
    }

    private static void printNonOptionArguments(final ApplicationArguments appArgs) {
        log.info("NonOptionArgs = {}", appArgs.getNonOptionArgs());
    }

    private static void printOptionArgumentsName(final ApplicationArguments appArgs) {
        log.info("OptionNames = {}", appArgs.getOptionNames());
    }

    private static void printEachOptionNameWithValue(final ApplicationArguments appArgs) {
        Set<String> optionNames = appArgs.getOptionNames();
        for (String optionName : optionNames) {
            log.info("option arg {}={}", optionName, appArgs.getOptionValues(optionName));
        }
    }

    private static void printAllArgumentsValue(final ApplicationArguments appArgs) {
        List<String> url = appArgs.getOptionValues("url");
        List<String> username = appArgs.getOptionValues("username");
        List<String> password = appArgs.getOptionValues("password");
        List<String> mode = appArgs.getOptionValues("mode");
        log.info("url = {}", url);
        log.info("username = {}", username);
        log.info("password = {}", password);
        log.info("mode = {}", mode);
    }

}
