package BudgetingandFinance;

import java.util.HashMap;
import java.util.Map;

public class BudgetPlanningModule {

    private Map<String, Double> estimatedExpenses = new HashMap<>();
    private Map<String, Double> actualExpenses = new HashMap<>();

    public void estimateExpenses(Map<String, Double> expenses) {
        estimatedExpenses.putAll(expenses);
    }

    public void trackActualExpenses(Map<String, Double> expenses) {
        actualExpenses.putAll(expenses);
    }

    public double calculateTotalEstimatedExpenses() {
        return estimatedExpenses.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public double calculateTotalActualExpenses() {
        return actualExpenses.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public Map<String, Double> getEstimatedExpenses() {
        return estimatedExpenses;
    }

    public Map<String, Double> getActualExpenses() {
        return actualExpenses;
    }

    public void adjustBudget() {
        for (String category : estimatedExpenses.keySet()) {
            if (actualExpenses.containsKey(category)) {
                double estimatedExpense = estimatedExpenses.get(category);
                double actualExpense = actualExpenses.get(category);
                if (actualExpense > estimatedExpense) {
                    double adjustedExpense = actualExpense;
                    estimatedExpenses.put(category, adjustedExpense);
                }
            }
        }
    }

    public void viewBudgetSummary() {
        System.out.println("Budget Summary:");
        System.out.println("Estimated Expenses:");
        for (Map.Entry<String, Double> entry : estimatedExpenses.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
        System.out.println("Actual Expenses:");
        for (Map.Entry<String, Double> entry : actualExpenses.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    public void exportBudgetReport() {

        System.out.println("Budget Report:");
        System.out.println("Estimated Expenses:");
        for (Map.Entry<String, Double> entry : estimatedExpenses.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
        System.out.println("Actual Expenses:");
        for (Map.Entry<String, Double> entry : actualExpenses.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }
}
