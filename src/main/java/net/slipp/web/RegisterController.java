package net.slipp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.slipp.domain.User;
import net.slipp.domain.UserRepository;

@Controller
public class RegisterController {
	//private List<User> users = new ArrayList<User>();
	@Autowired
	private UserRepository userRepository;
	@GetMapping("/registerform")
	public String registerform() {
		return "registerform";
	}	

	@PostMapping("/register")
	public String register(User user, Model model) {
		
		//System.out.println("User : " + user);
		//users.add(user);	
		//model.addAttribute("users", users);
		userRepository.save(user);
		return "redirect:/user_list";
	}	
	@GetMapping("/user_list")
	public String user_list(Model model) {
		model.addAttribute("users", userRepository.findAll());		
		return "user_list";
	}
}
