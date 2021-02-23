package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.Item;
import edu.pingpong.domain.item.Offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Min implements Criteria{

    private List<Offer> min = new ArrayList<>();

    Criteria criteria;
    Criteria otherCriteria;



    public Min(Criteria criteria, Criteria otherCriteria){
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }



    @Override
    public List<Offer> checkCriteria(Item item) {

        Criteria andCriteria = new AndCriteria(criteria, otherCriteria);

        List<Offer> andCriteriaList = andCriteria.checkCriteria(item);

        Offer minOffer = andCriteriaList.stream().
                min(Comparator.comparing(o->o.value())).orElse(null);

        min.add(minOffer);

        min = min.stream().filter(Objects::nonNull)
                .collect(Collectors.toList());

        return min;
    }

}
