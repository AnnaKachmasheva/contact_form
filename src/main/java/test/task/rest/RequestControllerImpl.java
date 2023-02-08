package test.task.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.task.adapter.request.RequestAdapter;
import test.task.rest.DTO.AcceptedRequestDTO;
import test.task.rest.DTO.RequestDTO;
import test.task.rest.DTO.validator.RequestDTOValidator;
import test.task.rest.interfaces.RequestController;
import test.task.rest.util.RestUtil;
import test.task.security.CurrentUser;
import test.task.security.model.UserDetailsImpl;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000/")
@RequiredArgsConstructor
public class RequestControllerImpl implements RequestController {

    private final RequestDTOValidator requestModelValidation;
    private final RequestAdapter requestAdapter;

    @PostMapping(value = "contactus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRequest(@RequestBody RequestDTO requestDTO) {
        requestModelValidation.validate(requestDTO);

        final HttpHeaders headers = RestUtil.createLocationHeaderNewUri("contactus/{responseId}", requestAdapter.createRequest(requestDTO).getId());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "contactus", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getKindOfRequest() {
        return requestAdapter.findAllKindOfRequest();
    }

    @Override
    @GetMapping(value = "requests", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RequestDTO> getRequests() {
        return requestAdapter.getRequests();
    }

    @Override
    @GetMapping(value = "request/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RequestDTO getRequestById(@Valid @PathVariable Long id) {
        return requestAdapter.getRequestById(id);
    }

    @Override
    @PostMapping(value = "request/{id}")
    public AcceptedRequestDTO acceptRequest(@Valid @PathVariable Long id, @CurrentUser UserDetailsImpl userDetails) {
        return requestAdapter.acceptRequest(userDetails.getUsername(), id);
    }

}