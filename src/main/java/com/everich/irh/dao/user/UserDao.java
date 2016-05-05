package com.everich.irh.dao.user;
import com.everich.irh.entity.user.Users;
public interface UserDao {
	Users search(String username);
}
