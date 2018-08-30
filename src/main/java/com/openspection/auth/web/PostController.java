package com.openspection.auth.web;

import com.openspection.auth.model.Post;
import com.openspection.auth.model.User;
import com.openspection.auth.model.Application;
import com.openspection.auth.service.PostService;
import com.openspection.auth.service.UserService;
import com.openspection.auth.service.ApplicationService;
import com.openspection.auth.validator.PostValidator;
import com.openspection.auth.validator.ApplicationValidator;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Date;
import org.apache.commons.io.IOUtils;
import org.json.*;
import java.net.*;

@Controller
public class PostController {
    @Autowired
    private PostService PostService;

    @Autowired
    private UserService UserService;

    @Autowired
    private ApplicationService ApplicationService;

    @Autowired
    private PostValidator PostValidator;

    @Autowired
    private ApplicationValidator ApplicationValidator;

    @RequestMapping(value = "/members/{username}/posts", method = RequestMethod.GET)
    public String postList(Model model, @PathVariable String username) {

	User loggedUser = UserService.findByUsername(username);
	List<Post> searchresults = PostService.findByCreatedby(loggedUser.getId());

        model.addAttribute("searchresults", searchresults);
        model.addAttribute("pageTitle", "List the posts for " + username);

        return "postlist";
    }
    @RequestMapping(value = "/posts/{postid}", method = RequestMethod.GET)
    public String getSinglePost(Model model, @PathVariable Long postid, Principal principal) {

	Post singlePost = PostService.getOne(postid);
	User singleUser = UserService.getOne(singlePost.getCreatedby());

	boolean isApplyable = true;
	boolean isEditable = false;

        if(principal!=null) {
		if (principal.getName().equalsIgnoreCase(singleUser.getUsername())) {
                	isApplyable = false;
			isEditable = true;
		}
		User loggedUser = UserService.findByUsername(principal.getName());
		List<Application> priorapplications = ApplicationService.findByUserIdAndPostId(loggedUser.getId(), singlePost.getId());
		if (priorapplications!=null && priorapplications.size() > 0) {
			isApplyable = false;
		}
        }

	List<Application> applications = ApplicationService.findByPostId(singlePost.getId());

        model.addAttribute("applyable", isApplyable);
        model.addAttribute("editable", isEditable);

        model.addAttribute("singlepost", singlePost);
        model.addAttribute("applications", applications);
        model.addAttribute("singleuser", singleUser);
        model.addAttribute("pageTitle", singlePost.getTitle());

        return "postview";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.GET)
    public String postCreate(Model model) {

        model.addAttribute("postForm", new Post());
        model.addAttribute("pageTitle", "Create a new post.");

        return "postcreate";
    }
    @RequestMapping(value = "/posts/{postid}/application", method = RequestMethod.GET)
    public String applicationCreateRequest(Model model, @PathVariable Long postid) {

	Post singlePost = PostService.getOne(postid);

	Application application = new Application();

        model.addAttribute("application", application);
        model.addAttribute("pageTitle", "Apply for: " + singlePost.getTitle());

        return "applicationcreate";
    }

    @RequestMapping(value = "/posts/{postid}/application", method = RequestMethod.POST)
    public String applicationCreate(@ModelAttribute("application") Application application, BindingResult bindingResult, Model model, Principal principal, @PathVariable Long postid) {
        String name = principal.getName();
        User loggedUser = UserService.findByUsername(name);
	Post singlePost = PostService.getOne(postid);

        application.setUser(loggedUser);
        application.setPost(singlePost);

        ApplicationValidator.validate(application, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Create a new application - but please fix these errors!");
            return "applicationcreate";
        }

        ApplicationService.save(application);
        return "redirect:/members/"+name;
    }
    @RequestMapping(value = "/posts/{postid}/application/{applicationid}", method = RequestMethod.GET)
    public String applicationGet(Model model, @PathVariable Long postid, @PathVariable Long applicationid) {

        Post singlePost = PostService.getOne(postid);
        Application singleApplication = ApplicationService.getOne(applicationid);

        model.addAttribute("application", singleApplication);
        model.addAttribute("pageTitle", "Application for: " + singlePost.getTitle());

        return "applicationview";
    }

