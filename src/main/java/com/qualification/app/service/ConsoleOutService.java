package com.qualification.app.service;

import com.qualification.app.model.SimpleRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class ConsoleOutService implements IRequestService {

    @Override
    public void process(SimpleRequest simpleRequest) {
        System.out.print(simpleRequest);
    }
}
