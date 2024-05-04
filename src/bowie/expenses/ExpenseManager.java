package bowie.expenses;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenses;

    // Constructor
    public ExpenseManager() {
        this.expenses = new ArrayList<>();
    }

    // Adds expenses inputted to the array list
    public void addExpense(String expType, double expValue) {
        Expense newExpense = new Expense(expType, expValue);
        expenses.add(newExpense);
        System.out.println("Expense successfully added: " + newExpense);
    }

    public void listExpenses() {
        System.out.println("--- List of Expenses ---");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public double getTotalExpenses() {
        double total = 0.0;
        for (Expense expense : expenses) {
            total += expense.getExpValue();
        }
        return total;
    }
}
