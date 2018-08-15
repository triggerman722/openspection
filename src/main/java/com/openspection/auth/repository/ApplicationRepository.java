package com.openspection.auth.repository;

import com.openspection.auth.model.Post;
import com.openspection.auth.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByPostId(Long postId);
    List<Application> findByUserId(Long userId);

}
