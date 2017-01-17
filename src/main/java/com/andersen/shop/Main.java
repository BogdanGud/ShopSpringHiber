package com.andersen.shop;


import com.andersen.shop.controller.ConsoleController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        ConsoleController consoleController = applicationContext.getBean(ConsoleController.class);
        consoleController.start();
    }
}
