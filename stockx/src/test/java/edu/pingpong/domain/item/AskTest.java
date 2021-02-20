package edu.pingpong.domain.item;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AskTest {
    Ask ask = new Ask("Pato", 155);

    @Test
    public void toStringTest() {
        Assert.assertEquals("\n\t\t" + "Pato"+ "\t\t" + 155 ,
                ask.toString());
    }
}
