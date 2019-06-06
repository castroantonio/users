/*
 * UTF-8
 */
package com.ajcf.users.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.ajcf.users.model.User;

@Service
public class UserService {
	private static List<User> users = new ArrayList<User>();
	private static AtomicInteger id = new AtomicInteger(0);

	public User add(User user) {
		user.setId(id.incrementAndGet());
		users.add(user);
		return user;
	}

	public User get(Integer id) {
		for (User user : users) {
			if (user.getId().compareTo(id) == 0) {
				return user;
			}
		}
		return null;
	}

	public User update(User user) {
		User oldUser = get(user.getId());
		if (oldUser == null) {
			return null;
		}
		oldUser.setName(user.getName());
		return oldUser;
	}

	public boolean delete(Integer id) {
		User user = get(id);
		if (user == null) {
			return false;
		}
		users.remove(user);
		return true;
	}

	public List<User> list() {
		return users;
	}
}