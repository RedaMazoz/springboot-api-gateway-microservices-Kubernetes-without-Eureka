package ma.quantorion.appquitue.apigateway.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	public UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		User user = userRepository.findByEmail(email);
		if(user == null)
		{
			throw new UsernameNotFoundException("no user registred with the email " + email);
		}
		else {
			return new UserDetailsImpl(user);
		}
	}

}
