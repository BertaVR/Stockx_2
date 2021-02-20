package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.Ask;
import edu.pingpong.domain.item.Bid;
import edu.pingpong.domain.item.Offer;
import edu.pingpong.domain.item.Sneaker;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BidsTest {
    Sneaker sneakers;
    Sneaker bambas;
    Sneaker tenis;
    Bids bids;


    @Before

    public void setUpListas(){
        //Añado cosas a la lista sneaker que he definido anteriormente
        this.sneakers = new Sneaker("Hola", "Adios");
        this.bambas = new Sneaker("BonDia", "BonaNit");
        this.tenis = new Sneaker("Sol", "Luna");
        Bid bid = new Bid("Cero", 50);
        sneakers.add(bid);
        sneakers.add(new Bid("Uno", 1));
        sneakers.add(new Bid("Dos", 2));
        sneakers.add(new Bid("Tres", 3));
        sneakers.add(new Bid("Cuatro", 4));
        //Añado lo mismo a la lista bambas
        Bid bid2 = new Bid("Cero", 50);
        bambas.add(bid2);
        bambas.add(new Bid("Uno", 1));
        bambas.add(new Bid("Dos", 2));
        bambas.add(new Bid("Tres", 3));
        bambas.add(new Bid("Cuatro", 4));
        //Añado asks a la lista sneaker para comprobar que los asks no pasan el filtro de bids
        Ask ask = new Ask("Ochentamil", 80);
        sneakers.add(ask);
        sneakers.add(new Ask("Cinco", 20));
        sneakers.add(new Ask("Seis", 30));
        sneakers.add(new Ask("Siete", 40));
        sneakers.add(new Ask("Ocho", 50));
        //Añado una lista de bids con valores diferentes para comprobar que no son iguales.
        Bid bid3 = new Bid("Cero", 50);
        tenis.add(bid3);
        tenis.add(new Bid("Uno", 1));
        tenis.add(new Bid("Dos", 2));
        tenis.add(new Bid("Tres", 3));
        tenis.add(new Bid("Cuatro", 4));
        tenis.add(new Bid("Cinco", 20));
        tenis.add(new Bid("Seis", 30));
        tenis.add(new Bid("Siete", 40));
        tenis.add(new Bid("Ocho", 50));


    }

    @Test

    public void filtroBidsTest(){
        Criteria bids = new Bids();
        assertEquals(bids.checkCriteria(sneakers), bids.checkCriteria(bambas) );

    }


}
