package lessons;

//import lessons.services.GreetingService;

import lessons.services.CommandManager;
import lessons.services.GreetingService;
import lessons.services.GreetingServiceImpl;
import lessons.services.GreetingServiceImplTest;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Конфигурационный класс Spring IoC контейнера
 */
@Configuration
@ComponentScan(basePackages = "lessons.services")
@Import(AnotherConfiguration.class)
public class LessonsConfiguration {
    // такое рабоатет только в configuration файлах
/*    @Bean
    BeanWithDependency beanWithDependency() {
        return new BeanWithDependency(greetingService());
    }*/

/*    @Bean(name = "ServiceName")
    //@Bean
    GreetingService greetingService() {
        return new GreetingServiceImpl();
    }*/

    @Bean(name = "gServiceName")
    GreetingService greetingService2() {
        return new GreetingServiceImplTest();
    }
    @Bean
    @Scope("prototype")
    //@Bean(name = "greetingService")
    //@Qualifier("main")
    GreetingService greetingService() {
        return new GreetingServiceImpl();
    }

    @Bean
    MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

/*    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @Description("Текстовое описание бина greetingService")
    GreetingService greetingService() {
        return new GreetingServiceImpl();
    }*/

/*    @Bean(name = {"gServiceName", "gServiceAnotherNamed"})
    @Scope("prototype")
    GreetingService gService() {
        return new GreetingServiceImpl();
    }*/

    @Bean
    @Scope("prototype")
    public Object asyncCommand() {
        return new Object();
    }

    @Bean
    public CommandManager commandManager() {
        // возвращаем новую анонимную реализацию CommandManager
        // с новым объектом
        return new CommandManager() {
            protected Object createCommand() {
                return asyncCommand();
            }
        };
    }


}

/*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ClsB.class, ClsA.class})
public class ClsTest {
    @Autowired
    @Qualifier("ClasA") //this is the place where @Qualifier can be used
            String smthA;

    @Autowired
    @Qualifier("ClasB")
    String smthB;

    @Test
    public void test() {
        System.out.println(smthA);
        System.out.println(smthB);
    }
}*/
