package newvenues;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseTracker {
    private List<Expense> expenses = new ArrayList<>();
    private int nextId = 1;

    public void addExpense(double amount, String category, String description) {
        Expense newExpense = new Expense(nextId++, amount, category, description);
        expenses.add(newExpense);
    }

    public boolean updateExpense(int id, double amount, String category, String description) {
        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                expense.setAmount(amount);
                expense.setCategory(category);
                expense.setDescription(description);
                return true; // Update successful
            }
        }
        return false; // Expense not found
    }

    public boolean deleteExpense(int id) {
        return expenses.removeIf(expense -> expense.getId() == id);
    }

    public List<Expense> getExpensesByCategory(String category) {
        return expenses.stream()
                .filter(expense -> expense.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // Additional helper methods as needed, e.g., getExpenses, for testing purposes
    public List<Expense> getExpenses() {
        return new ArrayList<>(expenses);
    }
    public List<String> getCategories() {
        return expenses.stream()
                .map(Expense::getCategory)
                .distinct()
                .collect(Collectors.toList());
    }


}

