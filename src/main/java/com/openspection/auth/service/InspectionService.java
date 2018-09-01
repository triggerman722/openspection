package com.openspection.auth.service;

import com.openspection.auth.model.Inspection;
import java.util.List;

public interface InspectionService {
    void save(Inspection inspection);
    void delete(Inspection inspection);
    Inspection getOne(Long inspectionid);
    List<Inspection> findByPostId(Long postId);
    List<Inspection> findByUserId(Long userId);
    List<Inspection> findByUserIdAndPostId(Long userId, Long postId);
}
