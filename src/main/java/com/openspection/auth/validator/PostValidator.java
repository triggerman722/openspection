package com.openspection.auth.validator;

import com.openspection.auth.model.Post;
import com.openspection.auth.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PostValidator implements Validator {
    @Autowired
    private PostService postService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Post.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Post post = (Post) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty");
        if (post.getTitle().length() < 3 || post.getTitle().length() > 255) {
            errors.rejectValue("title", "Size.postForm.title");
        }
    }
}
