package com.djimenezc.linkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Double linked list that have no access to the list head.
 * <p>
 * Implement an algorithm that deletes a given node from a linked list.
 * Your algorithm will receive just the node to be deleted, and won't have access to linked list head.
 * <pre>
 * Ej: Given linked list: A -> B -> C -> D -> E
 * </pre>
 * your algorithm will be called as deleteNode(D) and resulting linked list should be A -> B-> C-> E
 * <p>
 * In this list implementation is kept a reference to the last added element to the list. The list can be looked over
 * because each node has a reference to previous and next node in the list.
 *
 * @author djimenezc
 */
class EpicLinkedListDavid<E extends Object> implements List {

  /**
   * Last node added to the list
   */
  private Node<E> tail;
  /**
   * Number of nodes in the list
   */
  private int nNodes;

  EpicLinkedListDavid(List<E> values) {

    this.nNodes = 0;

    this.addAll(values);
  }

  /**
   * Remove a node with an specific value and adjust the node references.
   *
   * @param value value to remove from the list
   * @return the current list
   */
  public EpicLinkedListDavid<E> deleteNode(E value) {

    //remove the tail node
    if (tail.getValue() == value) {
      tail = tail.getPreviousNode();
      tail.setNextNode(null);
      this.nNodes--;
    } else {

      Node<E> currentNode = tail.getPreviousNode();

      while (currentNode != null) {

        if (currentNode.getValue() == value) {
          currentNode.getNextNode().setPreviousNode(currentNode.getPreviousNode());
          if (currentNode.getPreviousNode() != null) {
            currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());
          }
          this.nNodes--;
          break;
        }
        currentNode = currentNode.getPreviousNode();
      }
    }

    return this;
  }

  @Override
  public int size() {
    return nNodes;
  }

  @Override
  public boolean isEmpty() {
    return nNodes == 0;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public Iterator iterator() {
    return null;
  }

  @Override
  public Object[] toArray() {

    Object[] array = new Object[this.nNodes];

    int index = this.nNodes - 1;
    Node<E> currentNode = tail;

    while (currentNode != null) {
      array[index--] = currentNode.getValue();
      currentNode = currentNode.getPreviousNode();
    }

    return array;
  }

  @Override
  public boolean add(Object o) {

    if (tail == null) {
      tail = new Node<>((E) o);
    } else {
      tail.setNextNode(new Node<>((E) o));
      tail.getNextNode().setPreviousNode(tail);
      tail = tail.getNextNode();
    }
    nNodes++;

    return true;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public boolean addAll(Collection c) {

    if (c != null) {
      for (Object value : c) {
        this.add(value);
      }
    }

    return true;
  }

  @Override
  public boolean addAll(int index, Collection c) {
    return false;
  }

  @Override
  public void clear() {

  }

  @Override
  public Object get(int index) {
    return null;
  }

  @Override
  public Object set(int index, Object element) {
    return null;
  }

  @Override
  public void add(int index, Object element) {

  }

  @Override
  public Object remove(int index) {
    return null;
  }

  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    return 0;
  }

  @Override
  public ListIterator listIterator() {
    return null;
  }

  @Override
  public ListIterator listIterator(int index) {
    return null;
  }

  @Override
  public List subList(int fromIndex, int toIndex) {
    return null;
  }

  @Override
  public boolean retainAll(Collection c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection c) {
    return false;
  }

  @Override
  public boolean containsAll(Collection c) {
    return false;
  }

  @Override
  public Object[] toArray(Object[] a) {
    return new Object[0];
  }
}
