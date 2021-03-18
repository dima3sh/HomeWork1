package com.mobile.services;

import com.mobile.mobileCompany.MobileCompany;
import com.mobile.pricingPlans.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;



public class CompanyServiceTest {

    private static CompanyService company;

    @BeforeAll
    public static void init(){
        company = new CompanyService();
        company.mobileCompany.addPricingPlan(new PricingPlanSmart());
        company.mobileCompany.addPricingPlan(new PricingPlanBusiness());
        company.mobileCompany.addPricingPlan(new PricingPlanKid());
        company.mobileCompany.addPricingPlan(new PricingPlanPremium());
    }

    @ParameterizedTest
    @MethodSource("pricingPlans")
    public void shouldThrowExceptionThenPricingPlanIsNotExist(PricingPlan pricingplan){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            company.removePricingPlan(pricingplan);
        });
    }

    private static Stream<Arguments> pricingPlans() {
        return Stream.of(
                Arguments.of(new PricingPlanSmart()),
                Arguments.of(new PricingPlanKid()),
                Arguments.of(new PricingPlanPremium())
        );
    }


    @ParameterizedTest
    @MethodSource("gapsSubscriptionFee")
    public void shouldFindPricingPlan(double subscriptionFee, PricingPlan testPricingPlan){
        PricingPlan pricingPlan= company.searchPricingPlans(subscriptionFee);

        Assertions.assertEquals(pricingPlan, testPricingPlan);
    }

    private static Stream<Arguments> gapsSubscriptionFee() {
        return Stream.of(
                Arguments.of(3.0, company.mobileCompany.getPricingPlan(2)),
                Arguments.of(5.0, company.mobileCompany.getPricingPlan(0)),
                Arguments.of(12.5, company.mobileCompany.getPricingPlan(3))
        );
    }
}
