package test.task.model.validator;

import org.junit.jupiter.api.Test;
import test.task.exeption.BadRequestException;
import test.task.model.AddressModel;
import test.task.model.RequestModel;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class AddressModelValidatorTest {

    private AddressModelValidator addressModelValidator = new AddressModelValidator();

    @Test
    void validate_AddressModelIsNull_BadRequestException() {
        AddressModel addressModel = null;
        //todo
//        assertThatThrownBy(() -> addressModelValidator.validate(addressModel))
//                .isInstanceOf(BadRequestException.class);
    }
}