package com.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SampleHardAssertions {

    @Test
    public void test0(){
        try{
            Assert.assertTrue(2<1);
            System.out.println("Assertion Failed in Test 1");
            Assert.assertFalse(1>0);
            System.out.println("Assertion Failed in Test 1");
            Assert.assertEquals("Sample", "Sample");
            System.out.println("Assertion Passed in Test 1");
        } catch(AssertionError ae){
            ae.printStackTrace();
        }
    }

 //   @Test
    public void test1() throws AssertionError {
        Assert.assertTrue(2<1);
        System.out.println("Hi");
    }

    @Test
    public void test2(){
        try{
            Assert.assertTrue(2>1);
            System.out.println("Assertion passed in Test 2");
            Assert.assertFalse(1<0);
            System.out.println("Assertion passed in Test 2");
            Assert.assertEquals("Sample", "Sample");
            System.out.println("Assertion Passed in Test 2");
        } catch(AssertionError ae){
            ae.printStackTrace();
        }
    }

    @Test
    public void softAssertTest() {
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(2,2,"Error on 1st validation");
        soft.assertEquals(1,1,"Error on 2nd validation");
        soft.assertEquals(1,2,"Error on 3rd validation");
        soft.assertEquals(2,1,"Error on 4th validation");
        soft.assertAll();

    }
}