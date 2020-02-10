package com.myHRM.HRMtool.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection= "adress")
@NoArgsConstructor @AllArgsConstructor @ToString
public class Adress {
	
	@Getter @Setter @Id int id;
	@Getter @Setter String field1;
	@Getter @Setter String field2;
	@Getter @Setter String city;
	@Getter @Setter String country;
	@Getter @Setter String postalCode;
}
