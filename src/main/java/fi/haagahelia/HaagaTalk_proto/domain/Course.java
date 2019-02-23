package fi.haagahelia.HaagaTalk_proto.domain;

import org.springframework.data.annotation.Id;

public class Course {
	@Id
	private String courseCode;
	private String courseName;
	private String teacherId;
	
	public Course() {}
	public Course(String courseCode, String courseName, String teacherId) {
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
	public String getTeacherId() {
		return teacherId;
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
