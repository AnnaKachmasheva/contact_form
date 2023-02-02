package test.task.model.validator;

import org.springframework.stereotype.Component;
import test.task.exeption.BadRequestException;
import test.task.model.EmployeeModel;
import test.task.model.utils.Constant;

import java.time.LocalDate;

@Component
public class EmployeeModelValidator {

    public void validate(EmployeeModel employeeModel) {
        var name = employeeModel.getName();
        if (name.length() == Constant.MIN_LENGTH) {
            throw new BadRequestException("The length of the name must be greater than 0.");
        } else if (!name.matches(Constant.PATTERN_ALPHA)) {
            throw new BadRequestException("Name must be alpha.");
        }

        var surname = employeeModel.getSurname();
        if (surname.length() == Constant.MIN_LENGTH) {
            throw new BadRequestException("The length of the surname must be greater than 0.");
        } else if (!surname.matches(Constant.PATTERN_ALPHA)) {
            throw new BadRequestException("Surname must be alpha.");
        }

        var dateOfBirtStr = employeeModel.getDateOfBirt();
        LocalDate dateOfBirt = LocalDate.parse(dateOfBirtStr);
        LocalDate currentDate = LocalDate.now();
        if (currentDate.isBefore(dateOfBirt)) {
            throw new BadRequestException("The date of birth cannot be earlier than today's day.");
        }

        var gender = employeeModel.getGender();
        if (gender.length() == Constant.MIN_LENGTH) {
            throw new BadRequestException("The length of the gender must be greater than 0.");
        }

        var position = employeeModel.getPosition();
        if (position.length() == Constant.MIN_LENGTH) {
            throw new BadRequestException("The length of the position must be greater than 0.");
        }

        var email = employeeModel.getEmail();
        if (!email.matches(Constant.PATTERN_EMAIL)) {
            throw new BadRequestException("Email number must be like email@gmail.com.");
        }

        var phone = employeeModel.getPhone();
        if (!phone.matches(Constant.PATTERN_PHONE)) {
            throw new BadRequestException("The phone number must have 9 digits.");
        }

        var password = employeeModel.getPassword();
        if (password.length() <= Constant.MIN_LENGTH_PASSWORD) {
            throw new BadRequestException("The length of the password must be greater than 5.");
        }
    }
}
