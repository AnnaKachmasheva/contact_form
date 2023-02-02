package test.task.model.validator;

import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.exeption.BadRequestException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class AddressModelValidatorTest {

    private final AddressModelValidator addressModelValidator = new AddressModelValidator();

    @Test
    void validateAddressIsNull_Null_BadRequestException() {
        assertThatThrownBy(() -> addressModelValidator.validateAddressIsNull(null))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validateState_EmptyStr_BadRequestException() {
        assertThatThrownBy(() -> addressModelValidator.validateState(""))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validateState_StateNotAlpha_BadRequestException() {
        assertThatThrownBy(() -> addressModelValidator.validateState(Generator.randomString() + Generator.randomInt()))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validateCity_EmptyStr_BadRequestException() {
        assertThatThrownBy(() -> addressModelValidator.validateCity(""))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validateCity_CityNotAlpha_BadRequestException() {
        assertThatThrownBy(() -> addressModelValidator.validateCity(Generator.randomString() + Generator.randomInt()))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validateStreet_EmptyStr_BadRequestException() {
        assertThatThrownBy(() -> addressModelValidator.validateStreet(""))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validateStreet_StreetNotAlphanumeric_BadRequestException() {
        assertThatThrownBy(() -> addressModelValidator.validateStreet(Generator.randomString() + Generator.randomInt() + "_"))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validatePostal_EmptyStr_BadRequestException() {
        assertThatThrownBy(() -> addressModelValidator.validatePostal(""))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validatePostal_PostalNotAlphanumeric_BadRequestException() {
        assertThatThrownBy(() -> addressModelValidator.validatePostal(Generator.randomString() + Generator.randomInt() + "_"))
                .isInstanceOf(BadRequestException.class);
    }
}