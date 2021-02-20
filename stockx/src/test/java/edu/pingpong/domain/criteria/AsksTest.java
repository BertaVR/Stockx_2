package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.Ask;
import edu.pingpong.domain.item.Bid;
import edu.pingpong.domain.item.Offer;
import edu.pingpong.domain.item.Sneaker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class AsksTest {
    Sneaker sneaker;

    Asks asks = new Asks();


    @Before

    public void setUpSneakers() {
        //Añado ofertas bid a sneaker
        this.sneaker = new Sneaker("Hola", "Adios");

        Bid bid = new Bid("Cero", 50);

        sneaker.add(bid);
        sneaker.add(new Bid("Uno", 1));
        sneaker.add(new Bid("Dos", 2));
        sneaker.add(new Bid("Tres", 3));
        sneaker.add(new Bid("Cuatro", 4));
        //Añado asks a la lista sneaker para comprobar que los asks no pasan el filtro de bids
        Ask ask = new Ask("Ochentamil", 80);
        sneaker.add(ask);
        sneaker.add(new Ask("Cinco", 20));
        sneaker.add(new Ask("Seis", 30));
        sneaker.add(new Ask("Siete", 40));
        sneaker.add(new Ask("Ocho", 50));

    }

    @Test

    public void filtroBidsTest() {
        assertFalse(asks.checkCriteria(this.sneaker).isEmpty());
        for (Offer offer : asks.checkCriteria(this.sneaker)) {
            assertNotNull(offer);
        }
        for (Offer offer : asks.checkCriteria(this.sneaker)) {
            assertNotNull(offer);
        }
        for (Offer offer : asks.checkCriteria(this.sneaker)) {
            assertTrue(offer instanceof Ask);
        }
        for (Offer offer : asks.checkCriteria(this.sneaker)) {
            assertFalse(offer instanceof Bid);
        }

    }
}
