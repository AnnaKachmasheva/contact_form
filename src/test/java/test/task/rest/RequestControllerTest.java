package test.task.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import test.Generator;
import test.task.adapter.request.RequestRepositoryAdapter;
import test.task.model.RequestModel;
import test.task.rest.interfaces.RequestController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class RequestControllerTest extends BaseControllerTestRunner {

    @InjectMocks
    private RequestControllerImpl requestController;

    @Mock
    private RequestRepositoryAdapter requestRepositoryAdapter;

    @BeforeEach
    public void setUp() {
        super.setUp(requestRepositoryAdapter);
    }

    @Test
    void createRequest_emptyBody_statusIsBadRequest() throws Exception {
        final RequestModel requestModel = Generator.generateEmptyRequestModel();

        mockMvc.perform(post("/contactus")
                        .content(toJson(requestModel))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());

        final ArgumentCaptor<RequestModel> response = ArgumentCaptor.forClass(RequestModel.class);
        verify(requestController).createRequest(response.capture());
        assertEquals(requestModel.getName(), response.capture().getName());

    }

}