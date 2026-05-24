package com.pluralsight.models;

import com.pluralsight.enums.Membership;
import com.pluralsight.ui.UserInterface;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Customer {
    private final String name;
    private final Order order;
    private Membership membership;
    private LocalDateTime membershipDate;

    public Customer(String name, Order order) {
        this.name = name;
        this.order = order;
        membership = Membership.REGULAR;
    }

    public String getName() {
        return name;
    }

    public Order getOrder() {
        return order;
    }

    public Membership getMembership() {
        return membership;
    }

    public void upgradeMembership() {
        membership = Membership.PREMIUM;
        membershipDate = LocalDateTime.now();
    }

    public void makePayment() {
        if(membership == Membership.REGULAR) {
            UserInterface.printToConsole("Regular Members don't have payments to make");
            return;
        }

        membershipDate = LocalDateTime.now();
    }

    public LocalDateTime getNextPaymentDate() {
        return membershipDate.plusDays(30);
    }

    public boolean isInGoodStanding() {
        return membershipDate.isBefore(getNextPaymentDate());
    }

}
