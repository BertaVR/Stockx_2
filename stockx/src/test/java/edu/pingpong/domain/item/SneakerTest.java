package edu.pingpong.domain.item;

import org.junit.Before;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SneakerTest {

    Item sneaker = new Sneaker("Jordan", "hola");



    @Before
    public void setUpSneaker(){
        List<Offer> offers = new ArrayList<Offer>();

        Sneaker sneaker = new Sneaker("Jordan", "hola");
        sneaker.getSale();
    }

    @Test
    public void toStringTest() {
        assertEquals('\t' + "Jordan" + '\n' +
                '\t' + "hola" + '\n' +
                '\t' + "last sale: 0", sneaker.toString());
    }



}
