package test.task.adapter.request;

import test.task.domain.Request;

import java.util.List;

public interface RequestRepositoryAdapter {

    void createRequest(Request request);

    List<String> getAllKindOfRequest();
}
