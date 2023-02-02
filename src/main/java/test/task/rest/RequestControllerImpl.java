package test.task.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.task.adapter.request.RequestAdapter;
import test.task.model.RequestModel;
import test.task.model.validator.RequestModelValidator;
import test.task.rest.util.RestUtil;

import java.util.List;


@RestController
@RequestMapping("/contactus")
@CrossOrigin(origins = "http://localhost:3000/")
@RequiredArgsConstructor
public class RequestControllerImpl {

    private final RequestModelValidator requestModelValidation;
    private final RequestAdapter requestAdapter;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRequest(@RequestBody RequestModel requestModel) {
        requestModelValidation.validate(requestModel);

        final HttpHeaders headers = RestUtil.createLocationHeaderNewUri("contactus/{responseId}", requestAdapter.createRequest(requestModel).getId());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getKindOfRequest() {
        return requestAdapter.findAllKindOfRequest();
    }
}