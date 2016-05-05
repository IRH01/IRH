package com.everich.irh.service.role.impl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.everich.irh.dao.role.RoleDao;
import com.everich.irh.entity.role.Role;
import com.everich.irh.service.role.RoleService;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	private static final Logger LOG = LoggerFactory.getLogger(RoleServiceImpl.class);
	@Autowired
	private RoleDao roleDao;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Role> getAllRoles() {
		List<Role> list = roleDao.getAllRoles();
		LOG.debug("运行到这里来了");
		return list;
	}

	@Override
	public void saveRole(Role role) {
		roleDao.saveRole(role);
	}

	@Override
	public boolean isExistRole(String roleName) {
		Role role = roleDao.getByName(roleName);
		if (role == null) { return false; }
		return true;
	}

	@Override
	public List<Role> findByResourceId(Object id) {
		return null;
	}
}
