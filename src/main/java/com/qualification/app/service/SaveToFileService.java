package com.qualification.app.service;

import com.qualification.app.model.SimpleRequest;
import com.qualification.app.service.IRequestService;
import com.qualification.app.utils.Constants;
import com.qualification.app.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
class SaveToFileService implements IRequestService {



    public void process(SimpleRequest simpleRequest){
        log.info("Request is Type 3, save Request in File");
        File file = null;
        try {
            file = new File(Constants.FILE_PATH + DateUtils.getStringDateNow() + Constants.FILE_SUFFIX);
            FileUtils.writeStringToFile(file, simpleRequest.getData());
        } catch (IOException e) {
            log.error("Error when saving request data in file.txt!", e);
        }
        log.info("File save in" + file.getAbsolutePath());
    }

}
