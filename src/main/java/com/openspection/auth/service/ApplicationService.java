package com.openspection.auth.service;

import com.openspection.auth.model.Application;
import java.util.List;

public interface ApplicationService {
    void save(Application application);
    Application getOne(Long applicationid);
    List<Application> findByPostId(Long postId);
    List<Application> findByUserId(Long UserId);
}
