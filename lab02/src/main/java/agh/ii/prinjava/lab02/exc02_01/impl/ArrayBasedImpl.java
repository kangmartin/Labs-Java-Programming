package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

/**
 * **Array-based implementation of the StackOfInts interface.**
 *
 * This implementation uses a simple resizing strategy: the array is doubled whenever it becomes full, and it is halved whenever it becomes less than half full.
 */

public class ArrayBasedImpl implements StackOfInts {

    /**
     * The array that stores the elements of the stack.
     */

    private int[] elements;

    /**
     * The number of elements in the stack.
     */

    private int numOfElems = 0;

    /**
     * The initial size of the array.
     */

    private static final int INITIAL_CAPACITY = 16;

    /**
     * The growth factor of the array.
     */

    private static final double GROWTH_FACTOR = 2.0;

    public ArrayBasedImpl() {
        elements = new int[INITIAL_CAPACITY];
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        numOfElems--;
        return elements[numOfElems];
    }

    @Override
    public void push(int x) {
        if (numOfElems == elements.length) {
            // Resize the array if it is full.
            int[] newElements = new int[(int) (elements.length * GROWTH_FACTOR)];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }

        elements[numOfElems] = x;
        numOfElems++;
    }

    @Override
    public int numOfElems() {
        return numOfElems;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return elements[numOfElems - 1];
    }

    @Override
    public boolean isEmpty() {
        return numOfElems == 0;
    }
}
