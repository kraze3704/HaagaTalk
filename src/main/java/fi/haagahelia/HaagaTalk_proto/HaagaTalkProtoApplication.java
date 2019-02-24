package fi.haagahelia.HaagaTalk_proto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	public static void main(String[] args) {
		SpringApplication.run(HaagaTalkProtoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		userRepo.deleteAll();
		// test user data
		userRepo.save(new User("guest", "guest"));
		userRepo.save(new User("admin", "admin", "ADMIN"));

		// print all user data in db
		System.out.println("Users found with findAll()");
		System.out.println("------------------------------");
		for (User user : userRepo.findAll()) {
			System.out.println(user);
		}
		System.out.println("");

		teacherRepo.deleteAll();
		// test teacher data
		Teacher juhaH = new Teacher("Juha", "Hinkula");
		teacherRepo.save(juhaH);
		teacherRepo.save(new Teacher("Kari", "Silpiö"));

		// print all teacher data in db
		System.out.println("Teachers found with findAll()");
		System.out.println("------------------------------");
		for (Teacher teacher : teacherRepo.findAll()) {
			System.out.println(teacher);
		}
		System.out.println("");

		courseRepo.deleteAll();
		courseRepo.save(new Course("SWD4TF021-3002", "Server Programming", juhaH.getTeacherId()));
		System.out.println("Courses found with findAll()");
		System.out.println("------------------------------");
		for (Course course : courseRepo.findAll()) {
			System.out.println(course);
		}
		System.out.println("");
	}
}
