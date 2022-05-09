package com.github.vlsidlyarevich.model;

public class Cart extends BaseEntity{
    private String customer_id;
    private String show_time_id;
    private int child_tickets;
    private int adult_tickets;

    public Cart() {
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getShow_time_id() {
        return show_time_id;
    }

    public void setShow_time_id(String show_time_id) {
        this.show_time_id = show_time_id;
    }

    public int getChild_tickets() {
        return child_tickets;
    }

    public void setChild_tickets(int child_tickets) {
        this.child_tickets = child_tickets;
    }

    public int getAdult_tickets() {
        return adult_tickets;
    }

    public void setAdult_tickets(int adult_tickets) {
        this.adult_tickets = adult_tickets;
    }
}
