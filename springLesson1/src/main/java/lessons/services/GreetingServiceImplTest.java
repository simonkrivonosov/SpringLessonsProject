package lessons.services;

import org.springframework.stereotype.Component;

@Component
public class GreetingServiceImplTest implements GreetingService {

    @Override
    public String sayGreeting() {
        return "This is test impl";
    }

    @Override
    public void initMethod() {

    }

    @Override
    public void destroyMethod() {

    }
}
