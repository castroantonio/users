/*
 * UTF-8
 */
package com.ajcf.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ajcf.users.model.User;
import com.ajcf.users.service.UserService;

@RestController
public class UsersController {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.POST, path = "users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> create(@RequestBody User user) {
		user = service.add(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, path = "users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> retrive(@PathVariable(name = "id") Integer id) {
		User user = service.get(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.FOUND);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> update(@RequestBody User user) {
		user = service.update(user);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "users/delete/{id}")
	public ResponseEntity delete(@PathVariable(name = "id") Integer id) {
		boolean deleted = service.delete(id);
		if (deleted) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.GET, path = "users/list", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<User>> list() {
		List<User> users = service.list();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}