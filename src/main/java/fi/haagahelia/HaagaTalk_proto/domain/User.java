package fi.haagahelia.HaagaTalk_proto.domain;

import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class User {

	@Id
	private String id;
	
	private String username;
	private String password;
	private String role;
	
	public User() {}
	public User(String username, String password) {
		this.username = username;
		setPassword(password);
		this.role = "USER";
	}
	public User(String username, String password, String role) {
		this.username = username;
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
	
	public void setId(String id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		String encoded = new BCryptPasswordEncoder().encode(password);
		this.password = encoded;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
