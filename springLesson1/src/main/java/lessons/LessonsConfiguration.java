package lessons;

//import lessons.services.GreetingService;

import lessons.services.BeanWithDependency;
import lessons.services.GreetingService;
import lessons.services.GreetingServiceImpl;
import lessons.services.GreetingServiceImplTest;
import org.springframework.context.annotation.*;

/**
 * Конфигурационный класс Spring IoC контейнера
 */
@Configuration
//@ComponentScan
@ComponentScan(basePackages = "lessons.services")
public class LessonsConfiguration {
    // такое рабоатет только в configuration файлах
    @Bean
    BeanWithDependency beanWithDependency() {
        return new BeanWithDependency(greetingService());
    }

    @Bean(name = "ServiceName")
    //@Bean
    GreetingService greetingService() {
        return new GreetingServiceImpl();
    }

    @Bean(name = "gServiceName")
    GreetingService greetingService2() {
        return new GreetingServiceImplTest();
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @Description("Текстовое описание бина greetingService")
    GreetingService greetingService3() {
        return new GreetingServiceImpl();
    }

    @Bean(name = {"gServiceName", "gServiceAnotherNamed"})
    @Scope("prototype")
    GreetingService gService() {
        return new GreetingServiceImpl();
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
