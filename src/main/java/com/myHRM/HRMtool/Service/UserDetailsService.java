package com.myHRM.HRMtool.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.gridfs.GridFsResource;

import com.myHRM.HRMtool.model.UserDetails;

public interface UserDetailsService {
	
	/**
	 * Method to create new UserDetialss in the db using mongo-db repository.
	 * @param emp
	 */
	public void createUsers(List<UserDetails> users);
	
	public void createUser(UserDetails user);

	/**
	 * Method to fetch all UserDetialss from the db using mongo-db repository.
	 * @return
	 */
	public List<UserDetails> getAllUserDetials();

	/**
	 * Method to fetch UserDetials by id using mongo-db repository.
	 * @param id
	 * @return
	 */
	public Optional<UserDetails> findUserDetialsById(int id);

	/**
	 * Method to delete UserDetials by id using mongo-db repository.
	 * @param id
	 */
	public void deleteUserDetialsById(int id);

	/**
	 * Method to update UserDetials by id using mongo-db repository.
	 * @param id
	 */
	public void updateUserDetials(UserDetails emp);

	/**
	 * Method to delete all UserDetialss using mongo-db repository.
	 */
	public void deleteAllUserDetials();
	
	public UserDetails findUserByEmail(String email);

	public GridFsResource getImage(String id);

}
