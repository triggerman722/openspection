package com.openspection.auth.repository;

import com.openspection.auth.model.Post;
import com.openspection.auth.model.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface InspectionRepository extends JpaRepository<Inspection, Long> {
    List<Inspection> findByPostId(Long postId);
    List<Inspection> findByUserId(Long userId);
    List<Inspection> findByUserIdAndPostId(Long userId, Long postId);

}
