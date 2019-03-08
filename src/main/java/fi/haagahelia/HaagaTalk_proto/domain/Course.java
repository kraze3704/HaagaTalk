package fi.haagahelia.HaagaTalk_proto.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="course")
public class Course {
	
	@Id
	private String id;
	
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
	private String courseCode;
	private String courseName;
	
	private String teacherId;
	
	public Course() {}
	public Course(String courseCode, String courseName, String teacherId) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.teacherId = teacherId;
	}

	public String getId() {
		return id;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public String getTeacherId() {
		return teacherId;
	}
	
	public void setId(String courseId) {
		this.id = courseId;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	@Override
	public String toString() {
		return courseName + "(" + courseCode + ")"; 
	}
}
