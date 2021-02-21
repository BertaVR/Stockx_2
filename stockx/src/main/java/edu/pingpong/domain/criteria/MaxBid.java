package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.Item;
import edu.pingpong.domain.item.Offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxBid implements Criteria{

    private List<Offer> maxBid = new ArrayList<>();

    Criteria bids = new Bids(); //esto no sé si lo puedo hacer porque no está en el UML

    public MaxBid(){

    }

    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        Offer maxBidOffer = bids.checkCriteria(sneaker).stream().filter(o -> o!=null).
                max(Comparator.comparing(o->o.value())).orElse(null);

        /* No sé, este último orElse me parece peligroso porque no quiero valores nulos, lo he tenido que poner porque
         ** si no los objetos eran de clase Optional y no es lo que pide mi lista, creo que tendré que refactorizar.
         ** El filtro de nulos tampoco sé qué tan útil es, probablemente lo borraré
         */

        maxBid.add(maxBidOffer);

        return maxBid;
    }
}
