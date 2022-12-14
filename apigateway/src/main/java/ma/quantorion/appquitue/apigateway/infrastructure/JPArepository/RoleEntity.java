package ma.quantorion.appquitue.apigateway.infrastructure.JPArepository;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.quantorion.appquitue.apigateway.domain.ApplicationUserPermission;
import ma.quantorion.appquitue.apigateway.domain.Role;

@Entity
@Data
@NoArgsConstructor
public class RoleEntity
{

	@Id
	private String roleName;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@Enumerated
	private Set<ApplicationUserPermission> rolePermissions;
	
	public RoleEntity(String roleName, Set<ApplicationUserPermission> rolePermissions) {
		super();
		this.roleName = roleName;
		this.rolePermissions = rolePermissions;
	}
	
	public RoleEntity(Role role) {
		super();
		this.roleName = role.getRoleName();
		this.rolePermissions = role.getRolePermissions();
	}
	
	public Role toRole() {
		Role user = new Role(roleName, rolePermissions);
        return user;
    }
	
	
	
}
