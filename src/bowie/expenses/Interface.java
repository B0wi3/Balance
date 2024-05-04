package bowie.expenses;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Interface {
    private List<Expense> expenses;

    public Interface() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Scanner scanner) {
        System.out.println("Expense type: ");
        String expType = scanner.nextLine();

        System.out.println("Expense value: ");
        double expValue = Double.parseDouble(scanner.nextLine());

        Expense newExpense = new Expense(expType, expValue);
        expenses.add(newExpense);

        System.out.println("Expense succesfully added: " + newExpense);
    }

    public void listExpenses() {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- Select an operation ---");
        System.out.println("\n 1 - Add expense\n 2 - List expenses\n 3 - Exit\n 4 - Print options");

        while(running) {
            int option = Integer.parseInt(scanner.nextLine());

            switch(option) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    listExpenses();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                case 4:
                    System.out.println("\n 1 - Add expense\n 2 - List expenses\n 3 - Exit\n 4 - Print options");
                    break;
                default:
                    System.out.println("Invalid option. Try again: ");
                    break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Interface ui = new Interface();
        ui.showMenu();
    }
}
