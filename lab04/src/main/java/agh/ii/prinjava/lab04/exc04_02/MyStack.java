package agh.ii.prinjava.lab04.exc04_02;

import agh.ii.prinjava.lab04.exc04_02.impl.MyStackDLLBImpl;

public interface MyStack<E> {
    E pop() throws IllegalStateException;

    void push(E x);

    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    int numOfElems();

    E peek() throws IllegalStateException;

    /** Consider pros and cons of having a factory method in the interface */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}
