package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.*;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class BidsTest {
    Sneaker sneaker;

    Bids bids = new Bids();



    @Before

    public void setUpSneakers(){
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

    public void filtroBidsTest(){
        assertFalse(bids.checkCriteria(this.sneaker).isEmpty());
        for (Offer offer : bids.checkCriteria(this.sneaker)){
            assertNotNull(offer);
        }
        for (Offer offer : bids.checkCriteria(this.sneaker)){
            assertTrue(offer instanceof Bid);
        }
        for (Offer offer : bids.checkCriteria(this.sneaker)){
            assertFalse(offer instanceof Ask);
        }

    }


}
