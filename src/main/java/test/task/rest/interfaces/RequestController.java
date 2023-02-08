package test.task.rest.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import test.task.rest.DTO.AcceptedRequestDTO;
import test.task.rest.DTO.RequestDTO;
import test.task.security.CurrentUser;
import test.task.security.model.UserDetailsImpl;

import javax.validation.Valid;
import java.util.List;


public interface RequestController {

    // POST /contactus
    ResponseEntity<Void> createRequest(@RequestBody RequestDTO requestDTO);

    // GET /contactus
    List<String> getKindOfRequest();

    // GET /requests
    List<RequestDTO> getRequests();

    // GET /request/{requestId}
    RequestDTO getRequestById(@Valid @PathVariable Long id);

    // POST /request/{requestId}
    AcceptedRequestDTO acceptRequest(@Valid @PathVariable Long id, @CurrentUser UserDetailsImpl userDetails);

}