package fi.haagahelia.HaagaTalk_proto.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HTController {

	@GetMapping("/index")
	public String index() {
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
