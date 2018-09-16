package com.openspection.auth.repository;

import com.openspection.auth.model.Post;
import com.openspection.auth.model.User;
import com.openspection.auth.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCreatedby(Long userid);
    List<Post> findAllByInspectors(User user);
    @Query("SELECT COUNT(u) FROM post u WHERE u.category=?1")
    Long countByCategory(Category category);

    static final String HAVERSINE_PART = "(6371 * acos(cos(radians(:latitude)) * cos(radians(m.latitude)) * cos(radians(m.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(m.latitude))))";


    @Query("SELECT m FROM post m WHERE ("+HAVERSINE_PART+" < :distance OR :latitude = 0.0 OR :longitude = 0.0) and (m.title like CONCAT('%',:title,'%') or m.description like CONCAT('%',:description,'%')) and (m.category like :category or :category is NULL or :category = 'ALL')")
    List<Post> findPostsByTitleDescriptionLocationAndCategory(
                @Param("title") final String title,
                @Param("description") final String description,
                @Param("latitude") final double latitude,
                @Param("longitude") final double longitude,
                @Param("category") final Category category,
                @Param("distance") final double distance,
                Pageable pageable);
}
