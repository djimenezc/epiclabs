package com.djimenezc.findInteger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Given a file that contains 4 billions of non negative integers
 * (assume int: 4 bytes per number), write an algorithm that output
 * a single non negative integer that is not contained in the file.
 * Assume you have 1Gb of memory available for this.
 * <p>
 * Created by david on 18/06/2016.
 */
class FindIntegerJob {

  /**
   * @param fileName a file that contains integers
   * @return -1 if something went wrong in the searching
   * @throws FileNotFoundException
   */
  int findInteger(String fileName) throws FileNotFoundException {

    int result = -1;

    InputStream inputStream = this.getClass().getResourceAsStream("/" + fileName);

    if (inputStream == null) {
      throw new FileNotFoundException();
    }

    BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream));

    return result;
  }


}
