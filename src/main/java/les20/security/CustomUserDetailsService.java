package les20.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import les20.dao.UserRepo;
import les20.dao.UserRolesRepo;
import les20.domain.User;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	
	private final UserRepo userRepo;
	private final UserRolesRepo userRolesRepo;
	
	@Autowired
	public CustomUserDetailsService(UserRepo userRepo, UserRolesRepo userRolesRepo) {
		this.userRepo = userRepo;
		this.userRolesRepo = userRolesRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepo.findByUserName(userName);
		if(user == null)
			throw new UsernameNotFoundException("There are no user with such user name:" + userName);
		else {
			List<String> userRoles = userRolesRepo.findRoleByUserName(userName);
			return new CustomUserDetails(user, userRoles);
		}
	}

}
