package com.qualification.app.service

import com.qualification.app.app.AppApplication
import com.qualification.app.enums.RequestType
import com.qualification.app.model.SimpleRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(classes = AppApplication.class)
@Unroll
class ConsoleOutServiceTest extends Specification {

    @Autowired
    @Qualifier("consoleOutService")
    IRequestService consoleOutService

    def "should return simple request info on console"() {
        given:
        SimpleRequest simpleRequest = SimpleRequest.builder("DATA", RequestType.FOURTH).build()
        when:
        def buff = new ByteArrayOutputStream()
        System.out = new PrintStream(buff)
        and:
        consoleOutService.process(simpleRequest)
        then:
        buff.toString() == simpleRequest.toString()
    }
}
