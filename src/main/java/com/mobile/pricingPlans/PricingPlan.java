package com.mobile.pricingPlans;

public abstract class PricingPlan {

    protected String namePricingPlan;
    protected int countMinute;
    protected double internetWeight;
    protected double subscriptionFee;

    public PricingPlan(String namePricingPlan, int countMinute, double internetWeight, double subscriptionFee) {
        this.namePricingPlan = namePricingPlan;
        this.countMinute = countMinute;
        this.internetWeight = internetWeight;
        this.subscriptionFee = subscriptionFee;
    }

    public void setSubscriptionFee(double subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public void setCountMinute(int countMinute) {
        this.countMinute = countMinute;
    }

    public void setNamePricingPlan(String namePricingPlan) {
        this.namePricingPlan = namePricingPlan;
    }

    public double getInternetWeight() {
        return internetWeight;
    }

    public int getCountMinute() {
        return countMinute;
    }

    public String getNamePricingPlan() {
        return namePricingPlan;
    }

    public double getSubscriptionFee() {
        return subscriptionFee;
    }

    @Override
    public String toString() {
        return  "namePricingPlan='" + namePricingPlan + '\'' +
                ", countMinute=" + countMinute +
                ", internetWeight=" + internetWeight +
                ", subscriptionFee=" + subscriptionFee ;
    }
}
