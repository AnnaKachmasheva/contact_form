package test.task.mapper.employee.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Address;
import test.task.rest.DTO.AddressDTO;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AddressDTO2AddressMapper {

    public Address toAddress(AddressDTO addressDTO) {
        if (addressDTO == null)
            return null;

        Address address = new Address();
        address.setState(addressDTO.getState());
        address.setCity(addressDTO.getCity());
        address.setPostal(addressDTO.getPostal());
        address.setStreet(addressDTO.getStreet());
        return address;
    }

    public Set<Address> toAddressSet(Set<AddressDTO> addressDTOs) {
        Set<Address> addresses = new HashSet<>(addressDTOs.size());
        for (AddressDTO addressDTO : addressDTOs) {
            addresses.add(toAddress(addressDTO));
        }
        return addresses;
    }
}
