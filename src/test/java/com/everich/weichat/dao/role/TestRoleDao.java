package com.everich.weichat.dao.role;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.everich.irh.dao.role.RoleDao;
import com.everich.irh.entity.role.Role;
@ContextConfiguration({"/spring/spring.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestRoleDao {
	@Autowired
	private RoleDao roleDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testSave() {
		Role role = new Role();
		role.setRoleName("rh");
		roleDao.saveRole(role);
	}

	@Test
	public void testGetByName() {
	}

	@Test
	public void testGetAll() {
	}

	@Test
	public void testDetete() {
	}
}
