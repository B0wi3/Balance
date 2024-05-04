package bowie.expenses;

public class Expense {
    private String expType;
    private double expValue;

    // Constructor
    public Expense(String expType, double expValue) {
        this.expType = expType;
        this.expValue = expValue;
    }

    public String getExpType() {
        return expType;
    }

    public double getExpValue() {
        return expValue;
    }

    @Override
    public String toString() {
        return "Expense: " + expType + "; Value: " + expValue + ";";
    }
}
