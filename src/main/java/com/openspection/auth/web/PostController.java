package com.openspection.auth.web;

import com.openspection.auth.model.Post;
import com.openspection.auth.model.User;
import com.openspection.auth.model.Application;
import com.openspection.auth.model.Inspection;
import com.openspection.auth.model.SearchRequest;
import com.openspection.auth.model.Category;
import com.openspection.auth.service.PostService;
import com.openspection.auth.service.UserService;
import com.openspection.auth.service.ApplicationService;
import com.openspection.auth.service.InspectionService;
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
    private InspectionService InspectionService;

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
	List<Inspection> inspections = InspectionService.findByPostId(singlePost.getId());

        model.addAttribute("applyable", isApplyable);
        model.addAttribute("editable", isEditable);

        model.addAttribute("singlepost", singlePost);
        model.addAttribute("applications", applications);
        model.addAttribute("inspections", inspections);
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

    @RequestMapping(value = "/posts/{postid}/inspections/{inspectionid}", method = RequestMethod.GET)
    public String inspectionGet(Model model, @PathVariable Long postid, @PathVariable Long inspectionid) {

        Post singlePost = PostService.getOne(postid);
        Inspection singleInspection = InspectionService.getOne(inspectionid);

        model.addAttribute("inspection", singleInspection);
        model.addAttribute("pageTitle", "Inspection for: " + singlePost.getTitle());

        return "inspectionview";
    }

    @RequestMapping(value = "/posts/{postid}/inspections/{inspectionid}", method = RequestMethod.POST)
    public String inspectionEdit(Model model, @PathVariable Long postid, @PathVariable Long inspectionid) {

        Inspection singleInspection = InspectionService.getOne(inspectionid);

	//TODO: The edited inspection needs to be passed in here.
	//TODO: Only the original inspector may edit.

        InspectionService.save(singleInspection);

        return "redirect:/posts/"+postid+"/inspection/"+inspectionid;
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

	//TODO: Only the logged in, original author is permitted to hire!!!
        Application singleApplication = ApplicationService.getOne(applicationid);
        Post singlePost = PostService.getOne(postid);

	singlePost.getInspectors().add(singleApplication.getUser());

	PostService.save(singlePost);
	Inspection inspection = new Inspection();
	inspection.setUser(singleApplication.getUser());
	inspection.setPost(singlePost);
	InspectionService.save(inspection);
	ApplicationService.delete(singleApplication);
        return "redirect:/posts/"+postid;
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String postCreate(@ModelAttribute("postForm") Post postForm, BindingResult bindingResult, Model model, Principal principal) {
        String name = principal.getName();
	User loggedUser = UserService.findByUsername(name);
	postForm.setCreatedby(loggedUser.getId());
	postForm.setDatecreated(new Date());

        JSONArray joa = null;
        try {
            joa = (JSONArray) new JSONTokener(IOUtils.toString(new URL("https://nominatim.openstreetmap.org/search?q="+URLEncoder.encode(postForm.getLocation(), "UTF-8")+"&format=json&addressdetails=1").openStream(), "UTF-8")).nextValue();
            JSONObject jo = joa.getJSONObject(0);
            postForm.setLatitude(jo.getDouble("lat"));
            postForm.setLongitude(jo.getDouble("lon"));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        PostValidator.validate(postForm, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Create a new post - but please fix these errors!");
            return "postcreate";
        }

	PostService.save(postForm);
        return "redirect:/members/"+name;
    }
    @RequestMapping(value = "/posts/search", method = RequestMethod.POST)
    public String searchforposts(Model model, Pageable pageable, @ModelAttribute("searchrequest") SearchRequest searchrequest) { 

        System.out.println("Keywords: " + searchrequest.getKeywords() 
		+ "Location: " + searchrequest.getLocation() 
		+ "Latitude: " + searchrequest.getLatitude() 
		+ "Longitude: " + searchrequest.getLongitude() 
		+ " Category: " + searchrequest.getCategory());
	if (searchrequest.getLatitude() < 1 && searchrequest.getLongitude() < 1) {

		JSONArray joa = null;
		try {
			joa = (JSONArray) new JSONTokener(IOUtils.toString(new URL("https://nominatim.openstreetmap.org/search?q="+URLEncoder.encode(searchrequest.getLocation(), "UTF-8")+"&format=json&addressdetails=1").openStream(), "UTF-8")).nextValue();
			JSONObject jo = joa.getJSONObject(0);
			searchrequest.setLatitude(jo.getDouble("lat"));
			searchrequest.setLongitude(jo.getDouble("lon"));
		} catch (Exception e){
			System.out.println(e.getMessage());
			searchrequest.setLatitude(0);
			searchrequest.setLongitude(0);
		}
	}

        List<Post> searchresults = PostService.findPostsByTitleDescriptionLocationAndCategory(searchrequest.getKeywords(), searchrequest.getKeywords(), searchrequest.getLatitude(), searchrequest.getLongitude(), searchrequest.getCategory(), 100, pageable);
        model.addAttribute("searchresults", searchresults);
        model.addAttribute("searchrequest", searchrequest);

        return "postlist";
    }
    @RequestMapping(value = "/posts/categories/{category}", method = RequestMethod.GET)
    public String postsbycategory(Model model, Pageable pageable, @PathVariable String category) {
        SearchRequest searchrequest = new SearchRequest();    
	searchrequest.setCategory(Category.valueOf(category));
	searchrequest.setLatitude(0);
	searchrequest.setLongitude(0);
	searchrequest.setKeywords("");

 	List<Post> searchresults = PostService.findPostsByTitleDescriptionLocationAndCategory(searchrequest.getKeywords(), searchrequest.getKeywords(), searchrequest.getLatitude(), searchrequest.getLongitude(), searchrequest.getCategory(), 100, pageable);
        model.addAttribute("searchresults", searchresults);
        model.addAttribute("searchrequest", searchrequest);

        return "postlist";
    }
}
