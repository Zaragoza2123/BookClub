package com.codingdojo.service;


import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
    
import com.codingdojo.models.LoginUser;
import com.codingdojo.models.User;
import com.codingdojo.repository.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    public static Boolean IsLoggedIn(HttpSession session)
	{
		return session.getAttribute("user_id")!=null;
	}
	
	public String Logout(HttpSession session)
	{
		if(!IsLoggedIn(session)) return "redirect:/";
		session.removeAttribute("user_id");
		session.removeAttribute("user_name");
		return "redirect:/";
	}
	
	public static String Deny()
	{
		return "user_deny";
	}

	public void Create(User user)
	{
		userRepo.save(user);
	}

	public User FindByEmail(String email)
	{
		return userRepo.findByEmail(email);
	}
    
    // TO-DO: Write register and login methods!
    public User register(User user, BindingResult result) {

		User existing_user=userRepo.findByEmail(user.getEmail());
		int errors=0;
		if(existing_user!=null)
		{
			result.rejectValue("email","email_invalid","Email is in use.");
			errors++;
		}
		if(!user.getPassword().equals(user.getConfirm()))
		{
			result.rejectValue("password","password_mismatch","Password and Password Confirmation must match!");
			errors++;
		}
		if(errors>0) return null;
		String hashed_pw=BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(8));
		user.setPassword(hashed_pw);
		userRepo.save(user);
		return user;
    }
    public User login(
    		LoginUser user,
    		BindingResult result,
    		HttpSession session
    	)
    	{
    		User db_user=userRepo.findByEmail(user.getEmail());
    		int errors=0;
    		if(db_user==null)
    		{
    			result.rejectValue("email","invalid_email","Email not found.");
    			errors++;
    		}
    		if(db_user!=null)
    		{
    			Boolean match=BCrypt.checkpw(user.getPassword(),db_user.getPassword());
    			if(!match)
    			{
    				result.rejectValue("password","invalid_password","Invalid Password");
    				errors++;
    			}
    		}
    		if(errors>0) return null;
    		session.setAttribute("user_id",db_user.getId());
    		session.setAttribute("user_name",db_user.getUserName());
    		return db_user;
    	}	
    
}
