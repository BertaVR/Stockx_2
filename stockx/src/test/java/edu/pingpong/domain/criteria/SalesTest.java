package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class SalesTest {
    Item sneaker;

    Criteria sales = new Sales();


    @Before

    public void setUpSneakers() {
        //Añado ofertas sale a sneaker
        this.sneaker = new Sneaker("Hola", "Adios");

        Sale sale = new Sale("Cero", 50);

        sneaker.add(sale);
        sneaker.add(new Sale("Uno", 1));
        sneaker.add(new Sale("Dos", 2));
        sneaker.add(new Sale("Tres", 3));
        sneaker.add(new Sale("Cuatro", 4));
        //Añado asks a la lista sneaker para comprobar que los asks no pasan el filtro de sales
        Ask ask = new Ask("Ochentamil", 80);
        sneaker.add(ask);
        sneaker.add(new Ask("Cinco", 20));
        sneaker.add(new Ask("Seis", 30));
        sneaker.add(new Ask("Siete", 40));
        sneaker.add(new Ask("Ocho", 50));

    }

    @Test

    public void filtroBidsTest() {
        assertFalse(sales.checkCriteria(this.sneaker).isEmpty());

        for (Offer offer : sales.checkCriteria(this.sneaker)) {

            assertNotNull(offer);

            assertTrue(offer instanceof Sale);

            assertFalse(offer instanceof Ask);
        }

    }
}
