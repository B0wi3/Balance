package bowie.expenses;

import java.util.Scanner;

public class Interface {
    private ExpenseManager expenseManager;
    private IncomeManager incomeManager;
    public Scanner scanner;

    // Constructor
    public Interface() {
        this.expenseManager = new ExpenseManager();
        this.incomeManager = new IncomeManager();
        this.scanner = new Scanner(System.in);
    }

    // Menu
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- Select an operation ---");
        System.out.println("\n 1 - Add expense\n 2 - List expenses\n 3 - Add income\n 4 - List incomes");
        System.out.println(" 5 - Show balance\n 6 - Exit\n 7 - Print options");

        // Infinite loop, for continuous user input
        while(running) {
            int option = Integer.parseInt(scanner.nextLine());

            switch(option) {
                case 1:
                    handleAddExpense(scanner);
                    break;
                case 2:
                    handleListExpenses();
                    break;
                case 3:
                    handleAddIncome(scanner);
                    break;
                case 4:
                    handleListIncomes();
                    break;
                case 5:
                    showBalance();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                case 7:
                    System.out.println("\n 1 - Add expense\n 2 - List expenses\n 3 - Exit\n 4 - Print options");
                    break;
                default:
                    System.out.println("Invalid option. Try again: ");
                    break;
            }
        }
        scanner.close();
    }

    // Adds user input as expense, passing as argument to original addExpense method
    private void handleAddExpense(Scanner scanner) {
        System.out.println("Enter expense type:");
        String expType = scanner.nextLine();

        double expValue = readDoubleInput("Enter expense value:");
        expenseManager.addExpense(expType, expValue);
    }

    private void handleListExpenses() {
        expenseManager.listExpenses();
    }

    // Adds user input as income, passing as argument to original addIncome method
    private void handleAddIncome(Scanner scanner) {
        System.out.println("Enter income type:");
        String incomeType = scanner.nextLine();

        double incomeValue = readDoubleInput("Enter income value:");
        incomeManager.addIncome(incomeType, incomeValue);
    }

    // Ensures proper input for expense/income value, also removing possible blank spaces from the input
    private double readDoubleInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private void handleListIncomes() {
        incomeManager.listIncomes();
    }

    // Calculates balance, subtracting expenses from incomes
    private void showBalance() {
        double totalExpenses = expenseManager.getTotalExpenses();
        double totalIncomes = incomeManager.getTotalIncomes();
        double balance = totalIncomes - totalExpenses;

        System.out.println("--- Balance ---");
        System.out.println("Total Incomes: " + totalIncomes);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        Interface ui = new Interface();
        ui.start();
    }
}
