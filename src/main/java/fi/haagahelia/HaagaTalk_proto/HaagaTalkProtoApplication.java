package fi.haagahelia.HaagaTalk_proto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fi.haagahelia.HaagaTalk_proto.domain.Comment;
import fi.haagahelia.HaagaTalk_proto.domain.CommentRepository;
import fi.haagahelia.HaagaTalk_proto.domain.Course;
import fi.haagahelia.HaagaTalk_proto.domain.CourseRepository;
import fi.haagahelia.HaagaTalk_proto.domain.Teacher;
import fi.haagahelia.HaagaTalk_proto.domain.TeacherRepository;
import fi.haagahelia.HaagaTalk_proto.domain.User;
import fi.haagahelia.HaagaTalk_proto.domain.UserRepository;

@SpringBootApplication
public class HaagaTalkProtoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private TeacherRepository teacherRepo;
	@Autowired
	private CommentRepository commentRepo;

	public static void main(String[] args) {
		SpringApplication.run(HaagaTalkProtoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		userRepo.deleteAll();
		// test user data
		userRepo.save(new User("guest", "guest"));
		userRepo.save(new User("admin", "admin", "ADMIN"));
		
		teacherRepo.deleteAll();
		// test teacher data
		Teacher juhaH = new Teacher("Juha", "Hinkula");
		teacherRepo.save(juhaH);
		teacherRepo.save(new Teacher("Kari", "Silpiö"));
		
			
		courseRepo.deleteAll();
		courseRepo.save(new Course("SWD4TF021-3002", "Server Programming", juhaH.getId()));
		courseRepo.save(new Course("SWD4TF023", "Software Development Technologies", juhaH.getId()));

		commentRepo.deleteAll();
		List<Course> testCourse1 = courseRepo.findByCourseName("Server Programming");
		List<Course> testCourse2 = courseRepo.findByCourseName("Software Development Technologies");
		User testUser1 = userRepo.findByUsername("admin");
		commentRepo.save(new Comment(testCourse1.get(0).getId(), testUser1.getUsername(), "test comment"));
		commentRepo.save(new Comment(testCourse2.get(0).getId(), "annoymous", "test comment"));
		*/
		
		// print all user data in db
		System.out.println("Users found with findAll()");
		System.out.println("------------------------------");
		for (User user : userRepo.findAll()) {
			System.out.println(user);
		}
		System.out.println("");
		// print all teacher data in db
		System.out.println("Teachers found with findAll()");
		System.out.println("------------------------------");
		for (Teacher teacher : teacherRepo.findAll()) {
			System.out.println(teacher);
		}
		System.out.println("");
		System.out.println("Courses found with findAll()");
		System.out.println("------------------------------");
		for (Course course : courseRepo.findAll()) {
			System.out.println(course);
		}
		System.out.println("");
	}
}
