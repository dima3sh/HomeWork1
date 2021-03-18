package com.mobile.mobileCompany;

import com.mobile.card.*;
import com.mobile.pricingPlans.PricingPlan;
import com.mobile.services.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;

public class MobileCompany {

    final static Logger LOGGER = LoggerFactory.getLogger(CompanyService.class);
    private int countClientCard = 0;
    private ArrayList <PricingPlan> pricingPlanList = new ArrayList<>();
    private ArrayList<Card> cardClientList = new ArrayList<>();

    public MobileCompany(){
        LOGGER.info("Create new MobileCompany");
    }

    public int getCountClientCard(){
        return countClientCard;
    }

    public void sortSubscriptionFee(ArrayList<PricingPlan> pricingPlanList) {
        pricingPlanList.sort(Comparator.comparing(PricingPlan::getSubscriptionFee));
    }

    public void setPricingPlanList(ArrayList<PricingPlan> pricingPlanList){
        this.pricingPlanList = pricingPlanList;
    }
    public PricingPlan getPricingPlan(int index){
        return pricingPlanList.get(index);
    }

    public ArrayList<PricingPlan> getPricingPlanList() {
        return pricingPlanList;
    }

    public void addPricingPlan(PricingPlan pricingPlan) {
        pricingPlanList.add(pricingPlan);
    }

    public ArrayList<Card> getCardClientList() {
        return cardClientList;
    }

    public void addClientCard(PricingPlan pricingPlan, String name, int age, String number) {
        Card card = new Card(pricingPlan, new Client(name, age, number));
        cardClientList.add(card);
        countClientCard++;
    }
}
