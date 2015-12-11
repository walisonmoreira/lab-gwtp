package lab.gwtp.config.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lab.gwtp.shared.dto.UserVo;

@Component
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, 
																		  HttpServletResponse resp,
																		  Authentication auth) throws IOException, ServletException {
		resp.setStatus(HttpServletResponse.SC_OK);

		UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
		UserVo userVo = new UserVo(userDetails.getUsername(), userDetails.getPassword(), userDetails.isEnabled());

		LOGGER.info(userDetails.getUsername() + " got is connected ");

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		PrintWriter writer = resp.getWriter();
		objectMapper.writeValue(writer, userVo);
		writer.flush();
	}
}
