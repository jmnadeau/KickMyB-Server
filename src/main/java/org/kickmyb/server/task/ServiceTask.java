package org.kickmyb.server.task;

import org.kickmyb.server.account.MUser;
import org.kickmyb.transfer.*;


import java.util.List;

public interface ServiceTask {

    class Existing extends Exception {}
    class TooShort extends Exception {}
    class Empty extends Exception {}

    // entity handling
    TaskDetailPhotoResponse detail(Long id, MUser user);
    void addOne(AddTaskRequest req, MUser user) throws Existing, Empty, TooShort;
    void updateProgress(long taskID, int value);
    List<HomeItemPhotoResponse> home(Long userID);

    // Potential web demo for JS injection
    String index();

    MUser userFromUsername(String username);
}