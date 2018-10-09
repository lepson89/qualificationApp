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

@SpringBootApplication
@ComponentScan("com.qualification.app")
@EnableJpaRepositories("com.qualification.app.repository")
@EnableJpaAuditing
@EntityScan("com.qualification.app.model")
public class AppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Autowired
    IRequestFacade requestFacade;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 25 ; i++) {
            SimpleRequest simpleRequest = new SimpleRequest("asdasd"+i, RequestType.FOURTH);
            requestFacade.removeFromQueue(simpleRequest);
        }
    }
}
