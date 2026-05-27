package com.pluralsight.models;

import com.pluralsight.interfaces.Chargeable;

public class OrderItem {
    private int itemID;
    private final Chargeable item;

    public OrderItem(int itemID, Chargeable item) {
        this.itemID = itemID;
        this.item = item;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getItemID() {
        return itemID;
    }

    public Chargeable getItem() {
        return item;
    }
}