package com.openspection.auth.service;

import com.openspection.auth.model.Post;
import com.openspection.auth.model.User;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface PostService {
    void save(Post post);

    List<Post> findByCreatedby(Long userid);
    List<Post> findAllByInspectors(User user);
    Post getOne(Long postid);
    List<Post> findPostsByTitleDescriptionAndLocation(
                String title,
                String description,
                double latitude,
                double longitude,
                double distance,
                Pageable pageable);
}
