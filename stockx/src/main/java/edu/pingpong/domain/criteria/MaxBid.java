package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.Bid;
import edu.pingpong.domain.item.Item;
import edu.pingpong.domain.item.Offer;

import java.util.List;
import java.util.stream.Collectors;

public class MaxBid implements Criteria{
    Bids bids;
    public MaxBid(){

    }
    @Override
    public List<Offer> checkCriteria(Item sneaker) {

        return maxBid;
    }
}
