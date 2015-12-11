package lab.gwtp.config.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest req, 
																		  HttpServletResponse resp, 
																		  AuthenticationException ax) throws IOException, ServletException {
		resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		PrintWriter writer = resp.getWriter();
		writer.write(ax.getMessage());
		writer.flush();
	}
}
