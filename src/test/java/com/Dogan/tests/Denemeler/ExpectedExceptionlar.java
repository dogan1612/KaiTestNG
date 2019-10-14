package com.Dogan.tests.Denemeler;

import org.testng.annotations.Test;

import java.io.IOException;

public class ExpectedExceptionlar {

    @Test(expectedExceptions = ArithmeticException.class)       // passed
    public void divisionWithException() {
        int i = 1 / 0;
    }

    @Test(expectedExceptions = { IOException.class })           // passed
    public void exceptionTestOne() throws Exception {
        throw new IOException();
    }

    @Test(expectedExceptions = { IOException.class, NullPointerException.class })   //failed
    public void exceptionTestTwo() throws Exception {
        throw new Exception();
    }


}
