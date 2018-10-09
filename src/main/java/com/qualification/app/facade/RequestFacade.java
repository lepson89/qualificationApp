package com.qualification.app.facade;

import com.qualification.app.enums.RequestType;
import com.qualification.app.model.SimpleRequest;
import com.qualification.app.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RequestFacade implements IRequestFacade {

    @Autowired
    @Qualifier("serviceMap")
    private Map<RequestType, IRequestService> serviceMap;

    public void removeFromQueue(SimpleRequest simpleRequest){
        IRequestService service = serviceMap.get(simpleRequest.getRequestType());
        service.remove(simpleRequest);
    }
}
