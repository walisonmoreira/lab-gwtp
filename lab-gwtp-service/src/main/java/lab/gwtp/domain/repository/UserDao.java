package lab.gwtp.domain.repository;

import java.util.ArrayList;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	private static final String USER_TEST = "root";
	private static final String PASSWORD_TEST = "password";
	private final User user;

	public UserDao() {
		user = new User(USER_TEST, new ShaPasswordEncoder().encodePassword(PASSWORD_TEST, null), new ArrayList<>());
	}

	public User getUserByUsernanme(String username) {

		if (username.equals(USER_TEST)) {
			

			// List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			// List<String> permissions = userService.getPermissions(user.getLogin());
			// for (String permission : permissions) {
			// grantedAuthorities.add(new SimpleGrantedAuthority(permission));
			// }
			
			return user;
		} else {
			return null;
		}
	}

}
