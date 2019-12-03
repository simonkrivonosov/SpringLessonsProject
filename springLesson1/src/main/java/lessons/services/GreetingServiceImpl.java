package lessons.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("greetingService")
@Scope("prototype")
//@Qualifier("main")
public class GreetingServiceImpl implements GreetingService, InitializingBean, DisposableBean {
    private static final Logger logger = LogManager.getLogger(GreetingService.class);


    @Override
    public String sayGreeting() {
        return "Greeting, user!";
    }

    @Override
    public void destroy() {
        logger.info("invoke destroy method");
    }

    @Override
    public void afterPropertiesSet() {
        logger.info("invoke afterPropertiesSet method");
    }
    @Override
    public void initMethod() {
        logger.info("invoke initMethod method");
    }
    @Override
    public void destroyMethod() {
        logger.info("invoke destroyMethod method000");
    }

    private ApplicationContext context;

    //@Required
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @PostConstruct
    public void postConstructMethod() { logger.info("invoke postConctructMethod method"); }

    @PostConstruct
    public void anotherPostConstructMethod() { logger.info("invoke anotherPostConstructMethod method"); }

    @PreDestroy
    public void preDestroyMethod() { logger.info("invoke preDestroyMethod method"); }
}
