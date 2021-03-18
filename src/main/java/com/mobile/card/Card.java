package com.mobile.card;

import com.mobile.pricingPlans.PricingPlan;

public class Card {
    private double balance;
    private PricingPlan pricingPlan;
    private final Client client;
    private AccountClientStatus accountClientStatus;

    public Card(PricingPlan pricingPlan, Client client) {
        this.pricingPlan = pricingPlan;
        this.accountClientStatus = AccountClientStatus.ACTIVE;
        this.client = client;
        balance = 0;
    }

    // check it
    public void changePricingPlan(PricingPlan pricingPlan){
        if(accountClientStatus == AccountClientStatus.ACTIVE) {
            this.pricingPlan = pricingPlan;
        }else{
            System.out.println("Оплата не возможна, отрицательный баланс!");
        }
    }

    public void PaymentSubscriptionFee() {
        balance -= pricingPlan.getSubscriptionFee();
        accountClientStatus = (balance > 0) ? AccountClientStatus.ACTIVE : AccountClientStatus.BLOCKED;
    }

    public void refillBalance(double sumRefill) {
        balance += sumRefill;
        accountClientStatus = (balance > 0) ? AccountClientStatus.ACTIVE : AccountClientStatus.BLOCKED;
    }

    public double getBalance() {
        return balance;
    }

    public AccountClientStatus getAccountClientStatus() {
        return accountClientStatus;
    }

    @Override
    public String toString() {
        return "Card{" +
                ", balance=" + balance +
                ", pricingPlan=" + pricingPlan +
                ", client=" + client +
                '}';
    }
}
