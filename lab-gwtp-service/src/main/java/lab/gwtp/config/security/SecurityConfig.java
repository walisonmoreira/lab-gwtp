package lab.gwtp.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lab.gwtp.shared.Parameters;
import lab.gwtp.shared.ResourcePaths;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = SecurityConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String LOGIN_PATH = ResourcePaths.ROOT + ResourcePaths.User.ROOT + ResourcePaths.User.LOGIN;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private HttpAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private AuthSuccessHandler authSuccessHandler;
	@Autowired
	private AuthFailureHandler authFailureHandler;
	@Autowired
	private HttpLogoutSuccessHandler logoutSuccessHandler;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(new ShaPasswordEncoder());

		return authenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
					.authenticationProvider(authenticationProvider())
					.exceptionHandling()
					.authenticationEntryPoint(authenticationEntryPoint)
				.and()
				.authorizeRequests()
					.antMatchers("/", "/index.html", "/ui/**", "/favicon.ico").permitAll()
					.anyRequest().authenticated()
				.and()
				.formLogin().permitAll()
					.loginProcessingUrl(LOGIN_PATH)
					.usernameParameter(Parameters.USERNAME)
					.passwordParameter(Parameters.PASSWORD)
					.successHandler(authSuccessHandler)
					.failureHandler(authFailureHandler)
				.and()
				.logout().permitAll()
					.logoutRequestMatcher(new AntPathRequestMatcher(LOGIN_PATH, "DELETE"))
					.logoutSuccessHandler(logoutSuccessHandler)
				.and()
				.sessionManagement()
					.maximumSessions(1);
	}
}
