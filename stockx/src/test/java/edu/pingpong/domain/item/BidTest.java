package edu.pingpong.domain.item;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BidTest {

    Bid bid = new Bid("Hola", 20);

    @Test
    public void toStringTest() {
        assertEquals("Bid: 20"  + '\n' +
                        "Size: Hola" ,
                bid.toString());
    }
}


