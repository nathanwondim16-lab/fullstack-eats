package com.pluralsight.models;

import com.pluralsight.enums.Membership;
import com.pluralsight.ui.UserInterface;

import java.time.LocalDateTime;

public class Customer {
    private final Order order;
    private Membership membership;
    private LocalDateTime joinedDate;

    public Customer(String name, Order order) {
        this.order = order;
        membership = Membership.REGULAR;
    }

    public Order getOrder() {
        return order;
    }

    public Membership getMembership() {
        return membership;
    }

    public void upgradeMembership() {
        membership = Membership.PREMIUM;
        joinedDate = LocalDateTime.now();
    }

    public void makePayment() {
        if(membership == Membership.REGULAR) {
            UserInterface.printToConsole("Regular Members don't have payments to make");
            return;
        }

        joinedDate = LocalDateTime.now();
    }

    public LocalDateTime getNextPaymentDate() {
        return joinedDate.plusDays(30);
    }

    public boolean isInGoodStanding() {
        return joinedDate.isBefore(getNextPaymentDate());
    }
}
