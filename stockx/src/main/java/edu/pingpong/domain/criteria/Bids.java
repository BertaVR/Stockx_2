package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.Bid;
import edu.pingpong.domain.item.Item;
import edu.pingpong.domain.item.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bids implements Criteria{

    private List<Offer> bidsList = new ArrayList<>();

    public Bids(){

    }

    @Override
    public List<Offer> checkCriteria(Item item) {
        List<Offer> bidsList = item.offers().stream().filter(o -> o instanceof Bid).filter(o -> o!=null).
                collect(Collectors.toList());
        return bidsList;
    }
}
