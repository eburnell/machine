package machine;

import java.util.Scanner;

public class CoffeeMachine {

    //initial variables
    public static int waterLevel = 400;
    public static int milkLevel = 540;
    public static int beanLevel = 120;
    public static int cupLevel = 9;
    public static int moneyLevel = 550;
    public static Scanner input = new Scanner(System.in);

    // Espresso
    final public static int waterForEspresso = 250;
    final public static int beansForEspresso = 16;
    final public static int priceForEspresso = 4;

    // Latte
    final public static int waterForLatte = 350;
    final public static int milkForLatte = 75;
    final public static int beansForLatte = 20;
    final public static int priceForLatte = 7;

    // Cappuccino
    final public static int waterForCappuccino = 200;
    final public static int milkForCappuccino = 100;
    final public static int beansForCappuccino = 12;
    final public static int priceForCappuccino = 6;


    public static void main(String[] args) {

        System.out.println("Write action (buy, fill, take, remaining, exit):");
        System.out.print("> ");
        String userChoice = input.nextLine();

        while (!userChoice.equals("exit")) {
            System.out.println();
            takeUserInput(userChoice);
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            System.out.print("> ");
            userChoice = input.nextLine();
        }
    }


    public static void takeUserInput(String in) {
        switch (in) {
            case "buy":
                System.out.println("What do you want to buy? " +
                        "1 - espresso, 2 - latte, 3 - cappuccino, " +
                        "back - to main menu:");
                System.out.print("> ");
                String choice = input.nextLine();
                if (!choice.equals("back")) {
                    int buyChoice = Integer.parseInt(choice);
                    if (buyChoice == 1) {
                        buyEspresso();
                    } else if (buyChoice == 2) {
                        buyLatte();
                    } else if (buyChoice == 3) {
                        buyCappuccino();
                    }
                }
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                printStats();
                break;
            default:
                break;
        }
    }

    public static void buyCappuccino() {
        if (waterForCappuccino < waterLevel &&
                milkForCappuccino < milkLevel &&
                beansForCappuccino < beanLevel &&
                cupLevel > 1) {
            waterLevel -= waterForCappuccino;
            milkLevel -= milkForCappuccino;
            beanLevel -= beansForCappuccino;
            cupLevel--;
            moneyLevel += priceForCappuccino;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            if (waterForCappuccino > waterLevel) {
                System.out.println("Sorry, not enough water!");
            } else if (milkForCappuccino > milkLevel) {
                System.out.println("Sorry, not enough milk!");
            } else if (beansForCappuccino > beanLevel) {
                System.out.println("Sorry, not enough beans!");
            } else if (cupLevel < 1) {
                System.out.println("Sorry, not enough cups!");
            }
        }
    }

    public static void buyLatte() {
        if (waterForLatte < waterLevel &&
                milkForLatte < milkLevel &&
                beansForLatte < beanLevel &&
                cupLevel > 1) {
            waterLevel -= waterForLatte;
            milkLevel -= milkForLatte;
            beanLevel -= beansForLatte;
            cupLevel--;
            moneyLevel += priceForLatte;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            if (waterForLatte > waterLevel) {
                System.out.println("Sorry, not enough water!");
            } else if (milkForLatte > milkLevel) {
                System.out.println("Sorry, not enough milk!");
            } else if (beansForLatte > beanLevel) {
                System.out.println("Sorry, not enough beans!");
            } else if (cupLevel < 1) {
                System.out.println("Sorry, not enough cups!");
            }
        }
    }

    public static void buyEspresso() {
        if (waterForEspresso < waterLevel &&
                beansForEspresso < beanLevel &&
                cupLevel > 1) {
            waterLevel -= waterForEspresso;
            beanLevel -= beansForEspresso;
            cupLevel--;
            moneyLevel += priceForEspresso;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            if (waterForEspresso > waterLevel) {
                System.out.println("Sorry, not enough water!");
            } else if (beansForEspresso > beanLevel) {
                System.out.println("Sorry, not enough beans!");
            } else if (cupLevel < 1) {
                System.out.println("Sorry, not enough cups!");
            }
        }
    }

    public static void fillMachine() {
        System.out.println("Write how many ml of water do you want to add:");
        System.out.print("> ");
        waterLevel += input.nextInt();

        System.out.println("Write how many ml of milk do you want to add:");
        System.out.print("> ");
        milkLevel += input.nextInt();

        System.out.println("Write how many grams of coffee beans do you want to add:");
        System.out.print("> ");
        beanLevel += input.nextInt();

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        System.out.print("> ");
        cupLevel += input.nextInt();
    }

    public static void takeMoney() {
        System.out.println("I gave you $" + moneyLevel);
        moneyLevel = 0;
    }

    public static void printStats() {
        System.out.println("The coffee machine has:");
        System.out.println(waterLevel + " of water");
        System.out.println(milkLevel + " of milk");
        System.out.println(beanLevel + " of coffee beans");
        System.out.println(cupLevel + " of disposable cups");
        System.out.println("$" + moneyLevel + " of money");
    }
}
