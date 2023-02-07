package test.task.mapper.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Request;
import test.task.rest.DTO.RequestDTO;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Request2RequestDTOMapper {

    public RequestDTO toRequestDTO(Request request) {
        if (request == null)
            return null;
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setId(request.getId());
        requestDTO.setKindOfRequest(request.getKindOfRequest());
        requestDTO.setName(request.getName());
        requestDTO.setSurname(request.getSurname());
        requestDTO.setDescription(request.getDescription());
        requestDTO.setPolicyNumber(request.getPolicyNumber());
        return requestDTO;
    }

    public List<RequestDTO> toRequestDTOList(List<Request> requests) {
        List<RequestDTO> requestDTOS = new ArrayList<>(requests.size());
        for (Request request : requests) {
            requestDTOS.add(toRequestDTO(request));
        }
        return requestDTOS;
    }
}
