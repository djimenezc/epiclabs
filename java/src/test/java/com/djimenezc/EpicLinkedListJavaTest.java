package com.djimenezc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by david on 12/06/2016.
 * Testing if the epicLinkedList utility performs the delete operation successfully
 */
public class EpicLinkedListJavaTest {

  private EpicLinkedListJava<String> epicLinkedList;
  private EpicLinkedListJava<String> expectList;

  @Before
  public void setUp() {
    epicLinkedList = new EpicLinkedListJava<>();
    epicLinkedList.addAll(Arrays.asList("b", "c", "a", "d"));
    System.out.println("@Before - setUp");
  }

  @After
  public void tearDown() {
    expectList = null;
    System.out.println("@After - tearDown");
  }

  @Test
  public void testDeleteNode() throws Exception {

    List<String> expectList = new LinkedList<>(Arrays.asList("b", "c", "d"));

    EpicLinkedListJava<String> currentList = epicLinkedList.deleteNode("a");

    assertEquals("The node has been removed successfully", expectList, currentList);
  }

  @Test
  public void testDeleteNodeNotInTheList() throws Exception {

    expectList = new EpicLinkedListJava<>();
    expectList.addAll(Arrays.asList("b", "c", "a", "d"));

    EpicLinkedListJava<String> currentList = epicLinkedList.deleteNode("z");

    assertEquals("The node has been removed successfully", expectList, currentList);
  }

}
