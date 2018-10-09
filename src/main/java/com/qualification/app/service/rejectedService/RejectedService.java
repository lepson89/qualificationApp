package com.qualification.app.service.rejectedService;

import com.qualification.app.model.SimpleRequest;
import com.qualification.app.service.IRequestService;
import org.springframework.stereotype.Service;

@Service
public class RejectedService implements IRequestService {
    @Override
    public void remove(SimpleRequest simpleRequest) {
        System.out.println("Request has benn rejected!");
    }
}
