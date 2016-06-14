package com.djimenezc.bitsManipulation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PixelColorTest {

  public static final int MAX = 256;
  public static final int MIN = 0;

  @Before
  public void setUp() {
    System.out.println("@Before - setUp");
  }

  @After
  public void tearDown() {
    System.out.println("@After - tearDown");
  }

  @Test
  public void testGenerateRandomArray() throws Exception {

    PixelColor[][] randomColorMap = PixelColor.generateRandomColorMap(10, 20);

    assertNotNull(randomColorMap);
  }

  @Test
  public void testGetRandomColor() throws Exception {

    for (int i = 0; i < 100; i++) {

      PixelColor pixelColor = PixelColor.getRandomColor();
//      System.out.println(pixelColor.toString());

      assertTrue("pixel red byte should be lower than 255 and greater than 0", PixelColor.getUnsignedValue(pixelColor.getRed()) >= MIN && PixelColor.getUnsignedValue(pixelColor.getRed()) < MAX);
      assertTrue("pixel green byte should be lower than 255 and greater than 0", PixelColor.getUnsignedValue(pixelColor.getGreen()) >= MIN && PixelColor.getUnsignedValue(pixelColor.getGreen()) < MAX);
      assertTrue("pixel blue byte should be lower than 255 and greater than 0", PixelColor.getUnsignedValue(pixelColor.getBlue()) >= MIN && PixelColor.getUnsignedValue(pixelColor.getBlue()) < MAX);
    }

  }


}
