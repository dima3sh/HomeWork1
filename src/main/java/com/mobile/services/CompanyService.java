package com.mobile.services;

import com.mobile.card.Card;
import com.mobile.mobileCompany.MobileCompany;
import com.mobile.pricingPlans.PricingPlan;
import java.util.ArrayList;

public class CompanyService {
    public MobileCompany mobileCompany = new MobileCompany();

    public void printListPricingPlan() {
        for (PricingPlan pricingPlan : mobileCompany.getPricingPlanList()) {
            System.out.println(pricingPlan);
        }
    }

    public void removePricingPlan(PricingPlan pricingPlan) {
        if (mobileCompany.getPricingPlanList().contains(pricingPlan)) {
            ArrayList<PricingPlan> plans = mobileCompany.getPricingPlanList();
            plans.remove(pricingPlan);
            mobileCompany.setPricingPlanList(plans);
        } else {
            throw new IllegalArgumentException("Pricing plan isn't exist");
        }
    }

    public void removeCardClient(Card cardClient) {
        if (mobileCompany.getPricingPlanList().contains(cardClient)) {
            ArrayList<PricingPlan> cards = mobileCompany.getPricingPlanList();
            cards.remove(cardClient);
            mobileCompany.setPricingPlanList(cards);
        } else {
            throw new IllegalArgumentException("SIM-Card isn't exist");
        }
    }

    public void printListClientCard() {
        for (Card card : mobileCompany.getCardClientList()) {
            System.out.println(card);
        }
    }

    public PricingPlan searchPricingPlans(double subscriptionFee) {
        ArrayList<PricingPlan> pricingPlans = mobileCompany.getPricingPlanList();

        for (PricingPlan plan : pricingPlans) {
            if (plan.getSubscriptionFee() == subscriptionFee ) {
                return plan;
            }
        }
        throw new IllegalArgumentException();
    }

}
