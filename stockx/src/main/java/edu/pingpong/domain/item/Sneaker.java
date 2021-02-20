package edu.pingpong.domain.item;

import java.util.ArrayList;
import java.util.List;

public class Sneaker implements Item {


    private final String style;
    private final String name;
    private int sale = 0;
    private int ask = 0;
    private int bid = 0;
    List<Offer> offers = new ArrayList<Offer>();


    public Sneaker(String name, String style) {
        this.name = name;
        this.style = style;
    }

    public String getStyle() {
        return style;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getSale() {
        return this.sale;
    }

    @Override
    public void setSale(int sale) {
        this.sale = sale;
    }

    @Override
    public int getBid() {
        return this.bid;
    }

    @Override
    public void setBid(int bid) {
        this.bid = bid;
    }

    @Override
    public void add(Offer offer) {
        this.offers().add(offer);
    }

    @Override
    public List<Offer> offers() {
        return this.offers;
    }

    @Override
    public int getAsk() {
        return ask;
    }

    @Override
    public void setAsk(int ask) {
        this.ask = ask;
    }

    @Override
    public String toString() {
        return getName() + '\n' +
                getStyle() + '\n' +
                "last sale: " + Integer.toString(getSale());
    }
}