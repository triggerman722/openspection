package com.openspection.auth.service;

import com.openspection.auth.model.Post;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface PostService {
    void save(Post post);

    List<Post> findByCreatedby(Long userid);
    Post getOne(Long postid);
    List<Post> findPostsByTitleDescriptionAndLocation(
                String title,
                String description,
                double latitude,
                double longitude,
                double distance,
                Pageable pageable);
}
