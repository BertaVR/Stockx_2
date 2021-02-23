package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.Ask;
import edu.pingpong.domain.item.Item;
import edu.pingpong.domain.item.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LastSale implements Criteria{

    private List<Offer> lastSale = new ArrayList<>();

    Criteria sales = new Sales();

    public LastSale(){

    }

    @Override
    public List<Offer> checkCriteria(Item item) {
        Offer lastSaleOffer = sales.checkCriteria(item).stream().filter(o -> o!=null).reduce((first, second) -> second).orElse(null);

        /* He puesto el orElse porque
         ** si no los objetos eran de clase Optional y no es lo que pide mi lista
         ** El filtro de nulos tampoco sé qué tan útil es, probablemente lo borraré
         */

        lastSale.add(lastSaleOffer);

        lastSale = lastSale.stream().filter(o -> o!=null) //Aquí quito los nulos
                .collect(Collectors.toList());

        return lastSale;
    }


}
