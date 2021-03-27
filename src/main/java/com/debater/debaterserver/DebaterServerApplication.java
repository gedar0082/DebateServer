package com.debater.debaterserver;

import com.debater.debaterserver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DebaterServerApplication {

    @Autowired
    private PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(DebaterServerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    private void testJPA(){
        personService.findAllPerson().forEach(it -> System.out.println(it.toString()));
        personService.findAllPersonByNickname("idc").forEach(it -> System.out.println(it.toString()));
    }

}
