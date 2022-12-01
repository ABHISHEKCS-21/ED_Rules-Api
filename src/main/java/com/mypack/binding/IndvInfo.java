package com.mypack.binding;

import lombok.Data;

@Data
public class IndvInfo {

	
	private Integer caseNumber;
	private Integer age;
	private String planName;
	private String isEmployed;
	private Integer employmentIncome;
	private Integer unEmploymentIncome; 
	private Integer kidsCount;
	private String isGraduate;
	
	private PlanInfo planInfo;
}
