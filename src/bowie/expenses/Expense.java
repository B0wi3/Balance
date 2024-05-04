package bowie.expenses;

public class Expense {
    private String expType;
    private double expValue;

    public Expense(String expType, double expValue) {
        this.expType = expType;
        this.expValue = expValue;
    }

    public String getType() {
        return expType;
    }

    public double getValue() {
        return expValue;
    }

    @Override
    public String toString() {
        return "Expense: " + expType + "; Value: " + expValue + ";";
    }
}
