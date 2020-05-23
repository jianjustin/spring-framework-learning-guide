package org.janine.jian;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTestMain {
	public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:application.xml");
        Hello hello = (Hello)ac.getBean("hello");
        hello.speech();
    }

}
