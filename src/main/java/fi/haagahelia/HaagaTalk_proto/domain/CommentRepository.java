package fi.haagahelia.HaagaTalk_proto.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
	public List<Comment> findAll();
	
	public Optional<Comment> findById(String commentId);
	public List<Comment> findByCourseId(String courseId);
	public List<Comment> findByUsername(String username);	
}
