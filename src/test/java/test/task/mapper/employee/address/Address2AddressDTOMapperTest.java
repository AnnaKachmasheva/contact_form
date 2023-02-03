package test.task.mapper.employee.address;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.Address;
import test.task.rest.DTO.AddressDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

class Address2AddressDTOMapperTest {

    private final Address2AddressDTOMapper address2AddressDTOMapper = new Address2AddressDTOMapper();

    @Test
    void toAddressModel_Address_AddressModel() {
        Address address = Generator.generateValidAddress();
        AddressDTO addressDTO = address2AddressDTOMapper.toAddressDTO(address);

        Assertions.assertEquals(address.getState(), addressDTO.getState());
        Assertions.assertEquals(address.getCity(), addressDTO.getCity());
        Assertions.assertEquals(address.getPostal(), addressDTO.getPostal());
        Assertions.assertEquals(address.getStreet(), addressDTO.getStreet());
    }

    @Test
    void toAddressModel_AddressIsNull_AddressModelIsNull() {
        AddressDTO addressDTO = address2AddressDTOMapper.toAddressDTO(null);

        Assertions.assertNull(addressDTO);
    }

    @Test
    void toAddressModelSet_AddressSet_AddressModelSet() {
        int countAddresses = 10;
        Set<Address> addresses = new HashSet<>();
        while (countAddresses > 0) {
            addresses.add(Generator.generateValidAddress());
            countAddresses--;
        }

        Set<AddressDTO> addressDTOS = address2AddressDTOMapper.toAddressDTOSet(addresses);

        List<Address> addressList = addresses.stream().toList();
        List<AddressDTO> addressDTOList = addressDTOS.stream().toList();

        IntStream.range(0, countAddresses).forEach(i -> {
            Assertions.assertEquals(addressList.get(i).getState(), addressDTOList.get(i).getState());
            Assertions.assertEquals(addressList.get(i).getCity(), addressDTOList.get(i).getCity());
            Assertions.assertEquals(addressList.get(i).getPostal(), addressDTOList.get(i).getPostal());
            Assertions.assertEquals(addressList.get(i).getStreet(), addressDTOList.get(i).getStreet());
        });
    }
}