package com.djimenezc;

/**
 * Created by david on 12/06/2016.
 */
public class Node<E extends Object> {

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

  public Node<E> getNextNode() {
    return nextNode;
  }

  public void setNextNode(Node<E> nextNode) {
    this.nextNode = nextNode;
  }
}
