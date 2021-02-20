package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.Ask;
import edu.pingpong.domain.item.Item;
import edu.pingpong.domain.item.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Asks implements Criteria {
    private List<Offer> asksList = new ArrayList<>();

    public Asks() {

    }

    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        this.asksList = sneaker.offers().stream().filter(o -> o instanceof Ask).filter(o -> o != null).
                collect(Collectors.toList());
        return this.asksList;
    }
}
