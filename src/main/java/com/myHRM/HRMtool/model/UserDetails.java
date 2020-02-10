package com.myHRM.HRMtool.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection= "user-details")
@NoArgsConstructor @AllArgsConstructor @ToString
public class UserDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter @Id int id;
	@Getter @Setter Company companyDetails;
	@Getter @Setter String firstName;
	@Getter @Setter String middleName;
	@Getter @Setter String lastName;
	@Getter @Setter Adress adress;
	@Getter @Setter String emailAddress;
	@Getter @Setter String aboutMe;
	@Getter @Setter String profileImage;
	@Getter @Setter String socialMediaLink1;
	@Getter @Setter String sockelMediaLink2;
}
