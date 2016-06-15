package com.djimenezc.bitsManipulation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test to verify that the BitsManipulator class encode RGB pixel color into a 6 bits pixel
 *
 * Created by david on 12/06/2016.
 */
public class BitsManipulatorTest {

  private BitsManipulator bitsManipulator;

  @Before
  public void setUp() {
    bitsManipulator = new BitsManipulator();
    System.out.println("@Before - setUp");
  }

  @After
  public void tearDown() {
    bitsManipulator = null;
    System.out.println("@After - tearDown");
  }

  @Test
  public void testEncodeToSixBits() throws Exception {

    //binary representation 00000000 00000011 11100111 RGB
    int valueToEncode = 999;
    assertEquals(bitsManipulator.encodeRgbToSixBits(valueToEncode), 0b000011);

    //binary representation 11111111 11111111 11111111
    valueToEncode = 16777215;
    assertEquals(bitsManipulator.encodeRgbToSixBits(valueToEncode), 0b111111);

    //binary representation 11111111 10111111 01111111
    valueToEncode = 16760703;
    assertEquals(bitsManipulator.encodeRgbToSixBits(valueToEncode), 0b111001);

    //binary representation 11111111 10111111 01111111
    valueToEncode = 16760703;
    assertEquals(bitsManipulator.encodeRgbToSixBits(valueToEncode), 0b111001);
  }

  @Test
  public void testConvertRGBArrayToSixBitsEncoding() throws Exception {

    int nRow = 10;
    int nColumn = 20;
    int[][] rgbColorTable = RgbColorHelper.generateRandomColorMap(nRow, nColumn);

    byte[][] sixBitsTable = bitsManipulator.encodeToSixBitsTable(rgbColorTable);

    assertNotNull(sixBitsTable);
    assertTrue(sixBitsTable.length == nRow && sixBitsTable[0].length == nColumn);
  }

}
