package com.lwk.springboot.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by R9L4H0W on 2016/2/29.
 */
public class MyApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {

        @Override
        public void onApplicationEvent(ApplicationFailedEvent event) {
            Throwable throwable = event.getException();
            handleThrowable(throwable);
        }

        /*处理异常*/
        private void handleThrowable(Throwable throwable) {
        }


}
