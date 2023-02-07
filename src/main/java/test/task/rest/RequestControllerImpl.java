package test.task.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.task.adapter.request.RequestAdapter;
import test.task.rest.DTO.RequestDTO;
import test.task.rest.DTO.validator.RequestDTOValidator;
import test.task.rest.interfaces.RequestController;
import test.task.rest.util.RestUtil;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/contactus")
@CrossOrigin(origins = "http://localhost:3000/")
@RequiredArgsConstructor
public class RequestControllerImpl implements RequestController {

    private final RequestDTOValidator requestModelValidation;
    private final RequestAdapter requestAdapter;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRequest(@RequestBody RequestDTO requestDTO) {
        requestModelValidation.validate(requestDTO);

        final HttpHeaders headers = RestUtil.createLocationHeaderNewUri("contactus/{responseId}", requestAdapter.createRequest(requestDTO).getId());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getKindOfRequest() {
        return requestAdapter.findAllKindOfRequest();
    }

    @Override
    public Set<RequestDTO> getRequests() {
        return requestAdapter.getRequests();
    }
}