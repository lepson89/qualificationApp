package com.qualification.app.facade;

import com.qualification.app.enums.RequestType;
import com.qualification.app.model.SimpleRequest;
import com.qualification.app.service.IRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;

@Component
@Slf4j
public class RequestFacade implements IRequestFacade {

    @Autowired
    @Qualifier("serviceMap")
    private Map<RequestType, IRequestService> serviceMap;

    public void removeRequestFromQueue(Queue<SimpleRequest> simpleRequestQueue) {
        log.info("Start processing request...");
        try{
            processQueueElement(simpleRequestQueue);
        } catch (NoSuchElementException ex){
            log.error("The Queue is empty, nothing to do!", ex);
        } catch (NullPointerException exception){
            log.error("Simple Request is null, nothing to do!", exception);
        } finally {
            log.info("...end processing request");
        }
    }

    public void addRequestToQueue(Queue<SimpleRequest> simpleRequestQueue, SimpleRequest simpleRequest){
        simpleRequestQueue.add(simpleRequest);
    }

    private void processQueueElement(Queue<SimpleRequest> simpleRequestQueue) {
        SimpleRequest simpleRequest = simpleRequestQueue.remove();
        IRequestService requestService = getServiceForRequestType(simpleRequest.getRequestType());
        requestService.process(simpleRequest);
    }

    private IRequestService getServiceForRequestType(RequestType requestType){
        return serviceMap.get(requestType);
    }
}
