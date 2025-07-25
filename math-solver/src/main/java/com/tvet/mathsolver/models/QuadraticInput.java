package com.tvet.mathsolver.models;

public class QuadraticInput {
    private double a;
    private double b;
    private double c;

    // Getters and Setters are required for Spring to map JSON to this object
    public double getA() { return a; }
    public void setA(double a) { this.a = a; }
    public double getB() { return b; }
    public void setB(double b) { this.b = b; }
    public double getC() { return c; }
    public void setC(double c) { this.c = c; }
}
