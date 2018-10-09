package com.qualification.app.config;

import com.qualification.app.enums.RequestType;
import com.qualification.app.service.*;
import com.qualification.app.service.consoleOutService.ConsoleOutService;
import com.qualification.app.service.rejectedService.RejectedService;
import com.qualification.app.service.saveToDBService.SaveToDBService;
import com.qualification.app.service.saveToFileService.SaveToFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ServiceMapCreator {
    @Autowired
    ConsoleOutService consoleOutService;

    @Autowired
    RejectedService rejectedService;

    @Autowired
    SaveToDBService saveToDBService;

    @Autowired
    SaveToFileService saveToFileService;

    @Bean("serviceMap")
    public Map<RequestType, IRequestService> createServiceMap(){
        Map<RequestType, IRequestService> mpa = new LinkedHashMap<>();
            mpa.put(RequestType.FIRST, consoleOutService);
            mpa.put(RequestType.SECOND, rejectedService);
            mpa.put(RequestType.THIRD, saveToDBService);
            mpa.put(RequestType.FOURTH, saveToFileService);
        return mpa;
    }
}
