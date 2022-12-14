package ma.quantorion.appquitue.apigateway.domain;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.quantorion.appquitue.apigateway.domain.validation.annotations.PasswordMatches;
import ma.quantorion.appquitue.apigateway.domain.validation.annotations.ValidEmail;

@NoArgsConstructor
@Data
//@PasswordMatches
public class User
{
	
	private Long userId;

	@ValidEmail
	private String email;

	private String password;
	
	private String matchingPassword;
	
	private List<Role> userRoles;
	
	public User(Long userId, String email, String password, List<Role> userRoles) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.userRoles = userRoles;
	}
	
	
}
