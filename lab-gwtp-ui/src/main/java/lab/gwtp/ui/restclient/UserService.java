package lab.gwtp.ui.restclient;

import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static lab.gwtp.shared.Parameters.PASSWORD;
import static lab.gwtp.shared.Parameters.USERNAME;
import static lab.gwtp.shared.ResourcePaths.User.LOGIN;
import static lab.gwtp.shared.ResourcePaths.User.ROOT;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.gwtplatform.dispatch.rest.shared.RestAction;

@Path(ROOT)
public interface UserService {

	@POST
	@Path(LOGIN)
	@Consumes(APPLICATION_FORM_URLENCODED)
	RestAction<Void> login(@FormParam(USERNAME) String username, @FormParam(PASSWORD) String password);

	@DELETE
	@Path(LOGIN)
	RestAction<Void> logout();

	@GET
	@Path(LOGIN)
	RestAction<Boolean> isCurrentUserLoggedIn();
}
