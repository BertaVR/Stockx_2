
package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxBidTest {

    Criteria Bids;

    Item sneaker;

    Criteria maxBid = new MaxBid();

    @Before

    public void setUpSneakers() {
        //Añado ofertas bid a sneaker
        this.sneaker = new Sneaker("Hola", "Adios");

        Sale sale = new Sale("Cero", 50);

        sneaker.add(sale);
        sneaker.add(new Ask("Uno", 100));
        sneaker.add(new Sale("Dos", 2));
        sneaker.add(new Bid("Tres", 5));
        sneaker.add(new Sale("Cuatro", 400));
        sneaker.add(new Sale("Cuatro", 500));
        sneaker.add(new Sale("Cuatro", 100));
        sneaker.add(new Sale("Cuatro", 400));
        sneaker.add(new Sale("Cuatro", 700));
        sneaker.add(new Ask("Cuatro", 1));
        sneaker.add(new Ask("Cuatro", 2));
        sneaker.add(new Bid("Tres", 56));
        sneaker.add(new Bid("Tres", 57));
        sneaker.add(new Bid("Tres", 59));




    }

    @Test // TENGO QUE TESTEAR QUE NO ENTREN VALORES NULOS, LA VERDAD ES QUE AHORA MISMO NO SÉ CÓMO HACERLO
    public void minTest() {
        for (Offer offer : maxBid.checkCriteria(this.sneaker)) {
            assertNotNull(offer);
            assertTrue(offer instanceof Bid);
            assertEquals(59, offer.value());

        }
    }
}

