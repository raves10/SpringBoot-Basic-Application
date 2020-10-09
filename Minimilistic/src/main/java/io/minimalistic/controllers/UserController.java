package io.minimalistic.controllers;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import io.minimalistic.models.Posts;
import io.minimalistic.services.LoginService;
import io.minimalistic.services.PostService;


@Controller
public class UserController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/addPost", method=RequestMethod.GET)
	public ModelAndView addPost()
	{
		return new ModelAndView("addPost", "userpost", new Posts());
	}
	
	@RequestMapping(value = "/editPost", method=RequestMethod.POST)
	public RedirectView editProfile(@RequestParam("description")String description, @RequestParam("pid") String pid)
	{
		System.out.println(description + pid);
		postService.editPost(Integer.parseInt(pid), description);
		return new RedirectView("/home",true);
	}
	
	
	
	@RequestMapping(value = "/deletePost", method=RequestMethod.POST)
	public RedirectView deletePost(@RequestParam("id") String id)
	{
		boolean flag=postService.deletePost(Integer.parseInt(id));
		return new RedirectView("/home",true);
		
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
		public RedirectView post(@ModelAttribute Posts userpost, HttpSession session)
	{
		System.out.println(session.getAttribute("username"));
		int id = loginService.findByUserName((String) session.getAttribute("username"));
		System.out.println(id);
		if(id !=0)
		{
			userpost.setUserId(id);
		}
		
        long millis=System.currentTimeMillis();  
        Date date= new Date(millis);
		userpost.setTime(date);
		//java.sql.Date
		boolean flag=postService.addPost(userpost);
		return new RedirectView("/home",true);
	}
	
	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public ModelAndView getUserHomePage(HttpSession session, ModelMap map)
	{
		int id = loginService.findByUserName((String) session.getAttribute("username"));
		List<Posts> posts = postService.getLoggedInUserPosts(id);
		map.addAttribute("posts", posts);
		return new ModelAndView("userHome");
	}
	
	
	
}
