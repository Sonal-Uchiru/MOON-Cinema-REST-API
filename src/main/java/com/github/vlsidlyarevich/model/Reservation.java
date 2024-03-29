package com.github.vlsidlyarevich.model;



public class Reservation extends BaseEntity{
    private String customer_id;
    private String show_time_id;
    private String reserved_date;
    private String reserved_on;
    private int child_tickets;
    private int adult_tickets;
    private int status;

    public Reservation() {
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

    public String getReserved_date() {
        return reserved_date;
    }

    public void setReserved_date(String reserved_date) {
        this.reserved_date = reserved_date;
    }

    public String getReserved_on() {
        return reserved_on;
    }

    public void setReserved_on(String reserved_on) {
        this.reserved_on = reserved_on;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
