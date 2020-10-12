package com.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Business.UserBusinessInterface;
import com.Models.User;

@Controller 
//@RequestMapping("/user")
public class UserController {
	//SpringBean declaration
	UserBusinessInterface service;
	
	/**
	 * Method to set the bean
	 * @param interface that the methods will refer to 
	 */
	public void setUserService(UserBusinessInterface service) {
	this.service = service;
	}

	
	/**
	 * This method will display the registrationPage
	 * @return registrationPage
	 */
		@RequestMapping(path="/register", method = RequestMethod.GET) 
		public ModelAndView displayRegistrationPage() { 
			return new ModelAndView("registrationPage", "user", new User(0,"",""));
			}
	/**
	 * This method will carry out the user registration by sending the validated user to the business service
	 * @param new user with needed attributes
	 * @param binding result
	 * @return loginPage, if the registration was successful; registrationPage with errors displayed, if unsuccessful
	 */
		@RequestMapping(path="/registerSuccess", method = RequestMethod.POST)
		public ModelAndView registerUser(@Valid @ModelAttribute("user") User user, BindingResult result) { 
			//Temporary 
			System.out.println("Entering UserController.registerUser()");
			//validate the form 
			if(!result.hasErrors()) { 
				
				try {
					service.register(user); 

					//return to the home page to show that login was successful
					return new ModelAndView("loginPage", "user", user); 
				}
				catch (Exception e) {
					//create a ModelAndView 
					ModelAndView mv = new ModelAndView("errorPage"); 
					
					//create a string message for the errorPage 
					String err = "ERROR: " + e.getMessage();
							
					//create new object to output the error
					mv.addObject("error", err); 
							
					//return to create event form page to show the connection error
					return mv; 
				}
			}
			//return to login form to show login errors
			return new ModelAndView("registrationPage", "user", user); 
		}
		
	/**
	 * This method will display the loginPage
	 * @return loginPage
	 */
		@RequestMapping(path="/login", method = RequestMethod.GET) 
		public ModelAndView displayLoginPage() { 
			return new ModelAndView("loginPage", "user", new User());
			}
		  
	/**
	 * This method will carry out the user login by sending the validated user to the business service & creating a session with the user object
	 * @param returning user with attributes of username and password
	 * @param binding result
	 * @param session variable as it wil help the user stay logged in 
	 * @return homePage, if the registration was successful; loginPage with errors displayed, if unsuccessful
	 */
		@RequestMapping(path="/loginSuccess", method = RequestMethod.POST)
		public ModelAndView loginUser(@ModelAttribute("user") User user, BindingResult result, HttpSession session) { 
			//Temporary 
			System.out.println("Entering UserController.loginUser()");
			//validate the form 
			if(!result.hasErrors()) { 
				//user is shown error message if login failed
				
				try {
					if (service.login(user) == null) {
						ObjectError error = new ObjectError("*", "Invalid username or password");
						result.addError(error);
					}
					else {
						//set session
						session.setAttribute("user", user);
						//return to the home page to show that login was successful
						return new ModelAndView("homePage", "user", user); 
					}
				} catch (Exception e) {
					//create a ModelAndView 
					ModelAndView mv = new ModelAndView("errorPage"); 
							
					//create a string message for the errorPage 
					String err = "ERROR: " + e.getMessage();
							
					//create new object to output the error
					mv.addObject("error", err); 
							
					//return to create event form page to show the connection error
					return mv; 
				}
				
			}
			//return to login form to show login errors
			return new ModelAndView("loginPage", "user", user); 
		}
		
	/**
	 * This method will carry out the user logout by destroying the session
	 * @param session variable as it will help the user to log out 
	 * @return homePage
	 */
		@RequestMapping(path="/logout", method = RequestMethod.GET) 
		public ModelAndView logout(HttpSession session) {
			//remove user attribute
			session.removeAttribute("user");
			//return to home page
			return new ModelAndView("homePage");
		}
}