package agh.ii.prinjava.lab02.exc02_01;

import agh.ii.prinjava.lab02.exc02_01.impl.LinkedListBasedImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackOfIntsTest {

    @Test
    public void testPushAndPop() {
        StackOfInts stack = new LinkedListBasedImpl();

        // Push some elements onto the stack.
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
    public void testPopOnEmptyStack() {
        StackOfInts stack = new LinkedListBasedImpl();
        // Try to pop an element from an empty stack.
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    public void testPeekOnEmptyStack() {
        StackOfInts stack = new LinkedListBasedImpl();

        // Try to peek at the top element of an empty stack.
        assertThrows(IllegalStateException.class, stack::peek);
    }

}
