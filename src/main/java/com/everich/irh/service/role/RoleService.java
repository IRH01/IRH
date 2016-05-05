package com.everich.irh.service.role;
import java.util.List;
import com.everich.irh.entity.role.Role;
public interface RoleService {
	List<Role> getAllRoles();

	void saveRole(Role role);

	boolean isExistRole(String roleName);

	List<Role> findByResourceId(Object id);
}
