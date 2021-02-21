package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.Item;
import edu.pingpong.domain.item.Offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinAsk implements Criteria{
    private List<Offer> minAsk = new ArrayList<>();

    Criteria asks = new Asks(); // TATUAJE MENTAL: Berta por dios, acuérdate de poner = new Asks(), que siempre me estoy olvidando.

    public MinAsk(){

    }

    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        Offer minAskOffer = asks.checkCriteria(sneaker).stream().filter(o -> o!=null).
                min(Comparator.comparing(o->o.value())).orElse(null);

        /* No sé, este último orElse me parece peligroso porque no quiero valores nulos, lo he tenido que poner porque
         ** si no los objetos eran de clase Optional y no es lo que pide mi lista, creo que tendré que refactorizar.
         ** El filtro de nulos tampoco sé qué tan útil es, probablemente lo borraré
         */

        minAsk.add(minAskOffer);

        return minAsk;
    }
}
