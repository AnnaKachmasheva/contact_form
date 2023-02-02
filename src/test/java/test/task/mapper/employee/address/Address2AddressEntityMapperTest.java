package test.task.mapper.employee.address;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.Address;
import test.task.entity.AddressEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Address2AddressEntityMapperTest {

    private Address2AddressEntityMapper address2AddressEntityMapper = new Address2AddressEntityMapper();

    @Test
    void toAddressEntity_Address_AddressEntity() {
        Address address = Generator.generateValidAddress();
        AddressEntity addressEntity = address2AddressEntityMapper.toAddressEntity(address);

        Assertions.assertEquals(address.getState(), addressEntity.getState());
        Assertions.assertEquals(address.getCity(), addressEntity.getCity());
        Assertions.assertEquals(address.getPostal(), addressEntity.getPostal());
        Assertions.assertEquals(address.getStreet(), addressEntity.getStreet());
    }

    @Test
    void toAddressEntity_AddressIsNull_AddressEntityIsNull() {
        Address address = null;
        AddressEntity addressEntity = address2AddressEntityMapper.toAddressEntity(address);

        Assertions.assertEquals(address, addressEntity);
    }

    @Test
    void toAddressSet_AddressSet_AddressEntitySet() {
        int countAddresses = 10;
        Set<Address> addresses = new HashSet<>();
        while (countAddresses > 0) {
            addresses.add(Generator.generateValidAddress());
            countAddresses--;
        }

        Set<AddressEntity> addressEntitySet = address2AddressEntityMapper.toAddressEntitySet(addresses);

        List<Address> addressList = addresses.stream().toList();
        List<AddressEntity> addressEntitiesList = addressEntitySet.stream().toList();

        for (int i = 0; i < countAddresses; i++) {
            Assertions.assertEquals(addressList.get(i).getState(), addressEntitiesList.get(i).getState());
            Assertions.assertEquals(addressList.get(i).getCity(), addressEntitiesList.get(i).getCity());
            Assertions.assertEquals(addressList.get(i).getPostal(), addressEntitiesList.get(i).getPostal());
            Assertions.assertEquals(addressList.get(i).getStreet(), addressEntitiesList.get(i).getStreet());

        }
    }
}