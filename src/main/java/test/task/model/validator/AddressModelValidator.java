package test.task.model.validator;

import org.springframework.stereotype.Component;
import test.task.exeption.BadRequestException;
import test.task.model.AddressModel;
import test.task.model.utils.Constant;

import java.util.Set;

@Component
public class AddressModelValidator {


    public void validate(Set<AddressModel> addressModels) {
        for (AddressModel addressModel : addressModels) {
            var state = addressModel.getState();
            if (state.length() == Constant.MIN_LENGTH) {
                throw new BadRequestException("The length of the state must be greater than 0.");
            } else if (!state.matches(Constant.PATTERN_ALPHA)) {
                throw new BadRequestException("State must be alpha.");
            }

            var city = addressModel.getCity();
            if (city.length() == Constant.MIN_LENGTH) {
                throw new BadRequestException("The length of the city must be greater than 0.");
            } else if (!city.matches(Constant.PATTERN_ALPHA)) {
                throw new BadRequestException("City must be alpha.");
            }

            var street = addressModel.getStreet();
            if (street.length() == Constant.MIN_LENGTH) {
                throw new BadRequestException("The length of the street must be greater than 0.");
            } else if (!street.matches(Constant.PATTERN_ALPHANUMERIC)) {
                throw new BadRequestException("Street must be alphanumeric.");
            }

            var postal = addressModel.getPostal();
            if (postal.length() == Constant.MIN_LENGTH) {
                throw new BadRequestException("The length of the postal must be greater than 0.");
            } else if (!postal.matches(Constant.PATTERN_NUMERIC)) {
                throw new BadRequestException("Postal must be alphanumeric.");
            }
        }
    }
}
