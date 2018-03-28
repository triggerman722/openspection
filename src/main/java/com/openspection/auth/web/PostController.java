package com.openspection.auth.web;

import com.openspection.auth.model.Post;
import com.openspection.auth.model.User;
import com.openspection.auth.service.PostService;
import com.openspection.auth.service.UserService;
import com.openspection.auth.validator.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.security.Principal;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Date;

@Controller
public class PostController {
    @Autowired
    private PostService PostService;

    @Autowired
    private UserService UserService;

    @Autowired
    private PostValidator PostValidator;

    @RequestMapping(value = "/{username}/posts", method = RequestMethod.GET)
    public String postList(Model model, @PathVariable String username) {

	User loggedUser = UserService.findByUsername(username);
	List<Post> userPosts = PostService.findByCreatedby(loggedUser.getId());

        model.addAttribute("postList", userPosts);
        model.addAttribute("pageTitle", "List the posts for " + username);

        return "postlist";
    }
    @RequestMapping(value = "/posts/{postid}", method = RequestMethod.GET)
    public String getSinglePost(Model model, @PathVariable Long postid) {

	Post singlePost = PostService.getOne(postid);

        model.addAttribute("singlepost", singlePost);
        model.addAttribute("pageTitle", singlePost.getTitle());

        return "postview";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.GET)
    public String postCreate(Model model) {

        model.addAttribute("postForm", new Post());
        model.addAttribute("pageTitle", "Create a new post.");

        return "postcreate";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String postCreate(@ModelAttribute("postForm") Post postForm, BindingResult bindingResult, Model model, Principal principal) {
        String name = principal.getName();
	User loggedUser = UserService.findByUsername(name);
	postForm.setCreatedby(loggedUser.getId());
	postForm.setDatecreated(new Date());

        PostValidator.validate(postForm, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Create a new post - but please fix these errors!");
 List<FieldError> errors = bindingResult.getFieldErrors();
    for (FieldError error : errors ) {
        System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
    }

            return "postcreate";
        }

	PostService.save(postForm);
        return "redirect:/welcome";
    }

}
