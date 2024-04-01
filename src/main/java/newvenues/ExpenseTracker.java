package newvenues;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseTracker {
    public List<Expense> Expenses = new ArrayList<>();
    public int NextId =0;


    public void addExpense(double amount, String category, String description) {
        Expense newExpense = new Expense( NextId,amount, category, description);
        Expenses.add(newExpense);
        NextId++;
    }

    public boolean updateExpense(int id, double amount, String category, String description) {
        for (Expense expense : expenses){
            if(expense.getId()==id) {
                expense.setAmount(amount);
                expense.setCategory(category);
                expense.setDescription(description);
                return true;
            }

        }
        return false; 
    }


    public List<Expense> getExpensesByCategory(String category) {
        return Expenses.stream()
                .filter(expense -> expense.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Expense> getExpenses() {
        return new ArrayList<>(expenses);
    }
    public List<String> getCategories() {
        return Expenses.stream()
                .map(Expense::getCategory)
                .distinct()
                .collect(Collectors.toList());
    }


}

