package com.everich.irh.dao.resource.impl;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.everich.irh.dao.resource.ResourceDao;
import com.everich.irh.entity.resource.Resource;
@Repository
public class ResourceDaoImpl implements ResourceDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(Resource.class).list();
	}
}
