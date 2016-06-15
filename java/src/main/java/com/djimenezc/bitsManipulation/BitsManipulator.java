package com.djimenezc.bitsManipulation;

/**
 * Class to encode RGB colors in a 6 bits integer,
 * <p>
 * Created by david on 14/06/2016.
 */
class BitsManipulator {

  private static final int RED_MASK = 0b111111110000000000000000;
  private static final int GREEN_MASK = 0b000000001111111100000000;
  private static final int BLUE_MASK = 0b000000000000000011111111;

  /**
   * Encode a 24bits pixel that represents a RGB (Red Green Blue) color
   * into a 6 bits number
   *
   * @param colorInt 24 bits pixel
   * @return a 6 bits pixel representation
   */
  byte encodeRgbToSixBits(int colorInt) {

    /**
     * Having a 24 bits number that it might be split in three groups of two bytes
     * The encoding algorithm extracts the two bits with greater weight the group and
     * combine it in a new number with 6 bits.
     *
     */
    //using a binary mask it is get the number represented by bytes based on the position
    int encodedRed = (((colorInt) & RED_MASK) >> 16) >> 6;
    int encodedGreen = ((((colorInt)) & GREEN_MASK) >> 8) >> 6;
    int encodedBlue = ((colorInt) & BLUE_MASK) >> 6;

    //Combine bits of each color
    int encodedColor = encodedRed;
    encodedColor = (encodedColor << 2) + encodedGreen;
    encodedColor = (encodedColor << 2) + encodedBlue;

    return (byte) encodedColor;
  }

  /**
   * Given a 2 dimensional int array M*N
   * where each each cell represents a 24 bits number
   * returns a new array M'*N' with re-encoded 6 bits number.
   *
   * @param pixelColorMap 24bits pixel array of two dimensions
   * @return a table with the pixels re-encoded as 6 bits number
   */
  byte[][] encodeToSixBitsTable(int[][] pixelColorMap) {

    int nRows = pixelColorMap.length;
    int nColumns = pixelColorMap[0].length;

    byte[][] encodedColorTable = new byte[nRows][nColumns];

    for (int i = 0; i < nRows; i++) {
      for (int j = 0; j < nColumns; j++) {
        encodedColorTable[i][j] = this.encodeRgbToSixBits(pixelColorMap[i][j]);
      }
    }

    return encodedColorTable;
  }

}
