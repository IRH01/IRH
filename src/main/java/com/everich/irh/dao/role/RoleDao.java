package com.everich.irh.dao.role;
import java.util.List;
import com.everich.irh.entity.role.Role;
import com.everich.irh.entity.user.Users;
public interface RoleDao {
	List<Role> getAllRoles();

	void saveRole(Role role);

	Role getByName(String roleName);

	List<Role> getRolesByUser(Users user);
}
