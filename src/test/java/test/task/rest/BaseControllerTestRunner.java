package test.task.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import test.environment.Environment;
import test.environment.RestExceptionHandler;

import static test.environment.Environment.createDefaultMessageConverter;
import static test.environment.Environment.createStringEncodingMessageConverter;

public class BaseControllerTestRunner {

    ObjectMapper objectMapper;

    MockMvc mockMvc;

    public void setUp(Object controller) {
        this.objectMapper = Environment.getObjectMapper();

        this.mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new RestExceptionHandler())
                                      .setMessageConverters(createDefaultMessageConverter(),
                                              createStringEncodingMessageConverter())
                                      .setUseSuffixPatternMatch(false)
                                      .build();
    }

    String toJson(Object object) throws Exception {
        return objectMapper.writeValueAsString(object);
    }
}
