package test.task.mapper.employee.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Address;
import test.task.entity.AddressEntity;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AddressEntityMapper {

    public Address toAddress(AddressEntity addressEntity) {
        if (addressEntity == null)
            return null;
        Address address = new Address();
        address.setState(addressEntity.getState());
        address.setCity(addressEntity.getCity());
        address.setStreet(addressEntity.getStreet());
        address.setPostal(addressEntity.getPostal());
        return address;
    }

    public Set<Address> toAddressSet(Set<AddressEntity> addressEntities) {
        Set<Address> addresses = new HashSet<>(addressEntities.size());
        for (AddressEntity addressEntity : addressEntities) {
            addresses.add(toAddress(addressEntity));
        }
        return addresses;
    }
}
