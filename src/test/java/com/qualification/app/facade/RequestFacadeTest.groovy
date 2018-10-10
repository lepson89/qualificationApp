package com.qualification.app.facade

import com.qualification.app.app.AppApplication
import com.qualification.app.enums.RequestType
import com.qualification.app.model.SimpleRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(classes = AppApplication.class)
@Unroll
class RequestFacadeTest extends Specification {

    @Autowired
    IRequestFacade requestFacade

    @Shared queue
    @Shared simpleRequest
    @Shared mockSimpleRequest

    def setup(){
        queue = new LinkedList();
        mockSimpleRequest = Mock(SimpleRequest)
        simpleRequest = SimpleRequest()
        queue.add(simpleRequest)
    }


    def "should return proper size of queue after adding element to it"() {
        when:
        requestFacade.addRequestToQueue(queue, mockSimpleRequest)

        then:
        queue.size() == 2

    }

    def "should return proper size of queue after remove element from it"(){
        when:
        requestFacade.removeRequestFromQueue(queue)

        then:
        queue.size() == 0
    }

    private SimpleRequest (){
        return SimpleRequest.builder("DATA", RequestType.THIRD).build()
    }
}
