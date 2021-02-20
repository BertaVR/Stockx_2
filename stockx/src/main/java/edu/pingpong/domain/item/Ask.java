package edu.pingpong.domain.item;

public class Ask implements Offer{
    private String size = "";
    private Integer ask = 0;

    public Ask(String size, Integer ask){
        this.size = size;
        this.ask = ask;
    }

    public String size(){
        return this.size;
    }

    public int value(){
        return this.ask;
    }

    @Override
    public String toString() {
        return "\n\t\t" + size() + "\t\t" + value();


    }
}
