package edu.pingpong.domain.item;

import org.junit.Before;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SneakerTest {

    Sneaker sneaker = new Sneaker("Jordan", "hola");
    List<Offer> offers = new ArrayList<Offer>();



    @Before
    public void setUpSneaker(){
        Sneaker sneaker = new Sneaker("Jordan", "hola");
        sneaker.getSale();
    }

    @Test
    public void toStringTest() {
        assertEquals("Jordan" + '\n' +
                "hola" + '\n' +
                "last sale: 0", sneaker.toString());
    }



}
