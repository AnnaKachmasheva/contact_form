package test.task.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.task.adapter.request.RequestAdapter;
import test.task.model.validator.RequestModelValidation;
import test.task.model.RequestModel;

import java.util.List;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000/")
@RequiredArgsConstructor
public class RequestController {

   private final RequestModelValidation requestModelValidation;
    private final RequestAdapter requestAdapter;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRequest(@RequestBody RequestModel requestModel) {
        requestModelValidation.validation(requestModel);
        requestAdapter.createRequest(requestModel);
        return ResponseEntity.ok().build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getKindOfRequest() {
        return requestAdapter.findAllKindOfRequest();
    }
}