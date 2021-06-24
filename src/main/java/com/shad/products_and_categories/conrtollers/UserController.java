package com.shad.products_and_categories.conrtollers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shad.products_and_categories.models.User;
import com.shad.products_and_categories.services.UserService;
import com.shad.products_and_categories.validator.UserValidator;

@Controller
public class UserController {

	private final UserService userSvc;
	
    // NEW
    private final UserValidator userValidator;
	 
	public UserController(UserService userSvc, UserValidator userValidator) {
	     this.userSvc = userSvc;
	     this.userValidator = userValidator;
	}
	
	
	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user) {
	    return "redirect:/register";
	}
	
	
	@RequestMapping("/register")
	public String showRegistrationForm(@ModelAttribute("user") User user) {
	    return "/users/registration.jsp";
	}
	
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, 
								BindingResult result, HttpSession session) {
	    // if result has errors, return the registration page (don't worry about validations just now)
	    // else, save the user in the database, save the user id in session, and redirect them to the /home route
		
        userValidator.validate(user, result);
		
		if(result.hasErrors()) {
			return "/users/registration.jsp";
        } else {
        	User currentUser = userSvc.registerUser(user);
        	session.setAttribute("userId", currentUser.getId());
			return "redirect:/home";
        }
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
	    // get user from session, save them in the model and redirect to /products/add
		Long uuid = (Long) session.getAttribute("userId");
		User currentUser = userSvc.findUserById(uuid);
		model.addAttribute("user", currentUser);
		return "redirect:/dashboard";
	}
	 
	
	@RequestMapping("/login")
	public String login() {
		return "/users/login.jsp";
	}

	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, 
							@RequestParam("password") String password, 
							Model model, 
							HttpSession session) {
	    // if the user is authenticated, save their user id in session
	    // else, add error messages and return the login page
		if (userSvc.authenticateUser(email, password)) {
			User currentUser = userSvc.findByEmail(email);
			session.setAttribute("userId",  currentUser.getId());
			return "redirect:/home";		
		} else {
			model.addAttribute("error", "Invalid credentails. Please try again");
			return "/users/login.jsp";
		}
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
	    // invalidate session
		session.invalidate();
	    // redirect to login page
		return "redirect:/login";
	}
	
}

