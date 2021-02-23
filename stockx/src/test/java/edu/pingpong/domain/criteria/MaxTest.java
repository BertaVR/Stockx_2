package edu.pingpong.domain.criteria;

import edu.pingpong.domain.item.Ask;
import edu.pingpong.domain.item.Bid;
import edu.pingpong.domain.item.Item;
import edu.pingpong.domain.item.Sneaker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MaxTest {

    Criteria criteria;

    Criteria otherCriteria;

    Item sneaker = new Sneaker("Hola", "Adios");

    Criteria max = new Max(criteria, otherCriteria);




    @Before

    public void setUpSneakers() {

        Bid bid = new Bid("Cero", 50);

        sneaker.add(bid);
        sneaker.add(new Bid("Uno", 1));
        sneaker.add(new Bid("Dos", 2));
        sneaker.add(new Bid("Tres", 3));
        sneaker.add(new Bid("Cuatro", 66));
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

    public void maxDifferentOffersTest() {

        Criteria asks = new Asks();
        Criteria sales = new Sales();
        Criteria max = new Max(asks, sales);

        assertTrue(max.checkCriteria(this.sneaker).isEmpty());
    }

    @Test

    public void minIncompatibleTest() {

        Criteria sales = new Sales();
        Criteria maxBid = new MaxBid();
        Criteria max = new Max(maxBid, sales);

        assertEquals(0,max.checkCriteria(this.sneaker).size());
    }



    @Test
    public void maxSameOfferTest() {

        Criteria bids = new Bids();
        Criteria maxBid = new MaxBid();
        Criteria max = new Max(maxBid, bids);

        assertEquals(66, max.checkCriteria(this.sneaker).get(0).value());
    }

    @Test

    public void maxCompatibleTest() {

        sneaker.add(new Ask("4", 20));
        sneaker.add(new Ask("4", 30));
        sneaker.add(new Ask("4", 40));
        sneaker.add(new Ask("4", 50));
        sneaker.add(new Ask("4", 50));


        Criteria asks = new Asks();
        Criteria size = new Size("4");
        Criteria min = new Max(asks, size);

        assertEquals(50, min.checkCriteria(this.sneaker).get(0).value());


    }
}
