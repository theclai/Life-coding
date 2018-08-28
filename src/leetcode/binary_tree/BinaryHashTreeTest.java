package leetcode.binary_tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinaryHashTreeTest {
    BinaryHashTree bht;
    @BeforeEach
    public void init(){
        bht=new BinaryHashTree();
        bht.set(8, 1);
        bht.set(6, 2);
        bht.set(7, 3);
        bht.set(9, 4);
        bht.set(5, 5);
    }
    @Test
    public void setTest(){
        Assertions.assertEquals(bht.root.key,8);
    }
    @Test
    public void getTest(){
        Assertions.assertEquals(bht.get(5),5);
        Assertions.assertEquals(bht.get(7),3);
    }
}
