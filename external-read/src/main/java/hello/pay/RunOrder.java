package hello.pay;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RunOrder implements ApplicationRunner {

    private final OrderService orderService;

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        orderService.order(1000);
    }

}
