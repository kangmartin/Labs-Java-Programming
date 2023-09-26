package agh.ii.prinjava.lab02.lst02_09;

public class C33 {
    private I31 i31; // Loosely coupling

    public C33(I31 i31) {
        this.i31 = i31;
    }

    void run() {
        i31.m1();
    }
}
