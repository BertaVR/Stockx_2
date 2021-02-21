package edu.pingpong.domain.item;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BidTest {

    Offer bid = new Bid("Hola", 20);

    @Test
    public void toStringTest() {
        assertEquals("\n\t\t" + "Hola"+ "\t\t" + 20 ,
                bid.toString());
    }
}


