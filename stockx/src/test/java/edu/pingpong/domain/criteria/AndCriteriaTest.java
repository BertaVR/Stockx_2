package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class AndCriteriaTest {

    Criteria criteria;

    Criteria otherCriteria;

    Criteria andCriteria = new AndCriteria(criteria, otherCriteria);

    Item sneaker = new Sneaker("Hola", "Adios");


    @Before

    public void setUpSneakers() {
        //Añado ofertas bid a sneaker

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

    public void andCriteriaDifferentOffersTest() {

        Criteria bids = new Bids();
        Criteria sales = new Sales();
        Criteria andCritera = new AndCriteria(bids, sales);

        assertTrue(andCritera.checkCriteria(this.sneaker).isEmpty());
    }

    @Test

    public void andCriteriaIncompatibleTest() {

        Criteria sales = new Sales();
        Criteria minAsk = new MinAsk();
        Criteria andCritera = new AndCriteria(minAsk, sales);

        assertTrue(andCritera.checkCriteria(this.sneaker).isEmpty());
    }

    @Test

    public void andCriteriaSameOfferTest() {

        Criteria asks = new Asks();
        Criteria minAsk = new MinAsk();
        Criteria andCritera = new AndCriteria(asks, minAsk);

        assertEquals(minAsk.checkCriteria(this.sneaker), andCritera.checkCriteria(this.sneaker));

    }

    @Test

    public void andCriteriaCompatibleTest() {

        sneaker.add(new Ask("4", 20));
        sneaker.add(new Ask("4", 30));
        sneaker.add(new Ask("4", 40));
        sneaker.add(new Ask("4", 50));
        sneaker.add(new Ask("4", 50));


        Criteria asks = new Asks();
        Criteria size = new Size("4");
        Criteria andCritera = new AndCriteria(asks, size);

        assertEquals(5, andCritera.checkCriteria(this.sneaker).size());

        for (Offer offer : andCritera.checkCriteria(this.sneaker)) {
            assertEquals("4", offer.size());

        }
    }

}
