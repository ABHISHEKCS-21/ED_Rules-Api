package com.mypack.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.binding.CitizenInfo;
import com.mypack.binding.PlanInfo;
import com.mypack.services.DetermineEligibilityService;

@RestController
public class DetermineEligibilityRestController {
	
	@Autowired
	private DetermineEligibilityService eligService;
	
	@PostMapping(
			value="/determineElig",
			consumes= {
					MediaType.APPLICATION_JSON_VALUE,
					//MediaType.APPLICATION_XML_VALUE
			}
				)
	
public PlanInfo checkPlanEligibility(@RequestBody CitizenInfo citizenInfo) throws Exception {
		PlanInfo planInfo=eligService.determineEligibility(citizenInfo);
		return planInfo;
	}

}
