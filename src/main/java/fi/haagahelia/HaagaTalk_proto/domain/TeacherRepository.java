package fi.haagahelia.HaagaTalk_proto.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
	public List<Teacher> findAll();
	
	public List<Teacher> findByFirstName(String firstName);
	public List<Teacher> findByLastName(String lastName);
	public Optional<Teacher> findById(String teacherId);
}
