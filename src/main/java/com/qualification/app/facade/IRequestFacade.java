package com.qualification.app.facade;

import com.qualification.app.model.SimpleRequest;

import java.util.Queue;

public interface IRequestFacade {
    void removeRequestFromQueue(Queue<SimpleRequest> simpleRequestQueue);
    void addRequestToQueue(Queue<SimpleRequest> simpleRequestQueue, SimpleRequest simpleRequest);
}
