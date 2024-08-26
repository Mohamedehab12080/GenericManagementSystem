package com.MO.Software;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.MO.Software")
public class SoftwareApplication {

//    private static ApplicationContext context;
//    private static Login loginFrame;
//	private static ConfigurableApplicationContext context;
	
public static void main(String[] args) {
//    // Set headless mode
//    System.setProperty("java.awt.headless", "true");

    // Start the Spring Boot application
   SpringApplication.run(SoftwareApplication.class, args);

    // Start the Swing GUI in a separate thread
//    new Thread(() -> {
//        loginFrame = new Login(context);
//        java.awt.EventQueue.invokeLater(() -> loginFrame.setVisible(true));
//    }).start();
}
}
