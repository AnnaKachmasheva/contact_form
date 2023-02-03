package test.task.mapper.employee.address;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.Address;
import test.task.entity.AddressEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

class AddressEntityMapperTest {

    private final AddressEntityMapper addressEntityMapper = new AddressEntityMapper();

    @Test
    void toAddress_AddressEntity_Address() {
        AddressEntity addressEntity = Generator.generateValidAddressEntity();
        Address address = addressEntityMapper.toAddress(addressEntity);

        Assertions.assertEquals(addressEntity.getState(), address.getState());
        Assertions.assertEquals(addressEntity.getCity(), address.getCity());
        Assertions.assertEquals(addressEntity.getPostal(), address.getPostal());
        Assertions.assertEquals(addressEntity.getStreet(), address.getStreet());
    }

    @Test
    void toAddress_AddressEntityIsNull_AddressIsNull() {
        Address address = addressEntityMapper.toAddress(null);
        Assertions.assertNull(address);
    }

    @Test
    void toAddressSet_AddressEntitySet_AddressSet() {
        int countAddresses = 10;
        Set<AddressEntity> addressEntitySet = new HashSet<>();
        while (countAddresses > 0) {
            addressEntitySet.add(Generator.generateValidAddressEntity());
            countAddresses--;
        }

        Set<Address> addressSet = addressEntityMapper.toAddressSet(addressEntitySet);

        List<AddressEntity> addressEntityList = addressEntitySet.stream().toList();
        List<Address> addressList = addressSet.stream().toList();

        IntStream.range(0, countAddresses).forEach(i -> {
            Assertions.assertEquals(addressEntityList.get(i).getState(), addressList.get(i).getState());
            Assertions.assertEquals(addressEntityList.get(i).getCity(), addressList.get(i).getCity());
            Assertions.assertEquals(addressEntityList.get(i).getPostal(), addressList.get(i).getPostal());
            Assertions.assertEquals(addressEntityList.get(i).getStreet(), addressList.get(i).getStreet());
        });
    }
}