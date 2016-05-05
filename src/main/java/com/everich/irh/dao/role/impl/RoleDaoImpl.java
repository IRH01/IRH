package com.everich.irh.dao.role.impl;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.everich.irh.dao.role.RoleDao;
import com.everich.irh.entity.role.Role;
import com.everich.irh.entity.user.Users;
@Repository
public class RoleDaoImpl implements RoleDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRoles() {
		return sessionFactory.getCurrentSession().createCriteria(Role.class).list();
	}

	@Override
	public void saveRole(Role role) {
		sessionFactory.getCurrentSession().save(role);
	}

	@Override
	public Role getByName(String roleName) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Role.class);
		criteria.add(Restrictions.eq("roleName", roleName));
		@SuppressWarnings("unchecked")
		List<Role> list = criteria.list();
		if (list.size() <= 0) { return null; }
		return list.get(0);
	}

	@Override
	public List<Role> getRolesByUser(Users user) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Role.class);
		criteria.add(Restrictions.eq("userid", user.getId()));
		@SuppressWarnings("unchecked")
		List<Role> list = criteria.list();
		return list;
	}
}
