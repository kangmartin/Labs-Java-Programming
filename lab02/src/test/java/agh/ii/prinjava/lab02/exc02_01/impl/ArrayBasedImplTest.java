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
        stack.push(1);
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushAndPopMultipleElements() {
        StackOfInts stack = new ArrayBasedImpl();
        stack.push(1);
        stack.push(2);
        stack.push(3);


        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        StackOfInts stack = new ArrayBasedImpl();

        stack.push(1);

        assertEquals(1, stack.peek());

        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPopOnEmptyStack() {
        StackOfInts stack = new ArrayBasedImpl();

        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    public void testPeekOnEmptyStack() {
        StackOfInts stack = new ArrayBasedImpl();

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
