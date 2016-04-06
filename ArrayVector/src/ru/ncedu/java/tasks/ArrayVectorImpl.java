package ru.ncedu.java.tasks;

import java.util.Arrays;
import java.lang.Math;

public class ArrayVectorImpl implements ArrayVector {

    public double[] elements;

    @Override
    public void set(double... elements) {
        this.elements = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            this.elements[i] = elements[i];
        }
    }

    @Override
    public double[] get() {
        return this.elements;
    }

    @Override
    public ArrayVector clone() {
        ArrayVector newVector = new ArrayVectorImpl();
        newVector.set(elements);
        return newVector;
    }

    @Override
    public int getSize() {
        return this.elements.length;
    }

    @Override
    public void set(int index, double value) {
        if ((index >= 0) && (index < getSize())) {
            this.elements[index] = value;
        } else if (index >= getSize()) {
            double a[] = new double[index + 1];
            for (int i = 0; i < getSize(); i++) {
                a[i] = this.get()[i];
            }
            for (int i = getSize(); i < index; i++) {
                a[i] = 0;
            }
            a[index] = value;
            set(a);
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        if ((index >= 0) && (index < getSize())) {
            return this.elements[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public double getMax() {
        double max = elements[0];
        for (int i = 1; i < getSize(); i++) {
            if (this.elements[i] > max) {
                max = this.elements[i];
            }
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = elements[0];
        for (int i = 1; i < getSize(); i++) {
            if (this.elements[i] < min) {
                min = this.elements[i];
            }
        }
        return min;
    }

    @Override
    public void sortAscending() {
        Arrays.sort(this.elements);
    }

    @Override
    public void mult(double factor) {
        for (int i = 0; i < getSize(); i++) {
            set(i, this.elements[i] * factor);
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        int minSize = Math.min(this.getSize(), anotherVector.getSize());
        for (int i = 0; i < minSize; i++) {
            set(i, this.elements[i] + anotherVector.get(i));
        }
        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        double result = 0;
        int minSize = Math.min(this.getSize(), anotherVector.getSize());
        for (int i = 0; i < minSize; i++) {
            result += this.elements[i] * anotherVector.get(i);
        }
        return result;
    }

    @Override
    public double getNorm() {
        double result = 0;
        for (int i = 0; i < getSize(); i++) {
            result += this.elements[i] * this.elements[i];
        }
        return Math.sqrt(result);
    }
}
