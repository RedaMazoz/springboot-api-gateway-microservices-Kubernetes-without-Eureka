package ma.quantorion.appquitue.authentificationrest.infrastructure.configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
//@EnableOAuth2Sso
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http
		//.csrf().disable()
		.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin();	
	}
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}
