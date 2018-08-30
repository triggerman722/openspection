package com.openspection.auth.service;


import com.openspection.auth.model.Application;
import com.openspection.auth.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public void save(Application application) {
        applicationRepository.save(application);
    }
    @Override
    public void delete(Application application) {
        applicationRepository.delete(application);
    }
    @Override
    public List<Application> findByPostId(Long postId) {
        return applicationRepository.findByPostId(postId);
    }
    @Override
    public Application getOne(Long applicationid) {
        return applicationRepository.getOne(applicationid);
    }
    @Override
    public List<Application> findByUserId(Long userId) {
        return applicationRepository.findByUserId(userId);
    }
    @Override
    public List<Application> findByUserIdAndPostId(Long userId, Long postId) {
        return applicationRepository.findByUserIdAndPostId(userId, postId);
    }

}
