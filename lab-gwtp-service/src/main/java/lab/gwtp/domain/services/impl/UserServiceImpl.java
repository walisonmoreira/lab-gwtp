package lab.gwtp.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;

import lab.gwtp.config.security.UserDetailsImpl;
import lab.gwtp.domain.repository.UserDao;
import lab.gwtp.domain.services.UserService;
import lab.gwtp.shared.util.Validacao;

@Service
class UserServiceImpl implements UserService {

	private final UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userdao) {
		this.userDao = userdao;
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsernanme(username);
	}

	@Override
	public User getUserLoggedIn() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null) {
			throw new SessionAuthenticationException("Não existe usuário logado");
		}

		Object principal = authentication.getPrincipal();

		// principal can be "anonymousUser" (String)
		if (!(principal instanceof UserDetailsImpl)) {
			throw new SessionAuthenticationException("Não existe usuário logado");
		}

		UserDetailsImpl userDetails = (UserDetailsImpl) principal;

		return userDetails.getUser();
	}

	@Override
	public boolean isCurrentUserLoggedIn() {
		try {
			return Validacao.nonNull(this.getUserLoggedIn());
		} catch (Exception e) {
			return false;
		}
	}
}
