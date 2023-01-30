package test.task.mapper.employee;

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

        return Address.builder()
                .state(addressModel.getState())
                .city(addressModel.getCity())
                .street(addressModel.getStreet())
                .postal(addressModel.getPostal())
                .build();
    }

    public Set<Address> toAddressSet(Set<AddressModel> addressModels) {
        Set<Address> addresses = new HashSet<>(addressModels.size());
        for (AddressModel addressModel : addressModels) {
            addresses.add(toAddress(addressModel));
        }
        return addresses;
    }
}
