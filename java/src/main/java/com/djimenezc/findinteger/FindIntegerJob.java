package com.djimenezc.findInteger;

import com.djimenezc.random.RandomGeneratorUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.BitSet;

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
   * Find a integer no included in the file.
   * Using a bit vector, for each number read from the input, set the corresponding bit to '1'.
   * It is needed to allocate 2^16 bits
   * Once it done, iterate over the bits, find the first one that is still '0'.
   * Its index of tha element with value 0 is returned.
   *
   * @param fileName a file that contains integers
   * @return -1 if something went wrong in the searching, if not return the first integer not
   * include in the file
   * @throws FileNotFoundException
   */
  int findInteger(String fileName) throws IOException {

    int result = -1;

    Path currentRelativePath = Paths.get("");
    String filePath = currentRelativePath.toAbsolutePath().toString() + "/" + fileName;
    File file = new File(filePath);

    if (!file.isFile()) {
      throw new FileNotFoundException();
    }

    int numberOfNonNegativeInt = (int) Math.pow(2, 16);
    BitSet integersVisited = new BitSet(numberOfNonNegativeInt);

    DataInputStream dataIn = new DataInputStream(new FileInputStream(file));

    while (dataIn.available() > 0) {

      int value = dataIn.readInt();
      integersVisited.set(value, true);
    }

    for (int index = 0; index < numberOfNonNegativeInt; index++) {

      if (!integersVisited.get(index)) {
        result = index;
        break;
      }
    }

    dataIn.close();

    return result;
  }

  /**
   * Generates a file with numberInteger non negative integers
   * will be not included in the file
   *
   * @param file           input file where the number will be stored
   * @param numberIntegers number of integers to include in the file
   * @return the number not included in the file
   */
  int generateRandomIntInFile(File file, int numberIntegers) throws IOException {

    System.out.println("Creating file " + file.getAbsolutePath());

    int intNotToIncludeInFile = RandomGeneratorUtil.getRandomInteger(0, (int) Math.pow(2, 16));

    DataOutputStream writer = new DataOutputStream(new FileOutputStream(file));

    writer.write("".getBytes());

    int index;

    for (index = 0; index < numberIntegers; index++) {

      int value = RandomGeneratorUtil.getPositiveInt();

      if (value == intNotToIncludeInFile) {
        value++;
      }
      writer.writeInt(value);
    }

    long fileSizeMB = file.length() / (1024 * 1024);
    System.out.println("Added " + index + " numbers in the file " + file.getAbsolutePath() + " file size: " + fileSizeMB + " MB");
    writer.close();

    return intNotToIncludeInFile;
  }


}
