package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.Item;
import edu.pingpong.domain.item.Offer;

import java.util.List;

public interface Criteria {

    List<Offer> checkCriteria(Item item);

}
