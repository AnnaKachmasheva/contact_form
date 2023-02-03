package test.task.mapper.employee.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Address;
import test.task.rest.DTO.AddressDTO;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Address2AddressDTOMapper {


    public AddressDTO toAddressDTO(Address address) {
        if (address == null)
            return null;

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setState(address.getState());
        addressDTO.setCity(address.getCity());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setPostal(address.getPostal());
        return addressDTO;
    }

    public Set<AddressDTO> toAddressDTOSet(Set<Address> addresses) {
        Set<AddressDTO> addressDTOs = new HashSet<>(addresses.size());
        for (Address address : addresses) {
            addressDTOs.add(toAddressDTO(address));
        }
        return addressDTOs;
    }

}
