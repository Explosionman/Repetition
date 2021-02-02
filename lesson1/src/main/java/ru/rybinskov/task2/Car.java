    package ru.rybinskov.task2;

/**
 * Комментарии по ошибкам:
 * 1) В классе Lorry была попытка унаследовать 2 интерфейса помимо родительского класса Car,
 *    но интерфейс может унаследовать только интерфейс (исправлено).
 *
 * 2) Модификатор доступа поля Engine engine класса Car необходимо сделать private,
 *    т.к. иначе будет возможность обратиться к полю через оператор точка("."),
 *    что не есть безопасно (исправлено).
 *
 * 3) Модификатор доступа метода start класса Car лучше сделать public, т.к. в случае,
 *    если в дальнейшем наша машина будет участвовать, допустим, в гонках и класс гонок будет
 *    находиться в другом пакете, машина не сможет стартовать (исправлено).
 *
 * 4) Класс Lorry не переопределил абстрактный метод родителя (исправлено).
 *
 * 5) Смотря на картину реально, машина не сможет двигаться без двигателя (использовать методы
 *    start, stop), также любая машина имеет цвет и название. В связи с этим, в абстрактный класс Car
 *    был добавлен конструктор для того, чтобы любой потомок был обязан указать эти аргументы при создании объекта.
 *
 * 6) Инсправлены орфографические ошибки.
 *
 *
 * Варианты оптимизации:
 * 1) В двух классах мы видим одинаковую реализацию метода move интерфейса Moveable, имеет смысл
 *    сделать метод дефолтным и указать эту реализацию в интерфесе.
 *
 * 2) Если в проекте не предусмотрены другие транспортные средства, которые будут использовать
 *    интерфесы Moveable и Stopable (например велосипеды, мотоциклы), то я не вижу смысла
 *    в существовании этих интерфейсов.
 *    Методы move и stop в этом случае проще указать в абстрактном классе Car, и , судя по этому коду,
 *    они будут не абстрактными.
 *
 */

interface Movable {
    default void move() {
        System.out.println("car is moving");
    }
}

interface Stoppable {
    void stop();
}

abstract class Car {
    private Engine engine;
    private String color;
    private String name;

    public Car(Engine engine, String color, String name) {
        this.engine = engine;
        this.color = color;
        this.name = name;
    }

    public void start() {
        System.out.println("Car starting");
    }

    abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class LightWeightCar extends Car implements Movable {

    public LightWeightCar(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    void open() {
        System.out.println("Car is open");
    }

}

class Lorry extends Car implements Movable, Stoppable {


    public Lorry(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    public void stop() {
        System.out.println("Car is stop");
    }

    @Override
    void open() {
        //todo
    }
}
