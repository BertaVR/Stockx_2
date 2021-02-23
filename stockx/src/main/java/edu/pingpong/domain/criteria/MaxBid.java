package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.Item;
import edu.pingpong.domain.item.Offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxBid implements Criteria{

    private List<Offer> maxBid = new ArrayList<>();

    Criteria bids = new Bids(); //esto no sé si lo puedo hacer porque no está en el UML

    public MaxBid(){

    }

    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        Offer maxBidOffer = bids.checkCriteria(sneaker).stream().filter(o -> o!=null).
                max(Comparator.comparing(o->o.value())).orElse(null);


        maxBid.add(maxBidOffer);

        maxBid = maxBid.stream().filter(o -> o!=null) //Aquí quito los nulos
                .collect(Collectors.toList());


        return maxBid;
    }
}
