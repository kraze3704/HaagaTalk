package fi.haagahelia.HaagaTalk_proto.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
	public List<Course> findAll();
	
	public Optional<Course> findById(String id);
	public Course findByCourseCode(String courseCode);
	public List<Course> findByCourseName(String courseName);
	public List<Course> findByTeacherId(String teacherId);
}