    @RequestMapping(value = "/posts/{postid}/application/{applicationid}/cancel", method = RequestMethod.GET)
    public String applicationCancelRequest(Model model, @PathVariable Long postid, @PathVariable Long applicationid) {
    
        Post singlePost = PostService.getOne(postid);
        Application singleApplication = ApplicationService.getOne(applicationid);

        model.addAttribute("application", singleApplication);
        model.addAttribute("pageTitle", "Cancel application for: " + singlePost.getTitle());

        return "applicationcancel";
    }
    @RequestMapping(value = "/posts/{postid}/application/{applicationid}/cancel", method = RequestMethod.POST)
    public String applicationCancel(Model model, @PathVariable Long postid, @PathVariable Long applicationid) {
   
        Application singleApplication = ApplicationService.getOne(applicationid);

	ApplicationService.delete(singleApplication);

	return "redirect:/posts/"+postid;
    }


    @RequestMapping(value = "/posts/{postid}/application/{applicationid}/hire", method = RequestMethod.GET)
    public String applicationHireRequest(Model model, @PathVariable Long postid, @PathVariable Long applicationid) {

        Post singlePost = PostService.getOne(postid);
        Application singleApplication = ApplicationService.getOne(applicationid);

        model.addAttribute("application", singleApplication);
        model.addAttribute("post", singlePost);
        model.addAttribute("pageTitle", "Hire application for: " + singlePost.getTitle());

        return "hireconfirm";
    }
    @RequestMapping(value = "/posts/{postid}/application/{applicationid}/hire", method = RequestMethod.POST)
    public String applicationHire(Model model, @PathVariable Long postid, @PathVariable Long applicationid) {

        Application singleApplication = ApplicationService.getOne(applicationid);
        Post singlePost = PostService.getOne(postid);

	singlePost.getInspectors().add(singleApplication.getUser());

	PostService.save(singlePost);
	ApplicationService.delete(singleApplication);
        return "redirect:/posts/"+postid;
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
            return "postcreate";
        }

	PostService.save(postForm);
        return "redirect:/members/"+name;
    }
    @RequestMapping(value = "/posts/search", method = RequestMethod.GET)
    public String searchforposts(Model model, Pageable pageable,
        @RequestParam("keywords") String keywords,
	@RequestParam(value="location", required=false) String location,
	@RequestParam(value="latitude", required=false) Double flatitude,
	@RequestParam(value="longitude", required=false) Double flongitude,
        @RequestParam(value="category_id", required=false) Integer categoryId) {

	double latitude = flatitude;
	double longitude = flongitude;

        System.out.println("Keywords: " + keywords 
		+ "Location: " + location 
		+ "Latitude: " + latitude 
		+ "Longitude: " + longitude 
		+ " Category: " + categoryId);
	if (latitude < 1 && longitude < 1) {

		JSONArray joa = null;
		try {
			joa = (JSONArray) new JSONTokener(IOUtils.toString(new URL("https://nominatim.openstreetmap.org/search?q="+URLEncoder.encode(location, "UTF-8")+"&format=json&addressdetails=1").openStream(), "UTF-8")).nextValue();
			JSONObject jo = joa.getJSONObject(0);
			latitude = jo.getDouble("lat");
			longitude = jo.getDouble("lon");
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

        List<Post> searchresults = PostService.findPostsByTitleDescriptionAndLocation(keywords, keywords, latitude, longitude, 100, pageable);
        model.addAttribute("searchresults", searchresults);
        model.addAttribute("keywords", keywords);
        model.addAttribute("location", location);

        return "postlist";
    }

}
