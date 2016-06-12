package com.djimenezc.linkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by david on 12/06/2016.
 */
public class EpicLinkedListDavidTest {

  private EpicLinkedListDavid<String> epicLinkedList;
  private EpicLinkedListDavid<String> expectList;

  @Before
  public void setUp() {
    epicLinkedList = new EpicLinkedListDavid<>(Arrays.asList("b", "c", "a", "d"));
    System.out.println("@Before - setUp");
  }

  @After
  public void tearDown() {
    expectList = null;
    System.out.println("@After - tearDown");
  }

  @Test
  public void testDeleteNodeInTheMiddle() throws Exception {

    String[] expectedArray = {"b", "c", "d"};

    EpicLinkedListDavid<String> currentList = epicLinkedList.deleteNode("a");

    assertEquals("The node has been removed successfully", expectedArray, currentList.toArray());

    currentList = epicLinkedList.deleteNode("c");
    String[] expectedArray2 = {"b", "d"};

    assertEquals("The node has been removed successfully", expectedArray2, currentList.toArray());
  }

  @Test
  public void testDeleteTail() throws Exception {

    String[] expectedArray = {"b", "c", "a"};

    EpicLinkedListDavid<String> currentList = epicLinkedList.deleteNode("d");

    assertEquals("The node has been removed successfully", expectedArray, currentList.toArray());
  }

  @Test
  public void testDeleteHead() throws Exception {

    String[] expectedArray = {"c", "a", "d"};

    EpicLinkedListDavid<String> currentList = epicLinkedList.deleteNode("b");

    assertEquals("The node has been removed successfully", expectedArray, currentList.toArray());
  }

  @Test
  public void testNodeWithValueRepeated() throws Exception {

    String[] expectedArray = {"b", "c", "a", "d"};
    epicLinkedList = new EpicLinkedListDavid<>(Arrays.asList("b", "b", "c", "a", "d"));

    EpicLinkedListDavid<String> currentList = epicLinkedList.deleteNode("b");

    assertEquals("The node has been removed successfully", expectedArray, currentList.toArray());
  }

  @Test
  public void testDeleteNodeNotInTheList() throws Exception {

    String[] expectedArray = {"b", "c", "a", "d"};

    EpicLinkedListDavid<String> currentList = epicLinkedList.deleteNode("z");

    assertEquals("The node has been removed successfully", expectedArray, currentList.toArray());
  }

  @Test
  public void testToArray() throws Exception {

    String[] expectedArray = {"b", "c", "a", "d"};

    assertEquals("The node has been removed successfully", expectedArray, epicLinkedList.toArray());
  }

}
