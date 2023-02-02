package test.task.mapper.employee.address;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.Address;
import test.task.model.AddressModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class AddressModel2AddressMapperTest {

    private AddressModel2AddressMapper addressModel2AddressMapper = new AddressModel2AddressMapper();


    @Test
    void toAddress_AddressModel_Address() {
        AddressModel addressModel = Generator.generateValidAddressModel();
        Address address = addressModel2AddressMapper.toAddress(addressModel);

        Assertions.assertEquals(addressModel.getState(), address.getState());
        Assertions.assertEquals(addressModel.getCity(), address.getCity());
        Assertions.assertEquals(addressModel.getPostal(), address.getPostal());
        Assertions.assertEquals(addressModel.getStreet(), address.getStreet());
    }

    @Test
    void toAddress_AddressModelIsNull_AddressIsNull() {
        AddressModel addressModel = null;
        Address address = addressModel2AddressMapper.toAddress(addressModel);

        Assertions.assertEquals(addressModel, address);
    }

    @Test
    void toAddressSet_AddressModelSet_AddressSet() {
        int countAddresses = 10;
        Set<AddressModel> addressModelSet = new HashSet<>();
        while (countAddresses > 0) {
            addressModelSet.add(Generator.generateValidAddressModel());
            countAddresses--;
        }

        Set<Address> addressSet = addressModel2AddressMapper.toAddressSet(addressModelSet);

        List<AddressModel> addressModelList = addressModelSet.stream().toList();
        List<Address> addressList = addressSet.stream().toList();

        for (int i = 0; i < countAddresses; i++) {
            Assertions.assertEquals(addressModelList.get(i).getState(), addressList.get(i).getState());
            Assertions.assertEquals(addressModelList.get(i).getCity(), addressList.get(i).getCity());
            Assertions.assertEquals(addressModelList.get(i).getPostal(), addressList.get(i).getPostal());
            Assertions.assertEquals(addressModelList.get(i).getStreet(), addressList.get(i).getStreet());

        }
    }
}