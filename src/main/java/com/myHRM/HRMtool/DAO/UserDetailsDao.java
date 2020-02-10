package com.myHRM.HRMtool.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.myHRM.HRMtool.model.UserDetails;

public interface UserDetailsDao extends MongoRepository<UserDetails, Integer>{
	
	@Query("{email : ?0}")
	public UserDetails findByEmail(String email);

}
