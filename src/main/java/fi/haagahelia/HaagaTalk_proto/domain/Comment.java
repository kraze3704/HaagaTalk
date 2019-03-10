package fi.haagahelia.HaagaTalk_proto.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comment")
public class Comment {
	
	@Id
	private String id;
	
    @Indexed(direction = IndexDirection.DESCENDING)
	private String courseId;
	private String username;
	private String comment;
	
	public Comment() {}
	public Comment(String courseId, String username, String comment) {
		this.courseId = courseId;
		this.username = username;
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return comment;
	}
	
	public String getId() {
		return id;
	}
	public String getCourseId() {
		return courseId;
	}
	public String getUsername() {
		return username;
	}
	public String getComment() {
		return comment;
	}
	
	public void setId(String commentId) {
		this.id = commentId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
