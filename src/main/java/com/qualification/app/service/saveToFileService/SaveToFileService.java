package com.qualification.app.service.saveToFileService;

import com.qualification.app.model.SimpleRequest;
import com.qualification.app.service.IRequestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
public class SaveToFileService implements IRequestService {

    private static final String FILE_SUFFIX = "tmp";
    private static final String FILE_PREFIX = ".dat";

    public void remove(SimpleRequest simpleRequest){
        File file = null;
        try {
            file  = File.createTempFile(FILE_SUFFIX, FILE_PREFIX);
            FileUtils.writeStringToFile(file, simpleRequest.getData());
        } catch (IOException e) {
            log.error("ERROR WHEN SAVING FILE!", e);
        } finally {
            file.deleteOnExit();
        }
        log.info(file.getAbsolutePath());
    }

}
