package test;

import test.task.domain.Address;
import test.task.domain.Request;
import test.task.entity.AddressEntity;
import test.task.entity.KindOfRequestEntity;
import test.task.entity.RequestEntity;
import test.task.model.AddressModel;
import test.task.model.EmployeeModel;
import test.task.model.RequestModel;

import java.util.Random;

public class Generator {

    private static final Random RAND = new Random();

    private static final String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public static int randomInt() {
        return Math.abs(RAND.nextInt());
    }

    public static String randomString() {
        int length = randomInt();
        if (length <= 0)
            length = 1;
        else if (length >= 100)
            length = 100;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int) (alpha.length() * Math.random());
            sb.append(getAlphaChar(index));
        }
        return sb.toString();
    }

    public static char getAlphaChar(int index) {
        return alpha.charAt(index);
    }


    public static boolean randomBoolean() {
        return RAND.nextBoolean();
    }

    public static EmployeeModel generateEmptyEmployeeModel() {
        return new EmployeeModel();
    }

    public static EmployeeModel generateEmployeeModel() {
        EmployeeModel employeeModel = new EmployeeModel();
        //todo
        return employeeModel;
    }

    public static RequestModel generateEmptyRequestModel() {
        return new RequestModel();
    }

    public static RequestModel generateValidRequestModel() {
        RequestModel requestModel = new RequestModel();
        requestModel.setPolicyNumber("policyNumber" + randomString());
        requestModel.setName("name" + randomString());
        requestModel.setSurname("surname" + randomString());
        requestModel.setDescription("description" + randomString() + randomInt());
        requestModel.setKindOfRequest("kindOfRequest" + randomString());
        return requestModel;
    }

    public static RequestEntity generateValidRequestEntity() {
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setId((long) randomInt());
        requestEntity.setPolicyNumber("policyNumber" + randomString());
        requestEntity.setName("name" + randomString());
        requestEntity.setSurname("surname" + randomString());
        requestEntity.setDescription("description" + randomString() + randomInt());
        KindOfRequestEntity kindOfRequestEntity = new KindOfRequestEntity();
        kindOfRequestEntity.setName("kindOfRequest" + randomString());
        requestEntity.setKindOfRequestEntity(kindOfRequestEntity);
        return requestEntity;
    }

    public static Request generateValidRequest() {
        Request request = new Request();
        request.setId((long) randomInt());
        request.setPolicyNumber("policyNumber" + randomString());
        request.setName("name" + randomString());
        request.setSurname("surname" + randomString());
        request.setDescription("description" + randomString() + randomInt());
        request.setKindOfRequest("kindOfRequest" + randomString());
        return request;
    }

    public static RequestModel generateRequestModelWithNotValidPolicyNumber() {
        RequestModel requestModel = generateValidRequestModel();
        requestModel.setPolicyNumber(requestModel.getPolicyNumber() + "-");
        return requestModel;
    }

    public static RequestModel generateRequestModelWithNotValidName() {
        RequestModel requestModel = generateValidRequestModel();
        requestModel.setName(requestModel.getName() + randomInt());
        return requestModel;
    }

    public static RequestModel generateRequestModelWithNotValidSurname() {
        RequestModel requestModel = generateValidRequestModel();
        requestModel.setSurname(requestModel.getSurname() + randomInt());
        return requestModel;
    }

    public static RequestModel generateRequestModelWithNotDescription() {
        RequestModel requestModel = generateValidRequestModel();
        int length = 5001;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int) (alpha.length() * Math.random());
            sb.append(getAlphaChar(index));
        }
        requestModel.setDescription(sb.toString());
        return requestModel;
    }

    public static Address generateValidAddress() {
        Address address = new Address();
        address.setState("state" + randomString());
        address.setCity("city" + randomString());
        address.setPostal("postal" + randomString() + randomInt());
        address.setStreet("street" + randomString() + randomInt());
        return address;
    }

    public static AddressEntity generateValidAddressEntity() {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setState("state" + randomString());
        addressEntity.setCity("city" + randomString());
        addressEntity.setPostal("postal" + randomString() + randomInt());
        addressEntity.setStreet("street" + randomString() + randomInt());
        return addressEntity;
    }

    public static AddressModel generateValidAddressModel() {
        AddressModel addressModel = new AddressModel();
        addressModel.setState("state" + randomString());
        addressModel.setCity("city" + randomString());
        addressModel.setPostal("postal" + randomString() + randomInt());
        addressModel.setStreet("street" + randomString() + randomInt());
        return addressModel;
    }
}