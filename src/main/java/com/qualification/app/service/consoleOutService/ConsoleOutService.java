package com.qualification.app.service.consoleOutService;

import com.qualification.app.model.SimpleRequest;
import com.qualification.app.service.IRequestService;
import org.springframework.stereotype.Service;

@Service
public class ConsoleOutService implements IRequestService {
    @Override
    public void remove(SimpleRequest simpleRequest) {
        System.out.println("console");
    }
}
