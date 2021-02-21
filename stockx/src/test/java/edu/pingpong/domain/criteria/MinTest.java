package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MinTest {

    Item sneaker;

    Min min = new Min();


    @Before

    public void setUpSneakers() {

        this.sneaker = new Sneaker("Hola", "Adios");

        Sale sale = new Sale("Cero", 50);

        sneaker.add(sale);
        sneaker.add(new Ask("Uno", 1));
        sneaker.add(new Sale("Dos", 2));
        sneaker.add(new Bid("Tres", 3));
        sneaker.add(new Sale("Cuatro", 4));
    }

    @Test // TENGO QUE TESTEAR QUE NO ENTREN VALORES NULOS, LA VERDAD ES QUE AHORA MISMO NO SÉ CÓMO HACERLO
    public void minTest() {
        for (Offer offer : min.checkCriteria(this.sneaker)) {
            assertNotNull(offer);
            assertEquals(1, offer.value());

        }
    }
}
