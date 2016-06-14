package com.djimenezc.bitsManipulation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by david on 12/06/2016.
 */
public class BitsManipulationTest {

  private BitsManipulation bitsManipulation;

  @Before
  public void setUp() {
    bitsManipulation = new BitsManipulation();
    System.out.println("@Before - setUp");
  }

  @After
  public void tearDown() {
    bitsManipulation = null;
    System.out.println("@After - tearDown");
  }

  @Test
  public void testConvertRGBArrayToEightBitsEncoding() throws Exception {


  }

}
