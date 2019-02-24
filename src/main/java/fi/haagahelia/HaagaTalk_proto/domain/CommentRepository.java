package fi.haagahelia.HaagaTalk_proto.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
	public List<Comment> findAll();
	
	public Comment findByCommentId(String commentId);
	public List<Comment> findByCourseCode(String courseCode);
	public List<Comment> findByUsername(String username);	
}
