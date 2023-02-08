package test.task.adapter.request;

import test.task.domain.AcceptedRequest;
import test.task.domain.Request;

import java.util.List;

public interface RequestRepositoryAdapter {

    Request createRequest(Request request);

    List<String> getAllKindOfRequest();

    List<Request> getAllRequests();

    Request getRequestById(Long id);

    AcceptedRequest acceptRequest(String email, Long id);

}
