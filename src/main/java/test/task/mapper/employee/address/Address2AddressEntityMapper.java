package test.task.mapper.employee.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Address;
import test.task.entity.AddressEntity;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Address2AddressEntityMapper {

    public AddressEntity toAddressEntity(Address address) {
        if (address == null)
            return null;

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setState(address.getState());
        addressEntity.setCity(address.getCity());
        addressEntity.setStreet(address.getStreet());
        addressEntity.setPostal(address.getPostal());
        return addressEntity;
    }

    public Set<AddressEntity> toAddressEntitySet(Set<Address> addresses) {
        Set<AddressEntity> addressEntities = new HashSet<>(addresses.size());
        for (Address address : addresses) {
            addressEntities.add(toAddressEntity(address));
        }
        return addressEntities;
    }
}
