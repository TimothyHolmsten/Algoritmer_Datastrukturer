package com.algo.F9;

/**
 * Created by timothy on 2017-02-14, com.algo.F9.
 */

/*
Skapa en klass Car som innehåller bilmärke, årsmodell och antal körda mil. Klassen ska implementera
Comparable<Car> och därmed ha en metod compareTo som ska jämföra bilmärke som sträng mellan
bilar.

a) Skriv ett program som läser in bilar från en textfil till en array och sorterar dessa med hjälp av Java
API utifrån metoden compareTo. Skriv sedan ut dessa till en ny textfilen.

b) Skapa nu en klass CompareCar som implementerar Comparator<Car> och använd denna för att
sortera bilarna efter årsmodell istället. Skriv även ut denna ordning men till en annan fil.
 */
public class Car implements Comparable<Car> {
    private String model;
    private int miles, yearModel;

    public Car(String model, int miles, int yearModel) {
        this.model = model;
        this.miles = miles;
        this.yearModel = yearModel;
    }

    @Override
    public int compareTo(Car o) {
        return model.compareTo(o.model);
    }

    @Override
    public String toString() {
        return model;
    }
}
