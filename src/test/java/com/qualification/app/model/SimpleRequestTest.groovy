package com.qualification.app.model

import com.qualification.app.app.AppApplication
import com.qualification.app.enums.RequestType
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(classes = AppApplication.class)
@Unroll
class SimpleRequestTest extends Specification {

    def "Testing simple request builder method"() {

        given:
        SimpleRequest simpleRequestMock = Mock()
        SimpleRequest simpleRequest = simpleRequestMock.builder(data, type).build()

        expect:
        simpleRequest.data == data
        simpleRequest.requestType == type

        where:
        data        |   type
        "Data1"     |   RequestType.FIRST
        "Data2"     |   RequestType.SECOND
        "Data3"     |   RequestType.THIRD
        "Data4"     |   RequestType.FOURTH
    }
}
