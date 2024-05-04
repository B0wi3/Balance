package bowie.balance.incomes;

import java.util.ArrayList;
import java.util.List;

public class IncomeManager {
    private List<Income> incomes;

    // Constructor
    public IncomeManager() {
        this.incomes = new ArrayList<>();
    }

    // Adds incomes inputted to the array list
    public void addIncome(String incType, double incValue) {
        Income newIncome = new Income(incType, incValue);
        incomes.add(newIncome);
        System.out.println("Income successfully added: " + newIncome);
    }

    public void listIncomes() {
        System.out.println("--- List of Incomes ---");
        for (Income income : incomes) {
            System.out.println(income);
        }
    }

    public double getTotalIncomes() {
        double total = 0.0;
        for (Income income : incomes) {
            total += income.getIncValue();
        }
        return total;
    }
}