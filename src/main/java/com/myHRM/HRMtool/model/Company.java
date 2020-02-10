package com.myHRM.HRMtool.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection= "compant-details")
@NoArgsConstructor @AllArgsConstructor @ToString
public class Company {
	
	@Getter @Setter @Id int id;
	@Getter @Setter String companyName;
	@Getter @Setter Adress aderss;

}
