package com.codingdojo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.models.Book;
import com.codingdojo.models.LoginUser;
import com.codingdojo.models.User;
import com.codingdojo.service.BookService;
import com.codingdojo.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private BookService bookService;
	private UserService userService;
	
	public HomeController(UserService userService)
	{
		this.userService=userService;
	}
	
	@GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newuser", new User());
        model.addAttribute("user", new LoginUser());
        return "index";
        
   
    }	
	@PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newuser") User user, 
	            BindingResult result, Model model, HttpSession session) {
	        
		 if(result.hasErrors()) {
			 model.addAttribute("user", new LoginUser());
			 return "index";
		 }
			User errors=userService.register(user,result);
			if(errors==null) return "/";
	        return "redirect:/home";
	 }
	 @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("user") LoginUser user, 
	            BindingResult result, Model model, HttpSession session) {
			if(result.hasErrors()) {
				model.addAttribute("newuser", new User());
				return "index";
			}
			User db_user=userService.login(user,result,session);
			if(db_user==null) return "/";
			return "redirect:/home";
	    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	userService.Logout(session);
    	return "redirect:/";
    
    }
	@GetMapping("/home")
	public String home(HttpSession session, Model model)
	{
		model.addAttribute("books", bookService.FindAll());
		model.addAttribute("userName", session.getAttribute("user_name"));
		return  "home";
	}
	@GetMapping("/books/{id}")
	public String bookDetails(Model model,@PathVariable("id") Long id, HttpSession session) {
		model.addAttribute("book",bookService.FindOne(id));
		Book one = bookService.FindOne(id);
		Long userId = (Long) session.getAttribute("user_id");
		Long adder = one.getUser().getId();
		System.out.println(userId);
		System.out.println(adder);
		if(userId != adder) {
			return "show_book";
		} else {
		return "your_book";
		}
		}
	@GetMapping("/edit/{id}")
	public String send_edit( Model model, @PathVariable("id") Long id)
	{
		model.addAttribute("book",bookService.FindOne(id));
		return "edit_book";
	}
	@PostMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute("book") Book book,BindingResult result,@PathVariable("id") Long id,Model model) {
		
		if (result.hasErrors()) {
			return "edit_book";
			
		}
		
		bookService.Update(book);
		return"redirect:/home";
	}
	
	@GetMapping("/book")
	public String bookPage(Model model) {
		model.addAttribute("newBook", new Book());
		return "add_book";
	}
	@PostMapping("/book")
	public String add_book(@Valid @ModelAttribute("newBook") Book book, 
	            BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add_book";
		}
			bookService.Create(book);
		return "redirect:/home";
	}

}

