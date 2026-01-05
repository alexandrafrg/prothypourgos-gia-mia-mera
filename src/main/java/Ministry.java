public class Ministry {

    private String name;
    private double revenue;
    private double expenses;

    public Ministry(String name, double revenue, double expenses) {
        this.name = name;
        this.revenue = revenue;
        this.expenses = expenses;
    }

    public String getName() {
        return name;
    }

    public double getRevenue() {
        return revenue;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getBalance() {
        return revenue - expenses;
    }
    Ministry m = budget.ministries[choice]; 
}
