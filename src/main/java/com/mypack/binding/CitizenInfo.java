package com.mypack.binding;

import lombok.Data;

@Data
public class CitizenInfo {
	
	private Integer CaseNumber;
	private String gender;
	private Integer age;
	private String planName;
	private String isEmployed;
	private Integer employmentIncome;
	private Integer unEmploymentIncome; 
	private Integer kidsCount;
	private String isGraduate;  

}
