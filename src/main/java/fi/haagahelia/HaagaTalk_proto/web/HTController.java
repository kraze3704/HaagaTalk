package fi.haagahelia.HaagaTalk_proto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.HaagaTalk_proto.domain.Comment;
import fi.haagahelia.HaagaTalk_proto.domain.CommentRepository;
import fi.haagahelia.HaagaTalk_proto.domain.Course;
import fi.haagahelia.HaagaTalk_proto.domain.CourseRepository;
import fi.haagahelia.HaagaTalk_proto.domain.TeacherRepository;
import fi.haagahelia.HaagaTalk_proto.domain.User;
import fi.haagahelia.HaagaTalk_proto.domain.UserRepository;

@Controller
public class HTController {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	CourseRepository courseRepo;
	@Autowired
	TeacherRepository teacherRepo;
	@Autowired
	CommentRepository commentRepo;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("Courses", courseRepo.findAll());
		return "index";
	}
	
	@GetMapping("/admin")
	public String Admin(Model model) {

		model.addAttribute("COURSES", courseRepo.findAll());
		model.addAttribute("TEACHERS", teacherRepo.findAll());
		model.addAttribute("USERS", userRepo.findAll());
		
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
	public String courseCommentAdd(Comment comment, @RequestParam(name="error", required=false) String error) {
		// check if comment is available
		// if comment is empty, including comment with only spaces, reload page with error param added
		if(comment.getComment().trim().isEmpty()) {
			return "redirect:/" + comment.getCourseId() + "?error";
		} else {
			commentRepo.save(comment);
			return "redirect:/" + comment.getCourseId();
		}
	}
	
	@GetMapping("/{courseId}/delete/{id}")
	public String commentDelete(@PathVariable("id") String id, @PathVariable("courseId") String courseId) {
		commentRepo.deleteById(id);
		return "redirect:/" + courseId;
	}
	
	@GetMapping("/{courseId}/edit/{id}")
	public String commentEdit(@PathVariable("id") String id, @PathVariable("courseId") String courseId, Model model) {
		// optional<T> again, need to find a different method
		// model.addAttribute("COMMENT", commentRepo.findById(id));
		
		// commentRepo.findById(id).ifPresent(COMMENT -> model.addAttribute("COMMENT", COMMENT));
		// attempts to fetch requested comment and save to model
		
		// fetch Optional<C> from db
		Optional<Comment> checkComment = commentRepo.findById(id);
		
		// first check: is the comment available
		if(checkComment.isPresent()) {
			// get comment object from Optional object and add to model
			Comment currentComment = checkComment.get();
			model.addAttribute("COMMENT", currentComment);
			
			// get current username
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String currentUser = auth.getName();
			// System.out.println(currentUser);
			
			/* no reason to allow mods to edit all comments?
			// check if current user is admin :: currentUser == "admin" doesn't work here!
			if(currentUser.equals("admin")) {
				return "commentEdit";
			} else {
				// fetch the author of the comment for validation
				String commentAuthor = currentComment.getUsername();
				// if authors match render edit page, else render error page
				return currentUser.equals(commentAuthor) ? "commentEdit" : "errorPage";
			}
			*/
			
			// fetch the author of the comment for validation
			String commentAuthor = currentComment.getUsername();
			// if authors match render edit page, else render error page
			return currentUser.equals(commentAuthor) ? "commentEdit" : "errorPage";
			
		} else {
			// error case: comment doesn't exist
			return "EditErrorPage";
		}
		
		// return model.containsAttribute("COMMENT") ? "commentEdit" : "errorPage";
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
