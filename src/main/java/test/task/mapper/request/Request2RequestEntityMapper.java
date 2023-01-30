package test.task.mapper.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Request;
import test.task.entity.KindOfRequestEntity;
import test.task.entity.RequestEntity;

@Component
@RequiredArgsConstructor
public class Request2RequestEntityMapper {

    public RequestEntity toRequestEntity(Request request, KindOfRequestEntity kindOfRequestEntity) {
        if (request == null)
            return null;
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setKindOfRequestEntity(kindOfRequestEntity);
        requestEntity.setPolicyNumber(request.getPolicyNumber());
        requestEntity.setName(request.getName());
        requestEntity.setSurname(request.getSurname());
        requestEntity.setDescription(request.getDescription());
        return requestEntity;
    }
}
