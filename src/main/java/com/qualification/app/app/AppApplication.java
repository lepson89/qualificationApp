package com.qualification.app.app;

import com.qualification.app.enums.RequestType;
import com.qualification.app.model.SimpleRequest;
import com.qualification.app.facade.IRequestFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.LinkedList;
import java.util.Queue;

@SpringBootApplication
@ComponentScan("com.qualification.app")
@EnableJpaRepositories("com.qualification.app.repository")
@EnableJpaAuditing
@EntityScan("com.qualification.app.model")
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
