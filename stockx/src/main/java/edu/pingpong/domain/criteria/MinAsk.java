package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.Item;
import edu.pingpong.domain.item.Offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MinAsk implements Criteria{
    private List<Offer> minAsk = new ArrayList<>();

    Criteria asks = new Asks(); // TATUAJE MENTAL: Berta por dios, acuérdate de poner = new Asks(), que siempre me estoy olvidando.

    public MinAsk(){

    }

    @Override
    public List<Offer> checkCriteria(Item item) {
        Offer minAskOffer = asks.checkCriteria(item).stream().filter(o -> o!=null).
                min(Comparator.comparing(o->o.value())).orElse(null);


        minAsk.add(minAskOffer);

        minAsk = minAsk.stream().filter(o -> o!=null) //Aquí quito los nulos
                .collect(Collectors.toList());


        return minAsk;
    }
}
