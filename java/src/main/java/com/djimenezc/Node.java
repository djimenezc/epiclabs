package com.djimenezc;

/**
 * Created by david on 12/06/2016.
 */
public class Node<E> {

  private E value;
  private Node<E> previousNode;
  private Node<E> nextNode;

  public Node(E value) {
    this.value = value;
  }

  public E getValue() {
    return value;
  }

  public void setValue(E value) {
    this.value = value;
  }

  public Node<E> getPreviousNode() {
    return previousNode;
  }

  public void setPreviousNode(Node<E> previousNode) {
    this.previousNode = previousNode;
  }
}
