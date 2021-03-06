package fi.haagahelia.HaagaTalk_proto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.haagahelia.HaagaTalk_proto.domain.User;
import fi.haagahelia.HaagaTalk_proto.domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	private final UserRepository repository;

	@Autowired
	public UserDetailServiceImpl(UserRepository userRepo) {
		this.repository = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User currUser = repository.findByUsername(username);
		
		UserDetails user = new org.springframework.security.core.userdetails.User(username, currUser.getPassword(),
				AuthorityUtils.createAuthorityList(currUser.getRole()));
		
		return user;
	}
}
