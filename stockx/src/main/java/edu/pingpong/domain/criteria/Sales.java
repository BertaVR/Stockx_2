package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sales implements Criteria{


    public Sales() {

    }

    @Override
    public List<Offer> checkCriteria(Item item) {
        List<Offer> salesList = new ArrayList<>();
        salesList = item.offers().stream().filter(o -> o instanceof Sale).filter(o -> o != null).
                collect(Collectors.toList());
        return salesList;
    }
}
