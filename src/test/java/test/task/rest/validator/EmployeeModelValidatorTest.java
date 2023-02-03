package test.task.rest.validator;

import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.exeption.BadRequestException;
import test.task.rest.DTO.validator.EmployeeDTOValidator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class EmployeeModelValidatorTest {

    private final EmployeeDTOValidator employeeModelValidator = new EmployeeDTOValidator();

    @Test
    void validateName_NameIsEmptyStr_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validateName(""))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validateName_NameNotAlpha_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validateName(Generator.randomString() + Generator.randomInt()))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validateSurname_SurnameIsEmptyStr_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validateSurname(""))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validateSurname_SurnameNotAlpha_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validateSurname(Generator.randomString() + Generator.randomInt()))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validateDateOfBirth_Today_BadRequestException() {
        //todo
//        LocalDate cDate = LocalDate.now();
//        assertThatThrownBy(() -> employeeModelValidator.validateDateOfBirth(cDate.toString()))
//                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validateGender() {
        //todo
    }

    @Test
    void validatePosition() {
        //todo
    }

    @Test
    void validateEmaail() {
        //todo
    }

    @Test
    void validatePhone() {
        //todo
    }

    @Test
    void validatePassword() {
        //todo
    }
}