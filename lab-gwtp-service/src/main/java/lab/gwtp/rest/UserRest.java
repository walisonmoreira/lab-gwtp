package lab.gwtp.rest;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lab.gwtp.domain.services.UserService;
import lab.gwtp.shared.ResourcePaths;
import lab.gwtp.shared.dto.UserVo;

@RestController
@RequestMapping(value = ResourcePaths.User.ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRest.class);

	private final UserService userService;

	@Autowired
	public UserRest(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Obter usuários.
	 */
	@RequestMapping(value = "/obterUsuarios", method = RequestMethod.GET)
	public List<UserVo> obterUsuarios() {
		LOGGER.debug("Executando serviço rest \"Obter Usuários\".");
		List<UserVo> r = new ArrayList<UserVo>();

		UserVo u = new UserVo("jose.maria", "123", true);
		r.add(u);

		u = new UserVo("maria.jose", "abs", true);
		u.setPassword("abc");

		r.add(u);
		LOGGER.debug("Serviço rest \"Obter Usuários\" executado.");
		return r;
	}

	/**
	 * serviço utilizado para saber se o usuário esta com sessão aberta
	 * 
	 * @return
	 */
	@RequestMapping(value = ResourcePaths.User.LOGIN, method = GET)
	ResponseEntity<Boolean> isCurrentUserLoggedIn() {
		return new ResponseEntity<>(userService.isCurrentUserLoggedIn(), OK);
	}

	/**
	 * serviço que retornar o usuário que esta logado
	 * 
	 * @return
	 */
	@RequestMapping(method = GET)
	ResponseEntity<UserVo> getCurrentUserLoggedIn() {
		User userLoggedIn = userService.getUserLoggedIn();
		UserVo userVo = new UserVo(userLoggedIn.getUsername(), userLoggedIn.getPassword(), userLoggedIn.isEnabled());
		return new ResponseEntity<>(userVo, OK);
	}

}