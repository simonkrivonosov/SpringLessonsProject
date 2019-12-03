package lessons.services;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class BlackListNotifier implements ApplicationListener {

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        // уведомляются заинтересованные участники в notificationAddress...
    }
}
