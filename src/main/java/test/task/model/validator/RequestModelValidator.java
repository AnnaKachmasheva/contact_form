package test.task.model.validator;

import org.springframework.stereotype.Component;
import test.task.exeption.BadRequestException;
import test.task.model.RequestModel;
import test.task.model.utils.Constant;

@Component
public class RequestModelValidator {

    public void validate(RequestModel requestModel){

        if (requestModel == null) {
            throw new BadRequestException("RequestModel is NULL.");
        }

        var policyNumber = requestModel.getPolicyNumber();
        if ((policyNumber == null) || !policyNumber.matches(Constant.PATTERN_ALPHANUMERIC)){
            throw new BadRequestException("Policy number must be alphanumeric.");
        }

        var name = requestModel.getName();
        if ((name== null)|| !name.matches(Constant.PATTERN_ALPHA)){
            throw new BadRequestException("Name must be alpha.");
        }

        var surname = requestModel.getSurname();
        if ((surname == null) || !surname.matches(Constant.PATTERN_ALPHA)){
            throw new BadRequestException("Surname must be alpha.");
        }

        var description = requestModel.getDescription();
        if (description.length() > Constant.MAX_LENGTH){
            throw new BadRequestException("Request must be less 5000.");
        }
    }
}
