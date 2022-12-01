package com.mypack.services;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mypack.binding.CitizenInfo;
import com.mypack.binding.IndvInfo;
import com.mypack.binding.PlanInfo;

@Service("eligService")
public class DetermineEligibilityService {

	public PlanInfo determineEligibility(CitizenInfo citizenInfo)throws Exception{

		IndvInfo indvInfo=new IndvInfo();
		BeanUtils.copyProperties(citizenInfo, indvInfo);

		String planName = citizenInfo.getPlanName();
		String drlFile = null;
		if (planName.equals("SNAP")) {
			drlFile = "/com/rules/snap.drl";
		}
		if (planName.equals("CCAP")) {
			drlFile = "/com/rules/ccap.drl";
		}
		
		PackageBuilder packageBuilder = new PackageBuilder();

		InputStream resourceAsStream = getClass().getResourceAsStream(drlFile);

		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();

	
		workingMemory.insert(indvInfo);
		workingMemory.fireAllRules();

	
		return indvInfo.getPlanInfo();
	}

}
