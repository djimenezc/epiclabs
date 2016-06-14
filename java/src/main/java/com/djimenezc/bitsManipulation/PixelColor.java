package com.djimenezc.bitsManipulation;

import java.util.Random;

/**
 * Created by david on 14/06/2016.
 */
public class PixelColor {

  private static int MIN = 0;
  private static int MAX = 255;

  private byte red;
  private byte green;
  private byte blue;

  @SuppressWarnings("WeakerAccess")
  PixelColor(byte red, byte green, byte blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  static PixelColor getRandomColor() {

    return new PixelColor(generateRandomByte(), generateRandomByte(), generateRandomByte());
  }

  private static byte generateRandomByte() {

    Random random = new Random();
    int range = MAX - MIN + 1;
    int value = random.nextInt() % range;

    return (byte) ((byte) MIN + value);
  }

  static int getUnsignedValue(byte value) {
    return value & 0xFF;
  }

  static PixelColor[][] generateRandomColorMap(int nRow, int nColumn) {

    PixelColor[][] pixelColorArray = new PixelColor[nRow][nColumn];

    for (int i = 0; i < nRow; i++) {
      for (int j = 0; j < nColumn; j++) {
        pixelColorArray[i][j] = PixelColor.getRandomColor();
      }
    }

    return pixelColorArray;
  }

  byte getRed() {
    return red;
  }

  byte getGreen() {
    return green;
  }

  byte getBlue() {
    return blue;
  }

  @Override
  public String toString() {
    return "Red: " + getUnsignedValue(this.getRed()) + " Green: " + getUnsignedValue(this.getGreen()) + " Blue: " + getUnsignedValue(this.getBlue());
  }
}
