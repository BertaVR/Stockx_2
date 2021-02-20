package edu.pingpong.domain.item;

public class Sale implements Offer{
    private String size = "";
    private Integer price = 0;

    public Sale(String size, Integer price){
        this.size = size;
        this.price = price;
    }

    public String size(){
        return this.size;
    }

    public int value(){
        return this.price;
    }

    @Override
    public String toString() {
        return "\n\t\t" + size() + "\t\t" + value();

    }

}
