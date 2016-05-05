package com.everich.irh.dao.user.impl;
import javax.annotation.Resource;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.everich.irh.dao.user.UserDao;
import com.everich.irh.entity.user.Users;
@Repository
public class UserDaoImpl implements UserDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public Users search(String username) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Users.class);
		criteria.add(Restrictions.eq("username", username));
		Users user = (Users) criteria.list().get(0);
		return user;
	}
}
