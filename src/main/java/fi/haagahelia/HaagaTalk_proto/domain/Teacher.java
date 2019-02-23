package fi.haagahelia.HaagaTalk_proto.domain;

import org.springframework.data.annotation.Id;

public class Teacher {
	@Id
	private String teacherId;
	private String firstName;
	private String lastName;
	
	public Teacher() {}
	public Teacher(String teacherId, String firstName, String lastName) {
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return firstName + ", " + lastName;
	}
	
	public String getTeacherId() {
		return teacherId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
