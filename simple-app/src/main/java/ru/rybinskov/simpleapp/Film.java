package ru.rybinskov.simpleapp;

public class Film {
    private String description;

    public Film() {
    }

    public Film(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Film{" +
                "description='" + description + '\'' +
                '}';
    }
}
