package fi.haagahelia.HaagaTalk_proto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.HaagaTalk_proto.domain.User;
import fi.haagahelia.HaagaTalk_proto.domain.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired UserRepository userRepo;
	
	@Test
	public void newUser_noRolesGiven_save_check() {
		User user = new User("john.snow", "snow123");
		userRepo.save(user);
		
		User fetchUser = userRepo.findByUsername("john.snow");
		// if no role is given the role should be set to USER
		assertThat(fetchUser.getRole()).isEqualTo("USER");
	}
	
	@Test
	public void newUser_roleAdmin_save_check() {
		User admin = new User("pepega", "thisPassword", "ADMIN");
		userRepo.save(admin);
		
		assertThat(userRepo.findByUsername("pepega").getRole()).isEqualTo("ADMIN");
	}
}
