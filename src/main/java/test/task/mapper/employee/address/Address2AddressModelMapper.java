package test.task.mapper.employee.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Address;
import test.task.model.AddressModel;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Address2AddressModelMapper {

    private final Address2AddressEntityMapper address2AddressEntityMapper;

    public AddressModel toAddressModel(Address address) {
        if (address == null)
            return null;

        AddressModel addressModel = new AddressModel();
        addressModel.setState(address.getState());
        addressModel.setCity(address.getCity());
        addressModel.setStreet(address.getStreet());
        addressModel.setPostal(address.getPostal());
        return addressModel;
    }

    public Set<AddressModel> toAddressModelSet(Set<Address> addresses) {
        Set<AddressModel> addressModels = new HashSet<>(addresses.size());
        for (Address address : addresses) {
            addressModels.add(toAddressModel(address));
        }
        return addressModels;
    }

}
