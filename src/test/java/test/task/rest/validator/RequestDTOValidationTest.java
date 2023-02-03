package test.task.rest.validator;

import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.exeption.BadRequestException;
import test.task.rest.DTO.RequestDTO;
import test.task.rest.DTO.validator.RequestDTOValidator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

class RequestDTOValidationTest {

    private final RequestDTOValidator requestModelValidation = new RequestDTOValidator();


    @Test
    void validation_RequestModelIsNull_BadRequestException() {
        RequestDTO requestModel = null;
        assertThatThrownBy(() -> requestModelValidation.validate(requestModel))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validation_RequestModelWithNotValidName_BadRequestException() {
        RequestDTO requestModel = Generator.generateRequestModelWithNotValidName();
        assertThatThrownBy(() -> requestModelValidation.validate(requestModel))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validation_RequestModelWithNotValidSurname_BadRequestException() {
        RequestDTO requestModel = Generator.generateRequestDTOWithNotValidSurname();
        assertThatThrownBy(() -> requestModelValidation.validate(requestModel))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validation_RequestModelWithNotValidPolicyNumber_BadRequestException() {
        RequestDTO requestModel = Generator.generateRequestDTOWithNotValidPolicyNumber();
        assertThatThrownBy(() -> requestModelValidation.validate(requestModel))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validation_RequestModelWithNotValidDescription_BadRequestException() {
        RequestDTO requestModel = Generator.generateRequestDTOWithNotDescription();
        assertThatThrownBy(() -> requestModelValidation.validate(requestModel))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validation_RequestModelIsValid() {
        RequestDTO requestModel = Generator.generateValidRequestModel();
        RequestDTOValidator requestModelValidation = mock(RequestDTOValidator.class);

        doNothing().when(requestModelValidation).validate(isA(RequestDTO.class));
        requestModelValidation.validate(requestModel);

        verify(requestModelValidation, times(1)).validate(requestModel);
    }
}