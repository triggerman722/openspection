package com.openspection.auth.service;

import com.openspection.auth.model.Post;
import com.openspection.auth.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public void save(Post post) {
	postRepository.save(post);
    }

    @Override
    public List<Post> findByCreatedby(Long userid) {
        return postRepository.findByCreatedby(userid);
    }
    @Override
    public Post getOne(Long postid) {
        return postRepository.getOne(postid);
    }

    @Override
    public List<Post> findPostsByTitleDescriptionAndLocation(
		String title,
		String description,
		double latitude,
		double longitude,
		double distance,
		Pageable pageable) {
        return postRepository.findPostsByTitleDescriptionAndLocation(title, description, latitude, longitude, distance, pageable);
    }

}
