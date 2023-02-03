package test.task.rest.DTO.validator;

import org.springframework.stereotype.Component;
import test.task.exeption.BadRequestException;
import test.task.rest.DTO.AddressDTO;
import test.task.rest.util.Constant;

import java.util.Set;

@Component
public class AddressDTOValidator {


    public void validate(Set<AddressDTO> addressesDTO) {
        for (AddressDTO addressDTO : addressesDTO) {
            validateAddressIsNull(addressDTO);
            validateState(addressDTO.getState());
            validateCity(addressDTO.getCity());
            validateStreet(addressDTO.getStreet());
            validatePostal(addressDTO.getPostal());
        }
    }

    public void validateAddressIsNull(AddressDTO addressModel) {
        if (addressModel == null) {
            throw new BadRequestException("AddressModel is NULL.");
        }
    }

    public void validateState(String state) {
        if (state.length() == Constant.MIN_LENGTH) {
            throw new BadRequestException("The length of the state must be greater than 0.");
        } else if (!state.matches(Constant.PATTERN_ALPHA)) {
            throw new BadRequestException("State must be alpha.");
        }
    }

    public void validateCity(String city) {
        if (city.length() == Constant.MIN_LENGTH) {
            throw new BadRequestException("The length of the city must be greater than 0.");
        } else if (!city.matches(Constant.PATTERN_ALPHA)) {
            throw new BadRequestException("City must be alpha.");
        }
    }

    public void validateStreet(String street) {
        if (street.length() == Constant.MIN_LENGTH) {
            throw new BadRequestException("The length of the street must be greater than 0.");
        } else if (!street.matches(Constant.PATTERN_ALPHANUMERIC)) {
            throw new BadRequestException("Street must be alphanumeric.");
        }
    }

    public void validatePostal(String postal) {
        if (postal.length() == Constant.MIN_LENGTH) {
            throw new BadRequestException("The length of the postal must be greater than 0.");
        } else if (!postal.matches(Constant.PATTERN_NUMERIC)) {
            throw new BadRequestException("Postal must be alphanumeric.");
        }
    }
}
