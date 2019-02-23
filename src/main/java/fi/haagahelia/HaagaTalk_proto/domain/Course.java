package fi.haagahelia.HaagaTalk_proto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	@Id
	@Column(name="courseCode", nullable = false, updatable = false)
	private String courseCode;
	@Column(name="courseName", nullable = false)
	private String courseName;
	private Long teacherId;
	
	public Course() {}
	public Course(String courseCode, String courseName, Long teacherId) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.teacherId = teacherId;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public Long getTeacherId() {
		return teacherId;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	
	@Override
	public String toString() {
		return courseName + "(" + courseCode + ")"; 
	}
}
