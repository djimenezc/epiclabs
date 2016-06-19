package com.djimenezc.random;

import java.util.Random;

/**
 * Helper class to generates random numbers
 * <p>
 * Created by david on 18/06/2016.
 */
public class RandomGeneratorUtil {

  public static int getRandomInteger(int min, int max) {

    Random random = new Random();
    int range = max - min + 1;

    return min + random.nextInt() % range;
  }

  /**
   * Converts a number interpreted as signed into a unsigned value
   *
   * @param value signed number
   * @return unsigned number
   */
  public static int getUnsignedInt(int value) {
    return value & 0xFF;
  }

  public static int getPositiveInt() {
    return Math.abs(RandomGeneratorUtil.getRandomInteger(0, (int) Math.pow(2, 16)));
  }
}
