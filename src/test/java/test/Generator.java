package test;

import org.h2.engine.User;
import test.task.domain.Address;
import test.task.domain.Employee;
import test.task.domain.Request;
import test.task.entity.AddressEntity;
import test.task.entity.EmployeeEntity;
import test.task.entity.KindOfRequestEntity;
import test.task.entity.RequestEntity;
import test.task.entity.enums.Gender;
import test.task.entity.enums.UserRole;
import test.task.rest.DTO.AddressDTO;
import test.task.rest.DTO.EmployeeDTO;
import test.task.rest.DTO.RequestDTO;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

    public static EmployeeDTO generateEmptyEmployeeModel() {
        return new EmployeeDTO();
    }

    public static EmployeeDTO generateEmployeeDTO() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId((long) randomInt());
        employeeDTO.setName("name" + randomString());
        employeeDTO.setSurname("surname" + randomString());
        employeeDTO.setEmail("email" + randomString() + "@gmail.com");
        employeeDTO.setGender("MALE");
        employeeDTO.setPosition("MANAGER");
        employeeDTO.setPhone("123456789");
        employeeDTO.setUserRole("ADMIN");
        employeeDTO.setDateOfBirt("2000-02-03");
        employeeDTO.setPassword("123456789");
        employeeDTO.setIsRemoved(randomBoolean());
        int countAddresses = 5;
        Set<AddressDTO> addressDTOSet = new HashSet<>();
        while (countAddresses > 0) {
            addressDTOSet.add(generateValidAddressDTO());
            countAddresses--;
        }
        employeeDTO.setAddresses(addressDTOSet);
        return employeeDTO;
    }

    public static Employee generateEmployee() {
        Employee employee = new Employee();
        employee.setId((long) randomInt());
        employee.setName("name" + randomString());
        employee.setSurname("surname" + randomString());
        employee.setEmail("email" + randomString() + "@gmail.com");
        employee.setGender(Gender.MALE);
        employee.setPosition("MANAGER");
        employee.setPhone("123456789");
        employee.setUserRole(UserRole.USER);
        employee.setDateOfBirt(LocalDate.now());
        employee.setPassword("123456789");
        employee.setIsRemoved(randomBoolean());
        Set<Address> addressSet = new HashSet<>();
        employee.setAddresses(addressSet);
        return employee;
    }

    public static EmployeeEntity generateEmployeeEntity() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName("name" + randomString());
        employeeEntity.setSurname("surname" + randomString());
        employeeEntity.setEmail("email" + randomString() + "@gmail.com");
        employeeEntity.setGender(Gender.MALE);
        employeeEntity.setPosition("MANAGER");
        employeeEntity.setPhone("123456789");
        employeeEntity.setRole(UserRole.USER);
        employeeEntity.setDateOfBirt(LocalDate.now());
        employeeEntity.setPassword("123456789");
        employeeEntity.setIsRemoved(randomBoolean());
        Set<AddressEntity> addressSet = new HashSet<>();
        employeeEntity.setAddresses(addressSet);
        return employeeEntity;
    }

    public static RequestDTO generateValidRequestModel() {
        RequestDTO requestModel = new RequestDTO();
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

    public static RequestDTO generateRequestDTOWithNotValidPolicyNumber() {
        RequestDTO requestModel = generateValidRequestModel();
        requestModel.setPolicyNumber(requestModel.getPolicyNumber() + "-");
        return requestModel;
    }

    public static RequestDTO generateRequestModelWithNotValidName() {
        RequestDTO requestModel = generateValidRequestModel();
        requestModel.setName(requestModel.getName() + randomInt());
        return requestModel;
    }

    public static RequestDTO generateRequestDTOWithNotValidSurname() {
        RequestDTO requestModel = generateValidRequestModel();
        requestModel.setSurname(requestModel.getSurname() + randomInt());
        return requestModel;
    }

    public static RequestDTO generateRequestDTOWithNotDescription() {
        RequestDTO requestModel = generateValidRequestModel();
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

    public static AddressDTO generateValidAddressDTO() {
        AddressDTO addressModel = new AddressDTO();
        addressModel.setState("state" + randomString());
        addressModel.setCity("city" + randomString());
        addressModel.setPostal("postal" + randomString() + randomInt());
        addressModel.setStreet("street" + randomString() + randomInt());
        return addressModel;
    }
}