package com.testing.pm;

import com.tests.pm.DemoTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsingTest {
    @Test
    public void test01(){
        int n = 3;
        boolean e = true;
        boolean a = DemoTest.isEven(n);
        Assertions.assertEquals(e, a);
    }
    @Test
    public void test02(){
        int n = 2;
        boolean e = true;
        boolean a = DemoTest.isEven(n);
        Assertions.assertEquals(e, a);
    }
}
