package com.openspection.auth.service;

import com.openspection.auth.model.Post;
import java.util.List;

public interface PostService {
    void save(Post post);

    List<Post> findByCreatedby(Long userid);
    Post getOne(Long postid);
}
