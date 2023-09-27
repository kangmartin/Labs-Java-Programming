package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayBasedImplTest {

    @Test
    public void testEmptyStack() {
        StackOfInts stack = new ArrayBasedImpl();

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushAndPop() {
        StackOfInts stack = new ArrayBasedImpl();

        // Push an element onto the stack.
        stack.push(1);

        // Pop the element off the stack and verify that it is the same element that we pushed on.
        assertEquals(1, stack.pop());

        // Verify that the stack is now empty.
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushAndPopMultipleElements() {
        StackOfInts stack = new ArrayBasedImpl();

        // Push multiple elements onto the stack.
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop the elements off the stack and verify that they are in the reverse order of which they were pushed.
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());

        // Verify that the stack is now empty.
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        StackOfInts stack = new ArrayBasedImpl();

        // Push an element onto the stack.
        stack.push(1);

        // Peek at the top element of the stack and verify that it is the element that we pushed on.
        assertEquals(1, stack.peek());

        // Verify that the stack is still not empty.
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPopOnEmptyStack() {
        StackOfInts stack = new ArrayBasedImpl();

        // Try to pop an element from an empty stack.
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    public void testPeekOnEmptyStack() {
        StackOfInts stack = new ArrayBasedImpl();

        // Try to peek at the top element of an empty stack.
        assertThrows(IllegalStateException.class, stack::peek);
    }
}

class ArrayBasedImpl implements StackOfInts {

    private int[] elements;
    private int numOfElems = 0;

    public ArrayBasedImpl() {
        elements = new int[16];
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
            int[] newElements = new int[elements.length * 2];
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
