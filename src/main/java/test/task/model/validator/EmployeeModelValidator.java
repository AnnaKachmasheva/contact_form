package test.task.model.validator;

import org.springframework.stereotype.Component;
import test.task.exeption.BadRequestException;
import test.task.model.EmployeeModel;
import test.task.model.utils.Constant;

import java.time.LocalDate;

@Component
public class EmployeeModelValidator {

    public void validate(EmployeeModel employeeModel) {
        validateName(employeeModel.getName());
        validateSurname(employeeModel.getSurname());
        validateDateOfBirth(employeeModel.getDateOfBirt());
        validateGender(employeeModel.getGender());
        validatePosition(employeeModel.getPosition());
        validateEmaail(employeeModel.getEmail());
        validatePhone(employeeModel.getPhone());
        validatePassword(employeeModel.getPassword());
    }

    public void validateName(String name) {
        if (name.length() == Constant.MIN_LENGTH) {
            throw new BadRequestException("The length of the name must be greater than 0.");
        } else if (!name.matches(Constant.PATTERN_ALPHA)) {
            throw new BadRequestException("Name must be alpha.");
        }
    }

    public void validateSurname(String surname) {
        if (surname.length() == Constant.MIN_LENGTH) {
            throw new BadRequestException("The length of the surname must be greater than 0.");
        } else if (!surname.matches(Constant.PATTERN_ALPHA)) {
            throw new BadRequestException("Surname must be alpha.");
        }
    }

    public void validateDateOfBirth(String dateOfBirtStr) {
        LocalDate dateOfBirt = LocalDate.parse(dateOfBirtStr);
        LocalDate currentDate = LocalDate.now();
        if (currentDate.isBefore(dateOfBirt)) {
            throw new BadRequestException("The date of birth cannot be earlier than today's day.");
        }
    }

    public void validateGender(String gender) {
        if (gender.length() == Constant.MIN_LENGTH) {
            throw new BadRequestException("The length of the gender must be greater than 0.");
        }
    }

    public void validatePosition(String position) {
        if (position.length() == Constant.MIN_LENGTH) {
            throw new BadRequestException("The length of the position must be greater than 0.");
        }
    }

    public void validateEmaail(String email) {
        if (!email.matches(Constant.PATTERN_EMAIL)) {
            throw new BadRequestException("Email number must be like email@gmail.com.");
        }
    }

    public void validatePhone(String phone) {
        if (!phone.matches(Constant.PATTERN_PHONE)) {
            throw new BadRequestException("The phone number must have 9 digits.");
        }
    }

    public void validatePassword(String password) {
        if (password.length() <= Constant.MIN_LENGTH_PASSWORD) {
            throw new BadRequestException("The length of the password must be greater than 5.");
        }
    }
}