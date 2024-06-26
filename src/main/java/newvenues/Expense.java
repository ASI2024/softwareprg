package newvenues;

public class Expense {
    private int id;
    private double amount;
    private String category;
    private String description;

    public Expense(int id,double amount, String category, String description) {
        this.amount = amount;
        this.category = category;
        this.description = description;
         this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
