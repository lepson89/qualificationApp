package com.qualification.app.service

import com.qualification.app.app.AppApplication
import com.qualification.app.enums.RequestType
import com.qualification.app.model.SimpleRequest
import com.qualification.app.utils.DateUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(classes = AppApplication.class)
@Unroll
class SaveToFileServiceTest extends Specification {

    @Autowired
    @Qualifier("saveToFileService")
    IRequestService saveToFileService

    def "should return file with request data"() {

        given:
        def fileName = "request_" + DateUtils.getStringDateNow()
        SimpleRequest simpleRequest = SimpleRequest.builder(fileName, RequestType.THIRD).build()

        when:
        saveToFileService.process(simpleRequest)
        String inputText = new File("src/test/resources/file/" + fileName + ".txt").text

        then:
        inputText == fileName
    }

}
