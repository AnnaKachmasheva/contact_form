package test.task.rest.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import test.task.rest.DTO.RequestDTO;

import java.util.List;


public interface RequestController {

    // POST /contactus
    public ResponseEntity<Void> createRequest(@RequestBody RequestDTO requestDTO);

    // GET /contactus
    public List<String> getKindOfRequest();
}