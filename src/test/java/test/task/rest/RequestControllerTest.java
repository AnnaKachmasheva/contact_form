package test.task.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import test.task.model.RequestModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@ExtendWith(MockitoExtension.class)
class RequestControllerTest extends BaseControllerTestRunner {

    @InjectMocks
    private RequestController requestController;

    @BeforeEach
    public void setUp() {
        super.setUp(requestController);
    }

    @Test
    void createRequest_emptyBody_statusIsBadRequest() throws Exception {
        final RequestModel requestModel = new RequestModel();

        mockMvc.perform(post("/")
                .content(toJson("{\"description\":\"description\"," +
                        "\"kindOfRequest\":\"Contract Adjustment\"," +
                        "\"name\":\"name\"," +
                        "\"policyNumber\":\"policy+Number1\"" +
                        "\"surname\":\"surname\"" +
                        "}"))
                .contentType(MediaType.APPLICATION_JSON_VALUE));

        final ArgumentCaptor<RequestModel> captor = ArgumentCaptor.forClass(RequestModel.class);
        verify(requestController).createRequest(captor.capture());

        assertEquals(requestModel, captor.getValue());
    }
//
//    @Test
//    void createRequest_notValidPolicyNumber_statusIsBadRequest() throws Exception {
//
//        RequestBuilder request = post("/")
//                .accept(MediaType.APPLICATION_JSON)
//                .content("{\"description\":\"description\"," +
//                        "\"kindOfRequest\":\"Contract Adjustment\"," +
//                        "\"name\":\"name\"," +
//                        "\"policyNumber\":\"policy+Number1\"" +
//                        "\"surname\":\"surname\"" +
//                        "}")
//                .contentType(MediaType.APPLICATION_JSON);
//
//        mockMvc.perform(request).andExpect(status().isBadRequest()).andReturn();
//    }
//
//    @Test
//    void createRequest_notValidName_statusIsBadRequest() throws Exception {
//
//        RequestBuilder request = post("/")
//                .accept(MediaType.APPLICATION_JSON)
//                .content("{\"description\":\"description\"," +
//                        "\"kindOfRequest\":\"Contract Adjustment\"," +
//                        "\"name\":\"123=\"," +
//                        "\"policyNumber\":\"policyNumber1\"" +
//                        "\"surname\":\"surname\"" +
//                        "}")
//                .contentType(MediaType.APPLICATION_JSON);
//
//        mockMvc.perform(request).andExpect(status().isBadRequest()).andReturn();
//    }
//
//    @Test
//    void createRequest_notValidSurname_statusIsBadRequest() throws Exception {
//
//        RequestBuilder request = post("/")
//                .accept(MediaType.APPLICATION_JSON)
//                .content("{\"description\":\"description\"," +
//                        "\"kindOfRequest\":\"Contract Adjustment\"," +
//                        "\"name\":\"Name\"," +
//                        "\"policyNumber\":\"policyNumber1\"" +
//                        "\"surname\":\"123_+\"" +
//                        "}")
//                .contentType(MediaType.APPLICATION_JSON);
//
//        mockMvc.perform(request).andExpect(status().isBadRequest()).andReturn();
//    }
//
//    @Test
//    void createRequest_validData_statusIsOk() throws Exception {
//
//        RequestBuilder request = post("/")
//                .content("{\"description\":\"description\"," +
//                        "\"kindOfRequest\":\"Contract Adjustment\"," +
//                        "\"name\":\"Name\"," +
//                        "\"policyNumber\":\"policyNumber1\"" +
//                        "\"surname\":\"surname\"" +
//                        "}")
//                .contentType(MediaType.APPLICATION_JSON);
//
//        mockMvc.perform(request).andExpect(status().isOk()).andReturn();
//    }
}