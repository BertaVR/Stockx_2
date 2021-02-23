package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class MinTest {

    Criteria criteria;

    Criteria otherCriteria;

    Item sneaker = new Sneaker("Hola", "Adios");

    Criteria min = new Min(criteria, otherCriteria);




    @Before

    public void setUpSneakers() {

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


//COPIO Y PEGO LOS TESTS DE ANDCRITERIA PARA CHECKEAR QUE FUNCIONAN (SI FUNCIONAN AHÍ TENDRÍAN QUE FUNCIONAR AQUÍ)


    @Test

    public void minDifferentOffersTest() {

        Criteria bids = new Bids();
        Criteria sales = new Sales();
        Criteria min = new Min(bids, sales);

        assertTrue(min.checkCriteria(this.sneaker).isEmpty());
    }

    @Test

    public void minIncompatibleTest() {

        Criteria sales = new Sales();
        Criteria minAsk = new MinAsk();
        Criteria min = new Min(minAsk, sales);

        assertEquals(0,min.checkCriteria(this.sneaker).size());
    }

    @Test

    public void minSameOfferTest() {

        Criteria asks = new Asks();
        Criteria minAsk = new MinAsk();
        Criteria min = new Min(minAsk, asks);

        assertEquals(minAsk.checkCriteria(this.sneaker), min.checkCriteria(this.sneaker));

    }
}
