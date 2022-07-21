package Homework3;

public class FinancialRecord {
    private int income;
    private int outcome;

    FinancialRecord(int income, int outcome) {
        this.income = income;
        this.outcome = outcome;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setOutcome(int outcome) {
        this.outcome = outcome;
    }

    public int getIncome() {
        return income;
    }

    public int getOutcome() {
        return outcome;
    }
}
