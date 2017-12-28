package com.anatolii.anitsai.transaction;

public class Transaction {
    private String inputString;
    private final double MAX_COMMISSION = 20.00;
    private final double MIN_COMMISSION = 5.00;

    public Transaction(String inputString) {
        this.inputString = inputString;
    }

    public double getAmount() {
        String[] arrayStr = inputString.split(" ");
        double amount = Double.parseDouble(arrayStr[0]);
        return amount;
    }

    public double getCommission() {
        double amount = getAmount();
        double commission = amount * 0.02 + 3;
        if (commission > MAX_COMMISSION) return MAX_COMMISSION;
        if (commission < MIN_COMMISSION) return MIN_COMMISSION;
        else return commission;
    }

    public String getResultStr(){
        String formatAmount = String.format("%(.2f", getAmount());
        String formatCommission = String.format("%(.2f", getCommission());
        return "сумма = " + formatAmount + ", комиссия = " + formatCommission;
    }

}
