package lab.gwtp.domain.services;

import org.springframework.security.core.userdetails.User;

public interface UserService {

	User getUserByUsername(String username);

	User getUserLoggedIn();

	boolean isCurrentUserLoggedIn();
}
