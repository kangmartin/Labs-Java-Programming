package agh.ii.prinjava.lab02.lst02_07;

public interface I4 {
    public default void m1() { // <- Modifier 'public' is redundant for interface methods
        System.out.println("I4.m1()");
    } // public is redundant

    /**
     * It is public, but NOT abstract (error: Illegal combination of modifiers: 'abstract' and 'default')
     */
    default void m2() {
        System.out.println("I4.m2()");
    }
}
