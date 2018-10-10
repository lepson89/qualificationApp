package com.qualification.app.service

import com.qualification.app.app.AppApplication
import com.qualification.app.enums.RequestType
import com.qualification.app.model.SimpleRequest
import com.qualification.app.repository.SimpleRequestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll


@SpringBootTest(classes = AppApplication.class)
@Unroll
class SaveToDBServiceTest extends Specification {

    @Autowired
    @Qualifier("saveToDBService")
    IRequestService saveToDBService

    @Autowired
    SimpleRequestRepository simpleRequestRepository

    def "should return proper number of records from database"() {

        given:
        SimpleRequest simpleRequest = SimpleRequest.builder("DATA1", RequestType.FIRST).build()
        SimpleRequest simpleRequest2 = SimpleRequest.builder("DATA2", RequestType.FIRST).build()

        when:
        saveToDBService.process(simpleRequest)
        saveToDBService.process(simpleRequest2)

        then:
        simpleRequestRepository.findAll().size() == 2

    }
}
