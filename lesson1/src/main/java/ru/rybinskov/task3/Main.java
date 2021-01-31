package ru.rybinskov.task3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figure> figureList = new ArrayList<>();

        Figure circle = new Circle(5);
        Figure square = new Square(11);
        Figure triangle = new Triangle(6, 14);

        figureList.add(circle);
        figureList.add(square);
        figureList.add(triangle);

        System.out.println("Создано фигур: " + figureList.size());

        System.out.println("Площадь круга: " + circle.calculateArea());
        System.out.println("Площадь квадрата: " + square.calculateArea());
        System.out.println("Площадь треугольника: " + triangle.calculateArea());
    }
}
