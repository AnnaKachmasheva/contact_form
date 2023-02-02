package test.task.model.validator;

import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.exeption.BadRequestException;
import test.task.model.RequestModel;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

class RequestModelValidationTest {

    private final RequestModelValidator requestModelValidation = new RequestModelValidator();


    @Test
    void validation_RequestModelIsNull_BadRequestException() {
        RequestModel requestModel = null;
        assertThatThrownBy(() -> requestModelValidation.validate(requestModel))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validation_RequestModelWithNotValidName_BadRequestException() {
        RequestModel requestModel = Generator.generateRequestModelWithNotValidName();
        assertThatThrownBy(() -> requestModelValidation.validate(requestModel))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validation_RequestModelWithNotValidSurname_BadRequestException() {
        RequestModel requestModel = Generator.generateRequestModelWithNotValidSurname();
        assertThatThrownBy(() -> requestModelValidation.validate(requestModel))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validation_RequestModelWithNotValidPolicyNumber_BadRequestException() {
        RequestModel requestModel = Generator.generateRequestModelWithNotValidPolicyNumber();
        assertThatThrownBy(() -> requestModelValidation.validate(requestModel))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validation_RequestModelWithNotValidDescription_BadRequestException() {
        RequestModel requestModel = Generator.generateRequestModelWithNotDescription();
        assertThatThrownBy(() -> requestModelValidation.validate(requestModel))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validation_RequestModelIsValid() {
        RequestModel requestModel = Generator.generateValidRequestModel();
        RequestModelValidator requestModelValidation = mock(RequestModelValidator.class);

        doNothing().when(requestModelValidation).validate(isA(RequestModel.class));
        requestModelValidation.validate(requestModel);

        verify(requestModelValidation, times(1)).validate(requestModel);
    }
}