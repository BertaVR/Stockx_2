package edu.pingpong.domain.item;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SaleTest {
    Offer sale = new Sale("ZZZ", 3);

    @Test
    public void toStringTest() {
        assertEquals("\n\t\t" + "ZZZ"+ "\t\t" + 3 ,
                sale.toString());
    }

}
