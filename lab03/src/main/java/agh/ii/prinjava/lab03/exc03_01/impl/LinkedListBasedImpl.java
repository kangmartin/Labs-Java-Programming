package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;

public class LinkedListBasedImpl implements QueueOfInts {

    @Override
    public void enqueue(int x) {
        Node newNode = new Node(x, null, first);
        if (first != null) {
            first.prev = newNode;
        } else {
            last = newNode;
        }
        first = newNode;
        numOfElems++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty!");
        }
        int value = last.elem;
        last = last.prev;
        if (last != null) {
            last.next = null;
        } else {
            first = null; // List is empty now
        }
        numOfElems--;
        return value;
    }

    @Override
    public int numOfElems() {
        return numOfElems;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty!");
        }
        return last.elem;
    }

    private static class Node {
        int elem;
        Node next;
        Node prev;

        public Node(int elem) {
            this.elem = elem;
        }

        public Node(int elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node first = null;
    private Node last = null;

    private int numOfElems = 0;
}
