package com.lwk.springboot.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Created by R9L4H0W on 2016/2/29.
 */
public class MyApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {

    private Logger logger = LoggerFactory.getLogger(MyApplicationPreparedEventListener.class);


        @Override
        public void onApplicationEvent(ApplicationPreparedEvent event) {
            ConfigurableApplicationContext cac = event.getApplicationContext();
            passContextInfo(cac);
        }

        /**
         * 传递上下文
         * @param cac
         */
        private void passContextInfo(ApplicationContext cac) {
            //dosomething()
        }
}
