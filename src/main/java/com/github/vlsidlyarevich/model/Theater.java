package com.github.vlsidlyarevich.model;

public class Theater extends BaseEntity{
    private String name;
    private int capacity;
    private String location;
    private String sound;
    private String visual;
    private String image;
    private String logo;
    private Double child_ticket_price;
    private Double adult_ticket_price;

    public Theater() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getVisual() {
        return visual;
    }

    public void setVisual(String visual) {
        this.visual = visual;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Double getChild_ticket_price() {
        return child_ticket_price;
    }

    public void setChild_ticket_price(Double child_ticket_price) {
        this.child_ticket_price = child_ticket_price;
    }

    public Double getAdult_ticket_price() {
        return adult_ticket_price;
    }

    public void setAdult_ticket_price(Double adult_ticket_price) {
        this.adult_ticket_price = adult_ticket_price;
    }
}
