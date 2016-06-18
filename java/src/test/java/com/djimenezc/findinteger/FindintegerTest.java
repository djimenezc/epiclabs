package com.djimenezc.findInteger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * Test to check that the delete node method works successfully
 * Created by david on 12/06/2016.
 */
public class FindIntegerTest {

  private FindIntegerJob findIntegerJob;

  @Before
  public void setUp() {
    findIntegerJob = new FindIntegerJob();
    System.out.println("@Before - setUp");
  }

  @After
  public void tearDown() {
    findIntegerJob = null;
    System.out.println("@After - tearDown");
  }

  @Test(expected = FileNotFoundException.class)
  public void testFileNotFound() throws Exception {

    findIntegerJob.findInteger("notFound.txt");
  }

  @Test
  public void testGenerateInputFile() throws Exception {

    Path currentRelativePath = Paths.get("");
    String filePath = currentRelativePath.toAbsolutePath().toString() + "/test.txt";
    File file = new File(filePath);

    int numberToIncludeInTheFile = (int) (5 * Math.pow(10, 7)) / 32;

    int intNotIncluded = findIntegerJob.generateRandomIntInFile(file, numberToIncludeInTheFile);

    System.out.println("integer not included " + intNotIncluded);
    file = new File(filePath);

    DataInputStream dataIn = new DataInputStream(new FileInputStream(file));

    while (dataIn.available() > 0) {
      int n = dataIn.readInt();
//      System.out.println(n);
      assertTrue("It is a positive integer " + n, n >= 0);
      assertTrue("It is the not included value " + n, n != intNotIncluded);
    }
  }

  @Test
  public void testIntegerFound() throws Exception {

    int integerNotInFile = findIntegerJob.findInteger("integers.txt");

    assertThat(integerNotInFile, not(-1));
  }

}
