package lessons.starter;

import lessons.LessonsConfiguration;
import lessons.services.BeanWithDependency;
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
        GreetingService greetingService = (GreetingService) context.getBean("gServiceName");
        BeanWithDependency withDependency = context.getBean(BeanWithDependency.class);
        logger.info(greetingService.sayGreeting()); // "Greeting, user!"
        logger.info(withDependency.printText()); // "Some text!"

        //В случае с @Scope("prototype") hashCode будет отличаться
        //logger.info(context.getBean(GreetingService.class));
        //logger.info(context.getBean(GreetingService.class));
        //********************************************************

        logger.info(context.getBean("greetingService"));

        //logger.info("Message: " + context.getMessage("message", null, Locale.getDefault()));
        //logger.info("Argument.required: " + context.getMessage("argument.required", new Object[]{"Test_UK_Argument"}, Locale.UK));

        context.registerShutdownHook();
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(LessonsConfiguration.class);
        context.refresh();*/
        //context.close();
    }
}
