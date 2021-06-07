package base;

import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 first_name last_name
 */

/*
 * Division isn’t always exact, and sometimes you’ll write programs that will need to deal with the leftovers as
 * a whole number instead of a decimal.
 *
 * Write a program to evenly divide pizzas. Prompt for the number of people, the number of pizzas, and the number
 * of slices per pizza. Ensure that the number of pieces comes out even. Display the number of pieces of pizza each
 * person should get. If there are leftovers, show the number of leftover pieces.
 * Example Output
 *
 * How many people? 8
 * How many pizzas do you have? 2
 * How many slices per pizza? 8
 * 8 people with 2 pizzas (16 slices)
 * Each person gets 2 pieces of pizza.
 * There are 0 leftover pieces.
 *
 * Challenges
 *
 *     Revise the program to ensure that inputs are entered as numeric values. Don’t allow the user to proceed if the value entered is not numeric.
 *     Alter the output so it handles pluralization properly, for example: "Each person gets 2 pieces of pizza." or "Each person gets 1 piece of pizza." Handle the output for leftover pieces appropriately as well.
 *     Create a variant of the program that prompts for the number of people and the number of pieces each person wants, and calculate how many full pizzas you need to purchase.
 *
 */

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        String numPpl = myApp.getNumPpl();
        String numPizzas = myApp.getNumPizzas();
        String numSlices = myApp.getNumSlices();
        String totalSlices = myApp.calcTotalSlices(numSlices, numPizzas);
        String slicesPerPerson = myApp.calcSlicesPerPerson(numPpl, totalSlices);
        String leftovers = myApp.calcLeftovers(totalSlices, numPpl, slicesPerPerson);
        String outputString = myApp.generateOutput(numPpl, numPizzas, numSlices, slicesPerPerson, leftovers);
        myApp.printOutput(outputString);
    }

    private String generateOutput(String numPpl, String numPizzas, String numSlices,
                                  String slicesPerPerson, String leftovers) {
        return numPpl + " people with " + slicesPerPerson + " pizzas (" + numSlices + " slices)\n" +
                                "Each person gets " + slicesPerPerson + " slices of pizza.\n" + "There are "
                                + leftovers + " leftover pizzas.";
    }

    private void printOutput(String outputString) {
        System.out.println(outputString);
    }

    private String getNumPpl() {
        System.out.print("How many people? ");
        String numPpl = in.nextLine();
        return numPpl;
    }

    private String getNumPizzas() {
        System.out.print("How many pizzas do you have? ");
        String numPizzas = in.nextLine();
        return numPizzas;
    }

    private String getNumSlices() {
        System.out.print("How many slices per pizza? ");
        String numSlices = in.nextLine();
        return numSlices;
    }

    private String calcTotalSlices(String numSlices, String numPizzas) {
        int totalSlices = Integer.parseInt(numSlices) * Integer.parseInt(numPizzas);
        return String.valueOf(totalSlices);
    }

    private String calcSlicesPerPerson(String numPpl, String numSlices) {
        int slicesPerPerson = Integer.parseInt(numSlices) / Integer.parseInt(numPpl);
        return String.valueOf(slicesPerPerson);
    }

    private String calcLeftovers(String totalSlices, String numPpl, String slicesPerPerson) {
        int leftovers = Integer.parseInt(totalSlices) - (Integer.parseInt(numPpl) * Integer.parseInt(slicesPerPerson));
        return String.valueOf(leftovers);
    }
}
