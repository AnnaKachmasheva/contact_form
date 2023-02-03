package test.task.rest.DTO.validator;

import org.springframework.stereotype.Component;
import test.task.entity.enums.Gender;
import test.task.exeption.BadRequestException;
import test.task.rest.DTO.EmployeeDTO;
import test.task.rest.util.Constant;

import java.time.LocalDate;

@Component
public class EmployeeDTOValidator {

    public void validate(EmployeeDTO employeeDTO) {
        validateName(employeeDTO.getName());
        validateSurname(employeeDTO.getSurname());
        validateDateOfBirth(employeeDTO.getDateOfBirt());
        validateGender(employeeDTO.getGender());
        validatePosition(employeeDTO.getPosition());
        validateEmail(employeeDTO.getEmail());
        validatePhone(employeeDTO.getPhone());
        validatePassword(employeeDTO.getPassword());
    }

    public void validateName(String name) {
        if (name == null) {
            throw new BadRequestException("Name is NULL.");
        } else if (name.length() == Constant.MIN_LENGTH) {
            throw new BadRequestException("The length of the name must be greater than 0.");
        } else if (!name.matches(Constant.PATTERN_ALPHA)) {
            throw new BadRequestException("Name must be alpha.");
        }
    }

    public void validateSurname(String surname) {
        if (surname == null) {
            throw new BadRequestException("Surname is NULL.");
        } else if (surname.length() == Constant.MIN_LENGTH) {
            throw new BadRequestException("The length of the surname must be greater than 0.");
        } else if (!surname.matches(Constant.PATTERN_ALPHA)) {
            throw new BadRequestException("Surname must be alpha.");
        }
    }

    public void validateDateOfBirth(String dateOfBirtStr) {
        try {
            LocalDate dateOfBirt = LocalDate.parse(dateOfBirtStr);
            LocalDate currentDate = LocalDate.now();
            if (currentDate.isBefore(dateOfBirt)) {
                throw new BadRequestException("The date of birth cannot be earlier than today's day.");
            }
        } catch (Exception e) {
            throw new BadRequestException("The date not in format 2000-12-31.");
        }
    }

    public void validateGender(String gender) {
        try {
            Gender gend = Gender.valueOf(gender);
        } catch (Exception e) {
            throw new BadRequestException("Gender has an invalid MALE, FEMALE etc. format.");
        }
    }

    public void validatePosition(String position) {
        if ((position == null) || position.length() == Constant.MIN_LENGTH) {
            throw new BadRequestException("The length of the position must be greater than 0.");
        }
    }

    public void validateEmail(String email) {
        if ((email == null) || !email.matches(Constant.PATTERN_EMAIL)) {
            throw new BadRequestException("Email number must be like email@gmail.com.");
        }
    }

    public void validatePhone(String phone) {
        if ((phone == null) || !phone.matches(Constant.PATTERN_PHONE)) {
            throw new BadRequestException("The phone number must have 9 digits.");
        }
    }

    public void validatePassword(String password) {
        if ((password == null) || (password.length() <= Constant.MIN_LENGTH_PASSWORD)) {
            throw new BadRequestException("The length of the password must be greater than 5.");
        }
    }
}