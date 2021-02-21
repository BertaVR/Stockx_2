package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.Item;
import edu.pingpong.domain.item.Offer;
import edu.pingpong.domain.item.Sale;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Size implements Criteria{

    private final String size;

    public Size(String size) {
        this.size = size;
    }

    @Override
    public List<Offer> checkCriteria(Item item) {

        List<Offer>  sneakersOfSize = item.offers().stream().filter(o -> o.size().equals(this.size))
                .collect(Collectors.toList());

        return sneakersOfSize;
    }




}
