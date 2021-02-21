/*
package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.Ask;
import edu.pingpong.domain.item.Item;
import edu.pingpong.domain.item.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Locale.filter;

public class Min implements Criteria{

    private List<Offer> min = new ArrayList<>();


    public Min() {

    }

    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        List<Offer> min = sneaker.offers().stream().mapToInt(Item::getBid()).min;
        return min;
    }

}
*/
