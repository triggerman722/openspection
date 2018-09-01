package com.openspection.auth.service;


import com.openspection.auth.model.Inspection;
import com.openspection.auth.repository.InspectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InspectionServiceImpl implements InspectionService {
    @Autowired
    private InspectionRepository inspectionRepository;

    @Override
    public void save(Inspection inspection) {
        inspectionRepository.save(inspection);
    }
    @Override
    public void delete(Inspection inspection) {
        inspectionRepository.delete(inspection);
    }
    @Override
    public List<Inspection> findByPostId(Long postId) {
        return inspectionRepository.findByPostId(postId);
    }
    @Override
    public Inspection getOne(Long inspectionid) {
        return inspectionRepository.getOne(inspectionid);
    }
    @Override
    public List<Inspection> findByUserId(Long userId) {
        return inspectionRepository.findByUserId(userId);
    }
    @Override
    public List<Inspection> findByUserIdAndPostId(Long userId, Long postId) {
        return inspectionRepository.findByUserIdAndPostId(userId, postId);
    }

}
