package test.task.rest.DTO.validator;

import org.springframework.stereotype.Component;
import test.task.exeption.BadRequestException;
import test.task.rest.DTO.RequestDTO;
import test.task.rest.util.Constant;

@Component
public class RequestDTOValidator {

    public void validate(RequestDTO requestDTO){

        if (requestDTO == null) {
            throw new BadRequestException("RequestModel is NULL.");
        }

        var policyNumber = requestDTO.getPolicyNumber();
        if ((policyNumber == null) || !policyNumber.matches(Constant.PATTERN_ALPHANUMERIC)){
            throw new BadRequestException("Policy number must be alphanumeric.");
        }

        var name = requestDTO.getName();
        if ((name== null)|| !name.matches(Constant.PATTERN_ALPHA)){
            throw new BadRequestException("Name must be alpha.");
        }

        var surname = requestDTO.getSurname();
        if ((surname == null) || !surname.matches(Constant.PATTERN_ALPHA)){
            throw new BadRequestException("Surname must be alpha.");
        }

        var description = requestDTO.getDescription();
        if (description.length() > Constant.MAX_LENGTH){
            throw new BadRequestException("Request must be less 5000.");
        }
    }
}
