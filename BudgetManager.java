import java.util.Arrays;
import java.util.Scanner;

public class BudgetManager {

    private Budget budget;
    private StringBuilder changesLog = new StringBuilder();

    public BudgetManager(Budget budget) {
        this.budget = budget;
    }

    // 1. ΠΡΟΒΟΛΗ ΠΡΟΥΠΟΛΟΓΙΣΜΟΥ
    public void displayBudget() {
        System.out.println("\n===== ΠΡΟΒΟΛΗ ΠΡΟΥΠΟΛΟΓΙΣΜΟΥ =====");
        System.out.println("Συνολικά Έσοδα: " + budget.getRevenue());
        System.out.println("Συνολικά Έξοδα: " + budget.getExpenses());
        System.out.println("Ισοζύγιο: " + (budget.getRevenue() - budget.getExpenses()));

        System.out.println("\nΑνάλυση ανά Υπουργείο:");
        for (int i = 0; i < budget.ministries.length; i++) {
            System.out.println((i + 1) + ". " + budget.ministries[i] +
                    "\n   Έσοδα: " + budget.ministryRevenue[i] +
                    "\n   Έξοδα: " + budget.ministryExpenses[i] + "\n");
        }
    } 
}
 