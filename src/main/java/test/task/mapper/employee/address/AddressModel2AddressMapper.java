package test.task.mapper.employee.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Address;
import test.task.model.AddressModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AddressModel2AddressMapper {

    public Address toAddress(AddressModel addressModel) {
        if (addressModel == null)
            return null;

        Address address = new Address();
        address.setState(addressModel.getState());
        address.setCity(addressModel.getCity());
        address.setPostal(addressModel.getPostal());
        address.setStreet(addressModel.getStreet());
        return address;
    }

    public Set<Address> toAddressSet(Set<AddressModel> addressModels) {
        Set<Address> addresses = new HashSet<>(addressModels.size());
        for (AddressModel addressModel : addressModels) {
            addresses.add(toAddress(addressModel));
        }
        return addresses;
    }
}
