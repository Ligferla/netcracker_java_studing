package ru.ncedu.java.tasks;

public interface ArrayVector {

    /**
     * Задает все элементы вектора (определяет длину вектора). Передаваемый
     * массив не клонируется.
     *
     * @param elements Не равен null
     */
    void set(double... elements);

    double[] get();

    ArrayVector clone();

    int getSize();

    void set(int index, double value);

    double get(int index) throws ArrayIndexOutOfBoundsException;

    double getMax();

    double getMin();

    void sortAscending();

    void mult(double factor);

    ArrayVector sum(ArrayVector anotherVector);

    double scalarMult(ArrayVector anotherVector);

    double getNorm();
}
