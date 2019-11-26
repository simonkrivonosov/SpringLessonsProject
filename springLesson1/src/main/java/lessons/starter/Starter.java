package lessons.starter;

import lessons.LessonsConfiguration;
import lessons.services.GreetingService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Starter {

    private static final Logger logger = LogManager.getLogger(Starter.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("Starting configuration...");

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(LessonsConfiguration.class);
        //GreetingService greetingService = context.getBean(GreetingService.class);
        GreetingService greetingService = (GreetingService) context.getBean("ServiceName");
        logger.info(greetingService.sayGreeting());  // "Greeting, user!"
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(LessonsConfiguration.class);
        context.refresh();*/
        context.close();
    }
}
