package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.Item;
import edu.pingpong.domain.item.Offer;

import java.util.List;
import java.util.stream.Collectors;

public class AndCriteria implements Criteria{



    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria){
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Offer> checkCriteria(Item item) {

        List<Offer> firstCriteria = this.criteria.checkCriteria(item);
        List<Offer> secondCriteria = this.otherCriteria.checkCriteria(item);

        List<Offer> andCriteria = firstCriteria.stream().filter(c -> (secondCriteria.stream().filter(o -> o.equals(c)).count())>0).collect(Collectors.toList());
        //esta fracción de código la entiendo pero no lo habría podido sacar de esta manera sin Carlos

        return andCriteria;
    }

    }






