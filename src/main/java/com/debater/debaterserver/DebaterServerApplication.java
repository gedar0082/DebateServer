package com.debater.debaterserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DebaterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DebaterServerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void greeting(){
        System.out.println("################################################################");
        System.out.println("SERVER STARTED");
        System.out.println("################################################################");
    }

}
