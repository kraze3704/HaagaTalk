package fi.haagahelia.HaagaTalk_proto.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teacher")
public class Teacher {
	
	@Id
	private String id;
	
    @Indexed(direction = IndexDirection.DESCENDING)
	private String firstName;
	private String lastName;
	
	public Teacher() {}
	public Teacher(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return firstName + ", " + lastName;
	}
	
	public String getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setId(String teacherId) {
		this.id = teacherId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
