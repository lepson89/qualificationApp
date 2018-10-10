package com.qualification.app.service;

import com.qualification.app.enums.RequestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@ComponentScan("com.qualification.app.service")
public class ServiceMapCreator {

    @Autowired
    private  ConsoleOutService consoleOutService;

    @Autowired
    private RejectedService rejectedService;

    @Autowired
    private SaveToDBService saveToDBService;

    @Autowired
    private SaveToFileService saveToFileService;

    @Bean("serviceMap")
    public Map<RequestType, IRequestService> createServiceMap(){
        Map<RequestType, IRequestService> mpa = new LinkedHashMap<>();
            mpa.put(RequestType.FIRST, saveToDBService);
            mpa.put(RequestType.SECOND, rejectedService);
            mpa.put(RequestType.THIRD, saveToFileService);
            mpa.put(RequestType.FOURTH, consoleOutService);
        return mpa;
    }
}
