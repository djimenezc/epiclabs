package com.djimenezc.bitsManipulation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RgbColorHelperTest {

  //16777216
  private static final int MAX = 256 * 256 * 256;
  private static final int MIN = 0;

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

    int[][] randomColorMap = RgbColorHelper.generateRandomColorMap(10, 20);

    assertNotNull(randomColorMap);
  }

  @Test
  public void testGetRgbColor() throws Exception {

    int red = 0b11111111;
    int green = 0b11111111;
    int blue = 0b11111111;

    assertEquals(RgbColorHelper.getRgbColor(red, green, blue), 16777215);

    red = 0b00000000;
    green = 0b11111111;
    blue = 0b11111111;

    assertEquals(RgbColorHelper.getRgbColor(red, green, blue), 65535);

    red = 0b00000000;
    green = 0b00000000;
    blue = 0b11111111;

    assertEquals(RgbColorHelper.getRgbColor(red, green, blue), 255);

    red = 0b00000000;
    green = 0b11111111;
    blue = 0b00000000;

    assertEquals(RgbColorHelper.getRgbColor(red, green, blue), 65280);

    red = 0b11111111;
    green = 0b00000000;
    blue = 0b00000000;

    assertEquals(RgbColorHelper.getRgbColor(red, green, blue), 16711680);
  }

  @Test
  public void testGetRandomColor() throws Exception {

    for (int i = 0; i < 1000; i++) {

      int pixelColor = RgbColorHelper.getRandomColor();

      assertTrue("pixel color code should be in the correct range", pixelColor >= MIN && pixelColor < MAX);
    }

  }


}
