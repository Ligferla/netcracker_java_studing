package com.netcracker.edu.java.tasks;

import static java.lang.Double.parseDouble;
import java.util.Arrays;

public class ComplexNumberImpl implements ComplexNumber {

    private double re;
    private double im;

    public ComplexNumberImpl() {
        this.re = 0.0;
        this.im = 0.0;
    }

    public ComplexNumberImpl(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public double getRe() {
        return this.re;
    }

    @Override
    public double getIm() {
        return this.im;
    }

    @Override
    public boolean isReal() {
        return this.im == 0;
    }

    @Override
    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {
        String r = "";
        String i = "";
        int j = 0;

        if ((value.charAt(0) != '-') && (value.charAt(0) != '+') && (value.charAt(0) != 'i') && !(('0' <= value.charAt(0)) && (value.charAt(0) <= '9'))) {
            throw new NumberFormatException();
        }
        if ((value.charAt(0) == '-') || (value.charAt(0) == '+')) {
            r += value.charAt(0);
            j++;
        }
        if (value.charAt(0) == 'i') {
            if (value.length() == 1) {
                this.re = 0;
                this.im = 1;
                return;
            }
        }
        while ((j <= value.length() - 1) && (value.charAt(j) != '-') && (value.charAt(j) != '+')
                && (value.charAt(j) != 'i')) {
            if (('0' <= value.charAt(j)) && (value.charAt(j) <= '9') || (value.charAt(j) == '.')) {
                r += value.charAt(j);
            } else {
                throw new NumberFormatException();
            }
            j++;
        }
        if (j == value.length()) {
            this.re = parseDouble(r);
            return;
        }

        if (value.charAt(j) == 'i') {
            if (j != value.length() - 1) {
                throw new NumberFormatException();
            } else {
                if (r.equals("+") || r.equals("-")) {
                    r += "1";
                }
                this.im = parseDouble(r);
                this.re = 0;
                return;
            }
        } else {// + - и снова while
            if ((value.charAt(j) == '-') || (value.charAt(j) == '+')) {
                i += value.charAt(j);
                j++;
            }
            while ((value.charAt(j) != 'i') && (j != value.length() - 1)) {
                if (('0' <= value.charAt(j)) && (value.charAt(j) <= '9') || (value.charAt(j) == '.')) {
                    i += value.charAt(j);
                    j++;
                } else {
                    throw new NumberFormatException();
                }
            }
            if (value.charAt(j) == 'i') {
                if (j != value.length() - 1) {
                    throw new NumberFormatException();
                }
                if (i.equals("+") || (i.equals("-"))) {
                    this.re = parseDouble(r);
                    i += "1";
                    this.im = parseDouble(i);
                    return;
                }
            }
        }

        this.re = parseDouble(r);
        this.im = parseDouble(i);
    }

    @Override
    public ComplexNumber copy() {
        ComplexNumber newComplexNumber = new ComplexNumberImpl(this.re, this.im);
        return newComplexNumber;
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
//        ComplexNumber newComplexNumber = new ComplexNumberImpl(this.re, this.im);
        return (ComplexNumber) super.clone();
    }

    @Override
    public String toString() {
        String s = "";
        if (this.re != 0) {
            s += Double.toString(this.re);
        }
        if (this.im != 0) {
            if ((this.im > 0) && (this.re != 0)) {
                s += '+';
            }
            s += Double.toString(this.im) + 'i';
        }
        if ((this.re == 0) && (this.im == 0)) {
            s = "0.0";
        }
        return s;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof ComplexNumber) {
            ComplexNumber c = (ComplexNumber) other;
            return (this.re == c.getRe() && this.im == c.getIm());
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(ComplexNumber other) {
        Double a = this.re * this.re + this.im * this.im;
        Double b = other.getRe() * other.getRe() + other.getIm() * other.getIm();
        return a.compareTo(b);
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array);
    }

    @Override
    public ComplexNumber negate() {
        this.re *= -1;
        this.im *= -1;
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        this.re += arg2.getRe();
        this.im += arg2.getIm();
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        double r = this.re * arg2.getRe() - this.im * arg2.getIm();
        double i = this.im * arg2.getRe() + this.re * arg2.getIm();
        this.re = r;
        this.im = i;
        return this;
    }
}
