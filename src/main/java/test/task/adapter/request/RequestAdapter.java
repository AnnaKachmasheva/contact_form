package test.task.adapter.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Request;
import test.task.facade.RequestFacade;
import test.task.mapper.request.Request2RequestDTOMapper;
import test.task.mapper.request.RequestDTO2RequestMapper;
import test.task.rest.DTO.RequestDTO;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RequestAdapter {

    private final RequestFacade requestFacade;
    private final RequestDTO2RequestMapper requestModel2RequestMapper;
    private final Request2RequestDTOMapper request2RequestModelMapper;

    public RequestDTO createRequest(RequestDTO requestDTO) {
        Request request = requestModel2RequestMapper.toRequest(requestDTO);
        return request2RequestModelMapper.toRequestDTO(requestFacade.createRequest(request));
    }

    public List<String> findAllKindOfRequest() {
        return requestFacade.findAllKindOfRequest();
    }
}