package test.task.adapter.request;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import test.task.domain.AcceptedRequest;
import test.task.domain.Request;
import test.task.entity.AcceptedRequestEntity;
import test.task.entity.RequestEntity;
import test.task.entity.repository.AcceptedRequestEntityRepository;
import test.task.entity.repository.EmployeeEntityRepository;
import test.task.entity.repository.KindOfRequestEntityRepository;
import test.task.entity.repository.RequestEntityRepository;
import test.task.exeption.NotFoundException;
import test.task.mapper.acceptedRequests.AcceptedRequestEntityMapper;
import test.task.mapper.request.KindOfRequestEntityMapper;
import test.task.mapper.request.Request2RequestEntityMapper;
import test.task.mapper.request.RequestEntityMapper;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class RequestJpaRepositoryAdapter implements RequestRepositoryAdapter {

    private final RequestEntityRepository requestEntityRepository;
    private final KindOfRequestEntityRepository kindOfRequestEntityRepository;
    private final EmployeeEntityRepository employeeEntityRepository;
    private final AcceptedRequestEntityRepository acceptedRequestEntityRepository;

    private final Request2RequestEntityMapper request2RequestEntityMapper;
    private final RequestEntityMapper requestEntityMapper;
    private final KindOfRequestEntityMapper kindOfRequestEntityMapper;
    private final AcceptedRequestEntityMapper acceptedRequestEntityMapper;


    @Override
    public Request createRequest(Request request) {
        RequestEntity requestEntity = request2RequestEntityMapper.toRequestEntity(request);
        log.info(("Request {} successfully created."), requestEntity);
        return requestEntityMapper.toRequest(requestEntityRepository.save(requestEntity));
    }

    @Override
    public List<String> getAllKindOfRequest() {
        var kindOfRequestOptional = kindOfRequestEntityRepository.findAll();
        log.info(("Kind of request {} got."), kindOfRequestOptional.stream().toList());
        return kindOfRequestEntityMapper.toKindOfRequestNameList(kindOfRequestOptional);
    }

    @Override
    public List<Request> getAllRequests() {
        var requestEntities = requestEntityRepository.findAll();
        log.info(("Find {} requests."), requestEntities.size());
        return requestEntityMapper.toRequestList(requestEntities);
    }

    @Override
    public Request getRequestById(Long id) {
        var requestEntityOptional = requestEntityRepository.findRequestEntityById(id);
        if (requestEntityOptional.isPresent()) {
            Request request = requestEntityMapper.toRequest(requestEntityOptional.get());
            log.info(("request with id {} found {}."), id, request);
            return request;
        } else {
            log.info(("Request with id {} not found."), id);
            throw new NotFoundException("Request not fond.");
        }
    }

    @Override
    public AcceptedRequest acceptRequest(String email, Long id) {
        var employeeEntityOptional = employeeEntityRepository.findEmployeeEntityByEmail(email);
        if (employeeEntityOptional.isEmpty()) {
            log.info(("Employee with email {} not found."), email);
            throw new NotFoundException("Employee not fond.");
        }

        var requestEntityOptional = requestEntityRepository.findRequestEntityById(id);
        if (requestEntityOptional.isEmpty()) {
            log.info(("Request with id {} not found."), id);
            throw new NotFoundException("Request not fond.");
        }

        AcceptedRequestEntity acceptedRequestEntity = new AcceptedRequestEntity();
        acceptedRequestEntity.setEmployee(employeeEntityOptional.get());
        acceptedRequestEntity.setRequest(requestEntityOptional.get());
        acceptedRequestEntity.setIsResolved(false);
        acceptedRequestEntity.setDateOfAcceptance(LocalDate.now());

        return acceptedRequestEntityMapper.toAcceptedRequest(acceptedRequestEntityRepository.save(acceptedRequestEntity));
    }

}
