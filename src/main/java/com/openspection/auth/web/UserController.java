package com.openspection.auth.web;

import com.openspection.auth.model.User;
import com.openspection.auth.service.SecurityService;
import com.openspection.auth.service.UserService;
import com.openspection.auth.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute("pageTitle", "Create a new registration.");

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Create a new registration.");

            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        model.addAttribute("pageTitle", "Log in with your account.");

        return "login";
    }

    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        model.addAttribute("pageTitle", "Welcome to your profile.");
        return "welcome";

    }
    @RequestMapping(value = "/users/search", method = RequestMethod.GET)
    public String searchforusers(Model model,
	@RequestParam("keywords") String keywords,
	@RequestParam(value="category_id", required=false) Integer categoryId) {

	System.out.println("Keywords: " + keywords + " Category: " + categoryId);
	User user = new User();
	user.setUsername(keywords);

	List<User> searchresults = userService.findUsers(user);

//	ExampleMatcher matcher = ExampleMatcher.matchingAny();

//        Example<User> searchresults = Example.of(user, matcher);
        model.addAttribute("searchresults", searchresults);
//        model.addAttribute("pageTitle", "List the posts for " + username);

        return "searchresults";
    }
}
