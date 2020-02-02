package com.mylearning.app.ws.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mylearning.app.ws.mo.UserDetailsMO;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

	Map<Integer, UserDetailsMO> userMap = new HashMap<Integer, UserDetailsMO>();

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDetailsMO> getUser(@PathVariable int userId) {

		UserDetailsMO userMO = new UserDetailsMO();

		userMO.setUserId(userId);
		userMO.setFirstName("Mufaddal");
		userMO.setLastName("Kagzi");
		userMO.setEmailId("mufaddalkagzi@gmail.com");

		return new ResponseEntity<UserDetailsMO>(userMO, HttpStatus.OK);

	}

	@GetMapping()
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", required = false) String sort) {
		
		String name = null;
		name.length();
		return " Get Method Called with page " + page + " limit " + limit + "  sort " + sort;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDetailsMO> creatUser(@Valid @RequestBody UserDetailsMO userMo) {

		UserDetailsMO userMO = new UserDetailsMO();

		userMO.setUserId(userMo.getUserId());
		userMO.setFirstName("*" + userMo.getFirstName());
		userMO.setLastName("*" + userMo.getLastName());
		userMO.setEmailId("*" + userMo.getEmailId());
		
		userMap.put(userMo.getUserId(), userMO);

		return new ResponseEntity<UserDetailsMO>(userMO, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDetailsMO> updateUser(@PathVariable int userId, @RequestBody UserDetailsMO userMo) {

		if (userMap.containsKey(userId)) {
			userMap.get(userId).setFirstName(userMo.getFirstName());
			userMap.get(userId).setFirstName(userMo.getLastName());
			return new ResponseEntity<UserDetailsMO>(userMo, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserDetailsMO>(HttpStatus.NO_CONTENT);
		}

	}

	@DeleteMapping
	public String deleteUser() {
		return "User Deleted";
	}

}
