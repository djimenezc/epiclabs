package com.djimenezc.findInteger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;


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
  public void testFileFound() throws Exception {

    findIntegerJob.findInteger("integers.txt");
  }

  @Test
  public void testIntegerFound() throws Exception {

    int integerNotInFile = findIntegerJob.findInteger("integers.txt");

    assertThat(integerNotInFile, not(-1));
  }

}
