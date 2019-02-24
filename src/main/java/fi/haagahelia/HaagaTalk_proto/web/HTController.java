package fi.haagahelia.HaagaTalk_proto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fi.haagahelia.HaagaTalk_proto.domain.CourseRepository;

@Controller
public class HTController {
	
	@Autowired
	CourseRepository courseRepo;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("Courses", courseRepo.findAll());
		return "index";
	}
	
	@GetMapping("/admin")
	public String Admin() {
		return "admin";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
