package test.task.adapter.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import test.Generator;
import test.task.domain.Request;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class RequestRepositoryAdapterTest {

    @Autowired
    RequestRepositoryAdapter requestRepositoryAdapter;

    @Autowired
    RequestJpaRepositoryAdapter requestJpaRepositoryAdapter;

    private Request request;

    @BeforeEach
    public void init() {
        request = Generator.generateValidRequest();
    }

    @Test
    void createRequest_Request_success() {
        Request savedRequest = requestJpaRepositoryAdapter.createRequest(request);

        Assertions.assertEquals(request.getName(), savedRequest.getName());
        Assertions.assertEquals(request.getSurname(), savedRequest.getSurname());
        Assertions.assertEquals(request.getDescription(), savedRequest.getDescription());
        Assertions.assertEquals(request.getPolicyNumber(), savedRequest.getPolicyNumber());
        Assertions.assertEquals(request.getKindOfRequest(), savedRequest.getKindOfRequest());
    }
}