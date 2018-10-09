package com.qualification.app.service.saveToDBService;

import com.qualification.app.model.SimpleRequest;
import com.qualification.app.repository.SimpleRequestRepository;
import com.qualification.app.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveToDBService implements IRequestService {

    @Autowired
    SimpleRequestRepository simpleRequestRepository;

    @Override
    public void remove(SimpleRequest simpleRequest) {
        simpleRequestRepository.save(simpleRequest);
    }
}
