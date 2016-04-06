package com.netcracker.edu.java.tasks;

import java.util.Arrays;

public interface ComplexNumber extends Comparable<ComplexNumber>, Cloneable {

    double getRe();

    double getIm();

    boolean isReal();

    void set(double re, double im);

    void set(String value) throws NumberFormatException;

    ComplexNumber copy();

    ComplexNumber clone() throws CloneNotSupportedException;

    @Override
    String toString();

    @Override
    boolean equals(Object other);
//Ordering methods

    @Override
    int compareTo(ComplexNumber other);

    void sort(ComplexNumber[] array);

    ComplexNumber negate();

    ComplexNumber add(ComplexNumber arg2);

    ComplexNumber multiply(ComplexNumber arg2);
}
