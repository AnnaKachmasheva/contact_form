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

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class RequestJpaRepositoryAdapter implements RequestRepositoryAdapter {

    private final RequestEntityRepository requestEntityRepository;
    private final KindOfRequestEntityRepository kindOfRequestEntityRepository;

    private final Request2RequestEntityMapper request2RequestEntityMapper;
    private final KindOfRequestEntityMapper kindOfRequestEntityMapper;

    @Override
    public void createRequest(Request request) {
        var kindOfRequestOptional =
                kindOfRequestEntityRepository.findKindOfRequestEntitiesByName(request.getKindOfRequest());
        if (kindOfRequestOptional.isPresent()) {
            RequestEntity requestEntity = request2RequestEntityMapper.toRequestEntity(request, kindOfRequestOptional.get());

            log.info(("Request {} successfully created."), requestEntity);

            requestEntityRepository.save(requestEntity);
        }
    }

    @Override
    public List<String> getAllKindOfRequest() {
        var kindOfRequestOptional = kindOfRequestEntityRepository.findAll();

        log.info(("Kind of request {} got."), kindOfRequestOptional.stream().toList());

        return kindOfRequestEntityMapper.toKindOfRequestNameList(kindOfRequestOptional);
    }

}
