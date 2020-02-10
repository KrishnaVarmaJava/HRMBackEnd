package com.myHRM.HRMtool.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myHRM.HRMtool.Service.UserDetailsService;
import com.myHRM.HRMtool.model.UserDetails;

@RestController
public class UserDetailsController {

	@Autowired
	UserDetailsService userDetailsService;

	//
	@PostMapping(value="/createUser")
	public String createUser(@RequestBody UserDetails user) {
		System.out.println("Method Called");
		userDetailsService.createUser(user);
		return "Employee Recoard Created";
	}

	@GetMapping(value="/getUserbyId")
	public Optional<UserDetails> getById(@RequestParam int id){
		System.out.println("Get Method Called");
		return userDetailsService.findUserDetialsById(id);
	}

	@GetMapping(value="/getUserbyEmail")
	public UserDetails getByEmail(@RequestParam String email){
		System.out.println("Get Method Called");
		return userDetailsService.findUserByEmail(email);
	}

	@GetMapping(value="/getAllUsers")
	public List<UserDetails> getallUsers() {
		return userDetailsService.getAllUserDetials();
	}

	@PutMapping(value="/updateUser")
	public BodyBuilder updateUserDetails(@RequestBody UserDetails user){
		
		userDetailsService.updateUserDetials(user);
		return ResponseEntity.status(HttpStatus.ACCEPTED);
	}

	@GetMapping(value="/getImage")
	public ResponseEntity<InputStreamResource> getImage(@RequestParam String id) {

		try {
			System.out.println("THis called "+id);
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType("application/octet-stream"))
					.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + userDetailsService.getImage(id).getFilename() + "\"")
					.contentLength(userDetailsService.getImage(id).contentLength())
					.body(userDetailsService.getImage(id));
		} catch (IllegalStateException | IOException e) {
			System.out.println("Exceptin occureed "+e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 

	}

}
