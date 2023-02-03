package test.task.rest.validator;

import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.exeption.BadRequestException;
import test.task.rest.DTO.validator.EmployeeDTOValidator;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class EmployeeDTOValidatorTest {

    private final EmployeeDTOValidator employeeModelValidator = new EmployeeDTOValidator();

    @Test
    void validateName_NameIsNull_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validateName(null))
                .isInstanceOf(BadRequestException.class);
    }

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
    void validateSurname_SurnameIsNull_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validateSurname(null))
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
        String date = LocalDate.now().plusDays(1).toString();
        assertThatThrownBy(() -> employeeModelValidator.validateDateOfBirth(date))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validateDateOfBirth_DateIsNull_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validateDateOfBirth(null))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validateGender_GenderIsNull_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validateGender(null))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validateGender_GenderIsNotVAlis_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validateGender("malefemale"))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validatePosition_PositionIsEmptyStr_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validatePosition(""))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validatePosition_PositionIsNull_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validatePosition(null))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validateEmail_EmailIsNull_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validateEmail(null))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validateEmail_EmailNotValid_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validateEmail("_mails@d"))
                .isInstanceOf(BadRequestException.class);
    }


    @Test
    void validatePhone_PhoneIsNull_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validatePhone(null))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validatePhone_PhoneLength8_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validatePhone("12345678"))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validatePhone_PhoneLength10_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validatePhone("1234567890"))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validatePassword_PasswordIsNull_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validatePassword(null))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void validatePassword_PasswordLength4_BadRequestException() {
        assertThatThrownBy(() -> employeeModelValidator.validatePassword("as12"))
                .isInstanceOf(BadRequestException.class);
    }
}