package fi.haagahelia.HaagaTalk_proto.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	public List<User> findAll();
	public User findByUsername(String username);
}
