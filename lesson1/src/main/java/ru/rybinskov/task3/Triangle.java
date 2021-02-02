package ru.rybinskov.task3;

public class Triangle extends Figure{
    private double height;
    private double triangleBase;

    public Triangle(double height, double triangleBase) {
        this.height = height;
        this.triangleBase = triangleBase;
    }

    @Override
    public double calculateArea() {
        return (height * triangleBase) / 2;
    }
}
