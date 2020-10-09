package io.minimalistic.controllers;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import io.minimalistic.models.User;
import io.minimalistic.services.LoginService;
import io.minimalistic.services.UserRegistrationService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private UserRegistrationService registerService;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public ModelAndView homePage(@ModelAttribute("success") String success,@ModelAttribute("loginError") String loginError,ModelMap map)
	{
		if(!success.isEmpty())
		{
			map.addAttribute("success", success);
		}
		if(!loginError.isEmpty())
		{
			map.addAttribute("loginError", loginError);
		}
		return new ModelAndView("login", "user", new User());
	}
	
	@RequestMapping(value = "/signUp", method=RequestMethod.GET)
	public ModelAndView getSignUpPage(@ModelAttribute("error") String error, ModelMap map, Model model, BindingResult bindingResults)
	{
		if(!error.isEmpty())
		{
			map.addAttribute("error", error);
		}
		if(model.containsAttribute("user"))
		{
			System.out.println("inside model if"+model.toString());
			return new ModelAndView("signUp");
		}
		
			return new ModelAndView("signUp", "user", new User());
	}
	
	@RequestMapping(value = "/logincheck", method=RequestMethod.POST)
	public RedirectView login(@ModelAttribute User user, RedirectAttributes rattri, HttpSession session)
	{
		
		boolean flag=loginService.checkUserExists(user.getUsername(),user.getPassword());
		if(!flag)
		{
			rattri.addFlashAttribute("loginError", "Invalid Username or password");
			return new RedirectView("/login", true);
			
		}
			
		session.setAttribute("username", user.getUsername());
		 return new RedirectView("/home", true);
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public RedirectView registerUser(@ModelAttribute("user") @Valid User user,BindingResult bindingResults, RedirectAttributes rattri)
	{
		System.out.println("method register");
		if (bindingResults.hasErrors()) {
			rattri.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResults);
			rattri.addFlashAttribute("user", user);
			return new RedirectView("/signUp", true);
		}
		else if (registerService.register(user))
			{
							
				rattri.addFlashAttribute("success", "User Registered Successfully");
				return new RedirectView("/login", true);
			}
			
			  else 
			  { 
				  System.out.println("else");
				  rattri.addFlashAttribute("error", "Please enter the valid inputs");
				  return new RedirectView("/signUp", true);
			  //return new
			  //ModelAndView("redirect:/signUp", map); 
			  }
			 
		
	}
}
