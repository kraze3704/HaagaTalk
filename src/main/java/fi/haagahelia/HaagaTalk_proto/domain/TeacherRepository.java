package fi.haagahelia.HaagaTalk_proto.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
	public List<Teacher> findAll();
	
	public List<Teacher> findByFirstName(String firstName);
	public List<Teacher> findByLastName(String lastName);
	public Teacher findByTeacherId(String teacherId);
}
