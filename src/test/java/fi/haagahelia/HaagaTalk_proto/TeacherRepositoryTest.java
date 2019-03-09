package fi.haagahelia.HaagaTalk_proto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.HaagaTalk_proto.domain.Teacher;
import fi.haagahelia.HaagaTalk_proto.domain.TeacherRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherRepositoryTest {

	@Autowired
	TeacherRepository teacherRepo;
	
	@Test
	public void newTeacher_Save_Check() {
		Teacher teacher = new Teacher("Pekka", "Kamaja");
		teacherRepo.save(teacher);
		
		List<Teacher> fetchTeacher = teacherRepo.findByFirstName("Pekka");
		assertThat(teacher.getLastName()).isEqualTo(fetchTeacher.get(0).getLastName());
	}
	
	@Test
	public void searchByFirstName_multiple_people() {
		
		// number of dummy data to be created and inserted into db
		Integer NUMBER = 3;
		
		for( Integer i = 0 ; i < NUMBER ; i++) {
			Teacher teacher = new Teacher(i.toString(), "Teacher");
			teacherRepo.save(teacher);
		}

		List<Teacher> fetchList = teacherRepo.findByLastName("Teacher");
		assertThat(NUMBER).isEqualTo(fetchList.size());
	}
}
