package com.openspection.auth.repository;

import com.openspection.auth.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCreatedby(Long userid);

    static final String HAVERSINE_PART = "(6371 * acos(cos(radians(:latitude)) * cos(radians(m.latitude)) * cos(radians(m.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(m.latitude))))";


    @Query("SELECT m FROM post m WHERE "+HAVERSINE_PART+" < :distance and (m.title like CONCAT('%',:title,'%') or m.description like CONCAT('%',:description,'%'))")
    List<Post> findPostsByTitleDescriptionAndLocation(
                @Param("title") final String title,
                @Param("description") final String description,
                @Param("latitude") final double latitude,
                @Param("longitude") final double longitude,
                @Param("distance") final double distance,
                Pageable pageable);
}
