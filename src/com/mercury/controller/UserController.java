package com.mercury.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mercury.bean.User;
import com.mercury.service.UserService;;

@Controller
@SessionAttributes
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService us;
	@RequestMapping(value="/account/signup", method = RequestMethod.GET)
	public String accountPage(){
		return "/account/signup";
	}
	@RequestMapping(value = "/account/register", method = RequestMethod.POST)	
	@ResponseBody
	/*public ModelAndView processUser(HttpServletRequest request)   {
		User user1 = new User();
		user1.setUsername("freddie");
		user1.setPassword("freddie");
		UserDaoImpl udi = new UserDaoImpl();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Error");
		mav.addObject("title", "Hello, the username is existed");
		if(udi.findByUserName(user1.getUsername())!= null){
			return mav;
		} else{
			udi.save(user1);
			mav.setViewName("");
			mav.addObject("title", "Hello, the username is OK");
			return mav;
		}
		User user1 = new User();
		user1.setUsername("allen");
		user1.setPassword("allen");
		System.out.println("abc: "+user.getUsername());
		System.out.println("bb: "+user.getPassword());
		System.out.println("cc: "+user.getEmail());
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		ModelAndView mav = new ModelAndView();
		// Duplicates
		if(us.checkUser(user.getUsername())!= null){
			mav.setViewName("signup");
			mav.addObject("message", "Hello, the username is existed");
			return mav;
		// Success
		}else{
			us.saveUser(user);
			// send email here....
			mav.setViewName("home");
			mav.addObject("message", "Hello, the username is OK");
			return mav;
		}
	}*/
	public ModelAndView processUser(@ModelAttribute("user") User user, BindingResult result)   {
				ModelAndView mav = new ModelAndView();
				// Duplicates
				if(us.checkUser(user.getUsername())!= null){
					mav.setViewName("signup");
					mav.addObject("message", "Hello, the username is existed");
					return mav;
				// Success
				}else{
					us.saveUser(user);
					// send email here....
					mav.setViewName("home");
					mav.addObject("message", "Hello, the username is OK");
					return mav;
				}
	}
	
	@RequestMapping(value = "/account/update", method = RequestMethod.GET)	
	@ResponseBody
	public ModelAndView updatePassword()   {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("update");
		mav.addObject("message", "Hello, the user password is updated");
		return mav;
		
	}
}
