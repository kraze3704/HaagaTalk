package fi.haagahelia.HaagaTalk_proto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.HaagaTalk_proto.domain.Comment;
import fi.haagahelia.HaagaTalk_proto.domain.CommentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentRepositoryTest {

	@Autowired
	CommentRepository commentRepo;
	
	@Test
	public void newComment_Save_Check() {
		Comment comment = new Comment("courseid-test", "username.test", "test comment");
		commentRepo.save(comment);
		
		List<Comment> comments = commentRepo.findByCourseId("courseid-test"); 
		Comment fetchComment = comments.get(0);
		
		assertThat(fetchComment.getUsername()).isEqualTo("username.test");
	}
}
