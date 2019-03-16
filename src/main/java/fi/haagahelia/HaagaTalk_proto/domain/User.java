package fi.haagahelia.HaagaTalk_proto.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Document(collection = "user")
public class User {

	@Id
	private String id;
	
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
	private String username;
	private String password;
	private String PWDecoded;
	private String role;
	
	public User() {}
	public User(String username, String password) {
		this.username = username;
		this.PWDecoded = password;
		setPassword(password);
		this.role = "USER";
	}
	public User(String username, String password, String role) {
		this.username = username;
		this.PWDecoded = password;
		setPassword(password);
		this.role = role;
	}
	
	@Override
	public String toString() {
		return username;
	}
	
	public String getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getRole() {
		return role;
	}
	public String getPWDecoded() {
		return PWDecoded;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.PWDecoded = password; // store password before encoding :: other solutions?
		String encoded = new BCryptPasswordEncoder().encode(password);
		this.password = encoded;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setPWDecoded(String password_de) {
		this.PWDecoded = password_de;
	}
	
}
