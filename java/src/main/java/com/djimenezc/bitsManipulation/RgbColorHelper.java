package com.djimenezc.bitsManipulation;

import com.djimenezc.random.RandomGeneratorUtil;

/**
 * Class that manages 24 bits numbers, RGB (Red Green Blue) pixel color
 * The firsts two bytes represent color blue,
 * the next two bytes represent color green and
 * the last two bytes represent color red
 * <p>
 * 2### 3### 4### 5### 6### 7###
 * Red------ Green---- Blue-----
 * <p>
 * Each color
 * Created by david on 14/06/2016.
 */
class RgbColorHelper {

  /**
   * Returns a RGB pixel as 24 bits number
   *
   * @return RGB number
   */
  static int getRandomColor() {

    return getRgbColor(generateRandomByte(), generateRandomByte(), generateRandomByte());
  }

  /**
   * Build a RGB pixel color as combination of 3 numbers
   *
   * @param red   color
   * @param green color
   * @param blue  color
   * @return RGB pixel color
   */
  static int getRgbColor(int red, int green, int blue) {

    int rgb = RandomGeneratorUtil.getUnsignedInt(red);
    rgb = (rgb << 8) + RandomGeneratorUtil.getUnsignedInt(green);
    rgb = (rgb << 8) + RandomGeneratorUtil.getUnsignedInt(blue);

    return rgb;
  }

  /**
   * Generates a random 8bits number
   *
   * @return 8 bits number
   */
  private static byte generateRandomByte() {

    return ((byte) RandomGeneratorUtil.getRandomInteger(0, 255));
  }

  static int[][] generateRandomColorMap(int nRow, int nColumn) {

    int[][] pixelColorArray = new int[nRow][nColumn];

    for (int i = 0; i < nRow; i++) {
      for (int j = 0; j < nColumn; j++) {
        pixelColorArray[i][j] = RgbColorHelper.getRandomColor();
      }
    }

    return pixelColorArray;
  }

}
