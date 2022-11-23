import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {


    @Test
    public void decimalToBinary() {

        assertEquals(101010, Main.decimalToBinary(42));
        assertEquals(10001, Main.decimalToBinary(17));
        assertEquals(11001, Main.decimalToBinary(25));
        assertEquals(100101100, Main.decimalToBinary(300));

    }

    @Test
    public void binaryToDecimal() {

        assertEquals(42, Main.binaryToDecimal(101010));
        assertEquals(17, Main.binaryToDecimal(10001));
        assertEquals(25, Main.binaryToDecimal(11001));
        assertEquals(300, Main.binaryToDecimal(100101100));

    }

}