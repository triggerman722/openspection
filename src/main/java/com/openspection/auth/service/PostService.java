package com.openspection.auth.service;

import com.openspection.auth.model.Post;
import com.openspection.auth.model.User;
import com.openspection.auth.model.Category;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface PostService {
    void save(Post post);

    List<Post> findByCreatedby(Long userid);
    List<Post> findAllByInspectors(User user);
    Post getOne(Long postid);
    Long countByCategory(Category category);
    List<Post> findPostsByTitleDescriptionLocationAndCategory(
                String title,
                String description,
                double latitude,
                double longitude, Category category,
                double distance,
                Pageable pageable);
}
