package agh.ii.prinjava.lab02.exc02_01;

/**
 * **Stack of integers - Abstract Data Type (ADT)**
 */

public interface StackOfInts {

    /**
     * **Pops** the top element off the stack and returns it.
     *
     * @return the top element of the stack
     * @throws IllegalStateException if the stack is empty
     */

    int pop() throws IllegalStateException;

    /**
     * **Pushes** an integer onto the top of the stack.
     *
     * @param x the integer to push onto the stack
     */

    void push(int x);

    /**
     * **Checks if the stack is empty.**
     *
     * @return true if the stack is empty, false otherwise
     */

    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * **Returns the number of elements in the stack.**
     *
     * @return the number of elements in the stack
     */

    int numOfElems();

    /**
     * **Returns the top element of the stack without removing it.**
     *
     * @return the top element of the stack
     * @throws IllegalStateException if the stack is empty
     */

    int peek() throws IllegalStateException;
}

