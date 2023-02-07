package test.task.rest.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import test.task.rest.DTO.RequestDTO;

import java.util.List;
import java.util.Set;


public interface RequestController {

    // POST /contactus
    ResponseEntity<Void> createRequest(@RequestBody RequestDTO requestDTO);

    // GET /contactus
    List<String> getKindOfRequest();

    // GET /requests
    Set<RequestDTO> getRequests();
}