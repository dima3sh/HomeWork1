package com.mobile;

import com.mobile.pricingPlans.*;
import com.mobile.services.CompanyService;
import org.slf4j.*;


public class Application {
    final static Logger LOGGER = LoggerFactory.getLogger(CompanyService.class);
    public static void main(String[] args){
        CompanyService company = new CompanyService();
       LOGGER.info("Start program");
        //add pricing plan
        company.mobileCompany.addPricingPlan(new PricingPlanSmart());
        company.mobileCompany.addPricingPlan(new PricingPlanBusiness());
        company.mobileCompany.addPricingPlan(new PricingPlanKid());
        company.mobileCompany.addPricingPlan(new PricingPlanPremium());


        company.printListPricingPlan();

        company.mobileCompany.addClientCard(new PricingPlanSmart(), "David", 18, "1234567");
        company.mobileCompany.addClientCard(new PricingPlanBusiness(), "Marry", 23, "2345678");
        company.mobileCompany.addClientCard(new PricingPlanPremium(), "Alex", 35, "2349564");
        company.mobileCompany.addClientCard(new PricingPlanKid(), "Kira", 23, "2345927");

        //company.printListClientCard();
        System.out.println(company.mobileCompany.getCountClientCard());
        System.out.println(company.searchPricingPlans(12.5));
        LOGGER.info("End program");
    }
}
