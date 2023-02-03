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

class AddressDTO2AddressMapperTest {

    private final AddressDTO2AddressMapper addressDTO2AddressMapper = new AddressDTO2AddressMapper();


    @Test
    void toAddress_AddressModel_Address() {
        AddressDTO addressModel = Generator.generateValidAddressDTO();
        Address address = addressDTO2AddressMapper.toAddress(addressModel);

        Assertions.assertEquals(addressModel.getState(), address.getState());
        Assertions.assertEquals(addressModel.getCity(), address.getCity());
        Assertions.assertEquals(addressModel.getPostal(), address.getPostal());
        Assertions.assertEquals(addressModel.getStreet(), address.getStreet());
    }

    @Test
    void toAddress_AddressModelIsNull_AddressIsNull() {
        Address address = addressDTO2AddressMapper.toAddress(null);
        Assertions.assertNull(address);
    }

    @Test
    void toAddressSet_AddressModelSet_AddressSet() {
        int countAddresses = 10;
        Set<AddressDTO> addressModelSet = new HashSet<>();
        while (countAddresses > 0) {
            addressModelSet.add(Generator.generateValidAddressDTO());
            countAddresses--;
        }

        Set<Address> addressSet = addressDTO2AddressMapper.toAddressSet(addressModelSet);

        List<AddressDTO> addressModelList = addressModelSet.stream().toList();
        List<Address> addressList = addressSet.stream().toList();

        IntStream.range(0, countAddresses).forEach(i -> {
            Assertions.assertEquals(addressModelList.get(i).getState(), addressList.get(i).getState());
            Assertions.assertEquals(addressModelList.get(i).getCity(), addressList.get(i).getCity());
            Assertions.assertEquals(addressModelList.get(i).getPostal(), addressList.get(i).getPostal());
            Assertions.assertEquals(addressModelList.get(i).getStreet(), addressList.get(i).getStreet());
        });
    }
}