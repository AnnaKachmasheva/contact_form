package test.task.mapper.employee.address;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.Address;
import test.task.model.AddressModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Address2AddressModelMapperTest {

    private Address2AddressEntityMapper address2AddressEntityMapper = new Address2AddressEntityMapper();
    private Address2AddressModelMapper address2AddressModelMapper = new Address2AddressModelMapper(address2AddressEntityMapper);

    @Test
    void toAddressModel_Address_AddressModel() {
        Address address = Generator.generateValidAddress();
        AddressModel addressModel = address2AddressModelMapper.toAddressModel(address);

        Assertions.assertEquals(address.getState(), addressModel.getState());
        Assertions.assertEquals(address.getCity(), addressModel.getCity());
        Assertions.assertEquals(address.getPostal(), addressModel.getPostal());
        Assertions.assertEquals(address.getStreet(), addressModel.getStreet());
    }

    @Test
    void toAddressModel_AddressIsNull_AddressModelIsNull() {
        Address address = null;
        AddressModel addressModel = address2AddressModelMapper.toAddressModel(address);

        Assertions.assertEquals(address, addressModel);
    }

    @Test
    void toAddressModelSet_AddressSet_AddressModelSet() {
        int countAddresses = 10;
        Set<Address> addresses = new HashSet<>();
        while (countAddresses > 0) {
            addresses.add(Generator.generateValidAddress());
            countAddresses--;
        }

        Set<AddressModel> addressModelSet = address2AddressModelMapper.toAddressModelSet(addresses);

        List<Address> addressList = addresses.stream().toList();
        List<AddressModel> addressModelList = addressModelSet.stream().toList();

        for (int i = 0; i < countAddresses; i++) {
            Assertions.assertEquals(addressList.get(i).getState(), addressModelList.get(i).getState());
            Assertions.assertEquals(addressList.get(i).getCity(), addressModelList.get(i).getCity());
            Assertions.assertEquals(addressList.get(i).getPostal(), addressModelList.get(i).getPostal());
            Assertions.assertEquals(addressList.get(i).getStreet(), addressModelList.get(i).getStreet());

        }
    }
}