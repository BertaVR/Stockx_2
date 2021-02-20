package edu.pingpong.domain.item;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SaleTest {
    Sale sale = new Sale("ZZZ", 3);

    @Test
    public void toStringTest() {
        assertEquals("\n\t\t" + "ZZZ"+ "\t\t" + 3 ,
                sale.toString());
    }

}
