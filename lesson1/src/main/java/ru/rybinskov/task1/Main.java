package ru.rybinskov.task1;

public class Main {
    public static void main(String[] args) {
        Person constructorPerson = new Person("Alex", "Asd", "Dsa", "Russia", "Moscow", "n/a", 31, "M");
        Person builderPerson = new Person.Builder()
                .firstName("Alex")
                .lastName("Fisher")
                .middleName("Sergeevich")
                .phone("7894555444")
                .address("Zelenograd")
                .age(31)
                .country("Russia")
                .gender("M")
                .build();

        System.out.println(constructorPerson.toString());
        System.out.println(builderPerson.toString());
    }
}
