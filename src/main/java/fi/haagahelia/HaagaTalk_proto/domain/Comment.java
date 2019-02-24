package fi.haagahelia.HaagaTalk_proto.domain;

import org.springframework.data.annotation.Id;

public class Comment {
	@Id
	private String commentId;
	
	private String courseCode;
	private String username;
	private String comment;
	
	public Comment() {}
	public Comment(String courseCode, String username, String comment) {
		this.courseCode = courseCode;
		this.username = username;
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return comment;
	}
	
	public String getCommentId() {
		return commentId;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public String getUsername() {
		return username;
	}
	public String getComment() {
		return comment;
	}
	
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
