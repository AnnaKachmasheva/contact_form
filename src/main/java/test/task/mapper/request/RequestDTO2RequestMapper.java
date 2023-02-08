package test.task.mapper.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Request;
import test.task.rest.DTO.RequestDTO;

@Component
@RequiredArgsConstructor
public class RequestDTO2RequestMapper {

    public Request toRequest(RequestDTO requestDTO) {
        if (requestDTO == null)
            return null;
        Request request = new Request();
        request.setId(requestDTO.getId());
        request.setName(requestDTO.getName());
        request.setSurname(requestDTO.getSurname());
        request.setDescription(requestDTO.getDescription());
        request.setPolicyNumber(requestDTO.getPolicyNumber());
        request.setKindOfRequest(requestDTO.getKindOfRequest());
        request.setIsRemoved(requestDTO.getIsRemoved());
        return request;
    }

}