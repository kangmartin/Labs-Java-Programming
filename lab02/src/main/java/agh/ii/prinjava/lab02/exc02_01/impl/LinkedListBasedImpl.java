package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

public class LinkedListBasedImpl implements StackOfInts {

    private Node first = null;
    private int numOfElems = 0;

    /**
     * A node in the linked list.
     */

    private static class Node {
        int elem;
        Node next;

        public Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }

    /**
     * **Pops** the top element off the stack and returns it.
     *
     */

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        int elem = first.elem;
        first = first.next;
        numOfElems--;

        return elem;
    }

    /**
     * **Pushes** an integer onto the top of the stack.
     *
     */

    @Override
    public void push(int x) {
        Node newNode = new Node(x, first);
        first = newNode;
        numOfElems++;
    }

    /**
     * **Checks if the stack is empty.**
     *
     */

    @Override
    public boolean isEmpty() {
        return numOfElems == 0;
    }

    /**
     * **Returns the number of elements in the stack.**
     *
     */

    @Override
    public int numOfElems() {
        return numOfElems;
    }

    /**
     * **Returns the top element of the stack without removing it.**
     *
     */

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return first.elem;
    }
}
