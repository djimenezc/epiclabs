package com.djimenezc;

import java.util.LinkedList;

/**
 * Implement an algorithm that deletes a given node from a linked list.
 * Your algorithm will receive just the node to be deleted, and won't have access to linked list head.
 <pre>
 Ej: Given linked list: A -> B -> C -> D -> E
 </pre>
 your algorithm will be called as deleteNode(D) and resulting linked list should be A -> B-> C-> E
 * @author djimenezc
 */
class EpicLinkedListJava<E> extends LinkedList {

  EpicLinkedListJava<E> deleteNode(E node) {

    this.remove(node);

    return this;
  }
}
