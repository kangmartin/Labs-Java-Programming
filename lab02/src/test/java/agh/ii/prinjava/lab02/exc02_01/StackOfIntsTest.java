package agh.ii.prinjava.lab02.exc02_01;

import agh.ii.prinjava.lab02.exc02_01.impl.LinkedListBasedImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackOfIntsTest {

    @Test
    public void testPushAndPop() {
        StackOfInts stack = new LinkedListBasedImpl();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPopOnEmptyStack() {
        StackOfInts stack = new LinkedListBasedImpl();
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    public void testPeekOnEmptyStack() {
        StackOfInts stack = new LinkedListBasedImpl();
        assertThrows(IllegalStateException.class, stack::peek);
    }

}
