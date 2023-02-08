package test.task.adapter.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Request;
import test.task.facade.RequestFacade;
import test.task.mapper.acceptedRequests.AcceptedRequest2AcceptedRequestDTOMapper;
import test.task.mapper.request.Request2RequestDTOMapper;
import test.task.mapper.request.RequestDTO2RequestMapper;
import test.task.rest.DTO.AcceptedRequestDTO;
import test.task.rest.DTO.RequestDTO;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RequestAdapter {

    private final RequestFacade requestFacade;
    private final RequestDTO2RequestMapper requestModel2RequestMapper;
    private final Request2RequestDTOMapper request2RequestDTOMapper;

    private final AcceptedRequest2AcceptedRequestDTOMapper acceptedRequest2AcceptedRequestDTOMapper;

    public RequestDTO createRequest(RequestDTO requestDTO) {
        Request request = requestModel2RequestMapper.toRequest(requestDTO);
        return request2RequestDTOMapper.toRequestDTO(requestFacade.createRequest(request));
    }

    public List<String> findAllKindOfRequest() {
        return requestFacade.findAllKindOfRequest();
    }

    public List<RequestDTO> getRequests() {
        return request2RequestDTOMapper.toRequestDTOList(requestFacade.getRequests());
    }

    public RequestDTO getRequestById(Long id) {
        return request2RequestDTOMapper.toRequestDTO(requestFacade.getRequestById(id));
    }

    public AcceptedRequestDTO acceptRequest(String email, Long id) {
        return acceptedRequest2AcceptedRequestDTOMapper.toAcceptedRequestDTO(requestFacade.acceptRequest(email, id));
    }

}