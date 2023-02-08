package test.task.mapper.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Request;
import test.task.entity.KindOfRequestEntity;
import test.task.entity.RequestEntity;
import test.task.rest.DTO.RequestDTO;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RequestEntityMapper {

    public Request toRequest(RequestEntity requestEntity) {
        if (requestEntity == null)
            return null;
        Request request = new Request();
        request.setId(requestEntity.getId());
        request.setKindOfRequest(requestEntity.getKindOfRequestEntity().getName());
        request.setPolicyNumber(requestEntity.getPolicyNumber());
        request.setName(requestEntity.getName());
        request.setSurname(requestEntity.getSurname());
        request.setDescription(requestEntity.getDescription());
        request.setIsRemoved(requestEntity.getIsRemoved());
        return request;
    }

    public List<Request> toRequestList(List<RequestEntity> requestEntities) {
        List<Request> requests = new ArrayList<>(requestEntities.size());
        for (RequestEntity entity : requestEntities) {
            requests.add(toRequest(entity));
        }
        return requests;
    }
}
