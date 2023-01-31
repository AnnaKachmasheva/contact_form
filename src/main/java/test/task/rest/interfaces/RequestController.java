package test.task.rest.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import test.task.model.RequestModel;

import java.util.List;


public interface RequestController {

    // POST /contactus
    public ResponseEntity<Void> createRequest(@RequestBody RequestModel requestModel);

    // GET /contactus
    public List<String> getKindOfRequest();
}