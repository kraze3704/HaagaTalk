package fi.haagahelia.HaagaTalk_proto.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.HaagaTalk_proto.domain.Comment;
import fi.haagahelia.HaagaTalk_proto.domain.CommentRepository;
import fi.haagahelia.HaagaTalk_proto.domain.Course;
import fi.haagahelia.HaagaTalk_proto.domain.CourseRepository;
import fi.haagahelia.HaagaTalk_proto.domain.User;
import fi.haagahelia.HaagaTalk_proto.domain.UserRepository;

@Controller
public class HTController {
	
	@Autowired
	CourseRepository courseRepo;
	@Autowired
	CommentRepository commentRepo;
	@Autowired
	UserRepository userRepo;

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
	
	@GetMapping("/{courseId}")
	public String courseCommentPage(@PathVariable("courseId") String courseId, Model model) {
		
		// Optional<T> has to be unwrapped before being passed to View
		courseRepo.findById(courseId).ifPresent(Course -> model.addAttribute("Course", Course));
		// model.addAttribute("Course", courseRepo.findById(courseId));
		model.addAttribute("Comments", commentRepo.findByCourseId(courseId));
		model.addAttribute("COMMENT", new Comment());
		return "courseComments";
	}
	
	@PostMapping("/addComment")
	public String courseCommentAdd(Comment comment) {
		commentRepo.save(comment);
		return "redirect:" + comment.getCourseId();
	}
	
	@GetMapping("/{courseId}/delete/{id}")
	public String commentDelete(@PathVariable("id") String id, @PathVariable("courseId") String courseId) {
		commentRepo.deleteById(id);
		return "redirect:/" + courseId;
	}
	
	@GetMapping("/admin/rest/users")
	public @ResponseBody List<User> userListREST() {
		return userRepo.findAll();
	}
	
	@GetMapping("/admin/rest/courses")
	public @ResponseBody List<Course> courseListREST() {
		return courseRepo.findAll();
	}
	
	@GetMapping("/admin/rest/comments")
	public @ResponseBody List<Comment> commentListREST() {
		return commentRepo.findAll();
	}
}
