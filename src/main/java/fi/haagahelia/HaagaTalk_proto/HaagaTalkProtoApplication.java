package fi.haagahelia.HaagaTalk_proto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fi.haagahelia.HaagaTalk_proto.domain.User;
import fi.haagahelia.HaagaTalk_proto.domain.UserRepository;

@SpringBootApplication
public class HaagaTalkProtoApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(HaagaTalkProtoApplication.class, args);
	}
	
	@Override
	public void run(String ...args) throws Exception {
		userRepo.deleteAll();
		
		// test user data
		userRepo.save(new User("guest", "guest"));
		userRepo.save(new User("admin", "admin", "ADMIN"));
		
		// fetch all customers
		System.out.println("Customers found with findAll()");
		System.out.println("------------------------------");
		for ( User user : userRepo.findAll()) {
			System.out.println(user);
		}
		System.out.println("------------------------------");
	}
}
