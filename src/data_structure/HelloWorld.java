package data_structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloWorld {
    HelloWorld helloWorld;

    @BeforeEach
    public void init() {
        helloWorld=new HelloWorld();
    }

    @Test
    public void testPingPong(){
        Assertions.assertEquals(2,2);
    }


}
