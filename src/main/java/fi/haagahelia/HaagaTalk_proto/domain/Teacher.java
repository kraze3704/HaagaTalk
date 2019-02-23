package fi.haagahelia.HaagaTalk_proto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="teacherId", nullable = false, updatable = false)
	private Long teacherId;
	@Column(name="firstName", nullable = false)
	private String firstName;
	private String lastName;
	
	public Teacher() {}
	public Teacher(Long teacherId, String firstName, String lastName) {
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return firstName + ", " + lastName;
	}
	
	public Long getTeacherId() {
		return teacherId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
