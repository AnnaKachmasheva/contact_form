package test.task.adapter.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import test.Generator;
import test.task.adapter.employee.EmployeeJpaRepositoryAdapter;
import test.task.adapter.employee.EmployeeRepositoryAdapter;
import test.task.domain.AcceptedRequest;
import test.task.domain.Employee;
import test.task.domain.Request;
import test.task.entity.EmployeeEntity;
import test.task.entity.RequestEntity;
import test.task.exeption.NotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class RequestRepositoryAdapterTest {

    @Autowired
    RequestRepositoryAdapter requestRepositoryAdapter;

    @Autowired
    RequestJpaRepositoryAdapter requestJpaRepositoryAdapter;

    @Autowired
    EmployeeJpaRepositoryAdapter employeeJpaRepositoryAdapter;

    private Request request;

    @BeforeEach
    public void init() {
        request = Generator.generateValidRequest();
    }

    @Test
    void createRequest_Request_success() {
        Request savedRequest = requestJpaRepositoryAdapter.createRequest(request);

        Assertions.assertEquals(request.getName(), savedRequest.getName());
        Assertions.assertEquals(request.getSurname(), savedRequest.getSurname());
        Assertions.assertEquals(request.getDescription(), savedRequest.getDescription());
        Assertions.assertEquals(request.getPolicyNumber(), savedRequest.getPolicyNumber());
        Assertions.assertEquals(request.getKindOfRequest(), savedRequest.getKindOfRequest());
    }

    @Test
    void getAllRequests_get10Requests() {
        List<Request> requests = new ArrayList<>();
        requests.add(requestJpaRepositoryAdapter.createRequest(request));
        int count = 9;
        for (int i = 0; i < count; i++) {
            requests.add(requestJpaRepositoryAdapter.createRequest(Generator.generateValidRequest()));
        }

        List<Request> requestList = requestJpaRepositoryAdapter.getAllRequests();

        Assertions.assertEquals(requests.size(), requestList.size());
    }

    @Test
    void getRequestById_existingId_Request() {
        var savedRequest = requestRepositoryAdapter.createRequest(request);
        var gettingRequest = requestRepositoryAdapter.getRequestById(savedRequest.getId());

        Assertions.assertEquals(savedRequest.getName(), gettingRequest.getName());
        Assertions.assertEquals(savedRequest.getSurname(), gettingRequest.getSurname());
        Assertions.assertEquals(savedRequest.getDescription(), gettingRequest.getDescription());
        Assertions.assertEquals(savedRequest.getPolicyNumber(), gettingRequest.getPolicyNumber());
        Assertions.assertEquals(savedRequest.getKindOfRequest(), gettingRequest.getKindOfRequest());
    }

    @Test
    void getRequestById_notExistingId_NotFoundException() {
        assertThatThrownBy(() -> requestRepositoryAdapter.getRequestById(request.getId()))
                .isInstanceOf(NotFoundException.class);
    }

    @Test
    void acceptRequest_NotExistingEmployee_NotFoundException() {
        EmployeeEntity employeeEntity = Generator.generateEmployeeEntity();
        Request savedRequest = requestJpaRepositoryAdapter.createRequest(request);

        assertThatThrownBy(() -> requestRepositoryAdapter.acceptRequest(employeeEntity.getEmail(), savedRequest.getId()))
                .isInstanceOf(NotFoundException.class);
    }

    @Test
    void acceptRequest_NotExistingRequest_NotFoundException() {
        Employee savedEmployee = employeeJpaRepositoryAdapter.createEmployee(Generator.generateEmployee());

        assertThatThrownBy(() -> requestRepositoryAdapter.acceptRequest(savedEmployee.getEmail(), request.getId()))
                .isInstanceOf(NotFoundException.class);
    }

    @Test
    void acceptRequest_success() {
        Employee savedEmployee = employeeJpaRepositoryAdapter.createEmployee(Generator.generateEmployee());
        Request savedRequest = requestJpaRepositoryAdapter.createRequest(request);

        AcceptedRequest acceptedRequest = requestJpaRepositoryAdapter.acceptRequest(savedEmployee.getEmail(), savedRequest.getId());

        Assertions.assertEquals(savedEmployee.getId(), acceptedRequest.getEmployee().getId());
        Assertions.assertEquals(savedEmployee.getSurname(), acceptedRequest.getEmployee().getSurname());
        Assertions.assertEquals(savedEmployee.getPhone(), acceptedRequest.getEmployee().getPhone());
        Assertions.assertEquals(savedEmployee.getDateOfBirt(), acceptedRequest.getEmployee().getDateOfBirt());
        Assertions.assertEquals(savedEmployee.getIsRemoved(), acceptedRequest.getEmployee().getIsRemoved());
        Assertions.assertEquals(savedEmployee.getPassword(), acceptedRequest.getEmployee().getPassword());
        Assertions.assertEquals(savedEmployee.getUserRole(), acceptedRequest.getEmployee().getUserRole());
        Assertions.assertEquals(savedEmployee.getPosition(), acceptedRequest.getEmployee().getPosition());
        Assertions.assertEquals(savedEmployee.getGender(), acceptedRequest.getEmployee().getGender());
        Assertions.assertEquals(savedEmployee.getEmail(), acceptedRequest.getEmployee().getEmail());
        Assertions.assertEquals(savedRequest.getName(), acceptedRequest.getRequest().getName());
        Assertions.assertEquals(savedRequest.getSurname(), acceptedRequest.getRequest().getSurname());
        Assertions.assertEquals(savedRequest.getDescription(), acceptedRequest.getRequest().getDescription());
        Assertions.assertEquals(savedRequest.getPolicyNumber(), acceptedRequest.getRequest().getPolicyNumber());
        Assertions.assertEquals(savedRequest.getKindOfRequest(), acceptedRequest.getRequest().getKindOfRequest());
        Assertions.assertFalse(acceptedRequest.getIsResolved());
    }

}