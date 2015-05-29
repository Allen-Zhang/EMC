package com.mercury.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ModelAndView processUser(@RequestBody User user)   {
/*		User user1 = new User();
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
		}*/
/*		String username = user.getUsername();
		String passwaor = user.getPassword();*/
		User user1 = new User();
		user1.setUsername("allen");
		user1.setPassword("allen");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Error");
		mav.addObject("title", "Hello, the username is existed");
		if(us.checkUser(user1.getUsername())!= null){
			return mav;
		}else{
			us.saveUser(user1);
			mav.setViewName("Thanks for your registeration");
			mav.addObject("title", "Hello, the username is OK");
			return mav;
		}
	}
	

}
