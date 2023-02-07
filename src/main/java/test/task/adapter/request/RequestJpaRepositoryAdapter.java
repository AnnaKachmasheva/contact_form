package test.task.adapter.request;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import test.task.domain.Request;
import test.task.entity.RequestEntity;
import test.task.entity.repository.KindOfRequestEntityRepository;
import test.task.entity.repository.RequestEntityRepository;
import test.task.mapper.request.KindOfRequestEntityMapper;
import test.task.mapper.request.Request2RequestEntityMapper;
import test.task.mapper.request.RequestEntityMapper;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class RequestJpaRepositoryAdapter implements RequestRepositoryAdapter {

    private final RequestEntityRepository requestEntityRepository;
    private final KindOfRequestEntityRepository kindOfRequestEntityRepository;

    private final Request2RequestEntityMapper request2RequestEntityMapper;
    private final RequestEntityMapper requestEntityMapper;
    private final KindOfRequestEntityMapper kindOfRequestEntityMapper;

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

}
