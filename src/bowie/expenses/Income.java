package bowie.expenses;

public class Income {
    private String incType;
    private double incValue;

    // Constructor
    public Income(String incType, double incValue) {
        this.incType = incType;
        this.incValue = incValue;
    }

    public String getIncType() {
        return incType;
    }

    public double getIncValue() {
        return incValue;
    }

    @Override
    public String toString() {
        return "Expense: " + incType + "; Value: " + incValue + ";";
    }
}
