package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sales implements Criteria{

    private List<Offer> salesList = new ArrayList<>();

    public Sales() {

    }

    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        this.salesList = sneaker.offers().stream().filter(o -> o instanceof Sale).filter(o -> o != null).
                collect(Collectors.toList());
        return this.salesList;
    }
}
