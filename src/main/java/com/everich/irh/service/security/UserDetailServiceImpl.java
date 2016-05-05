package com.everich.irh.service.security;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.everich.irh.dao.role.RoleDao;
import com.everich.irh.dao.user.UserDao;
import com.everich.irh.entity.authority.Authority;
import com.everich.irh.entity.role.Role;
import com.everich.irh.entity.user.Users;
import com.everich.irh.service.user.UserService;
@Service
@Transactional
public class UserDetailServiceImpl implements UserService, UserDetailsService {
	@Autowired
	UserDao userDao;
	@Autowired
	RoleDao roleDao;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		Users user = userDao.search(username);
		if (user == null) throw new UsernameNotFoundException(username + " not exist!");
		List<GrantedAuthority> authsList = new ArrayList<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			for (Authority authority : role.getAuthorities())
				authsList.add(new SimpleGrantedAuthority(authority.getAuthorityname()));
		}
		UserDetails userdetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), accountNonExpired,
				credentialsNonExpired, accountNonLocked, authsList);
		return userdetails;
	}
}
