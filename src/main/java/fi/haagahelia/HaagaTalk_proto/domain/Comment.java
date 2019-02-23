package fi.haagahelia.HaagaTalk_proto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="commentId", nullable = false, updatable = false)
	private Long commentId;
	@Column(name="courseCode", nullable = false)
	private String courseCode;
	@Column(name="username", nullable = false)
	private String username;
	private String comment;
	
	public Comment() {}
	public Comment(Long commentId, String courseCode, String username, String comment) {
		this.commentId = commentId;
		this.courseCode = courseCode;
		this.username = username;
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return comment;
	}
	
	public Long getCommentId() {
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
	
	public void setCommentId(Long commentId) {
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
