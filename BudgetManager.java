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
    
    
    // 2. ΕΙΣΑΓΩΓΗ ΑΛΛΑΓΗΣ ΣΕ ΥΠΟΥΡΓΕΙΟ
    public void modifyBudget(Scanner input) {

        System.out.println("\n===== ΕΙΣΑΓΩΓΗ ΑΛΛΑΓΗΣ =====");

        for (int i = 0; i < budget.ministries.length; i++) {
            System.out.println((i + 1) + ". " + budget.ministries[i] +
                    " (Τρέχον: " + budget.ministryExpenses[i] + ")");
        }

        System.out.print("Διάλεξε υπουργείο: ");
        int index = input.nextInt() - 1;

        if (index < 0 || index >= budget.ministries.length) {
            System.out.println("Μη έγκυρη επιλογή.");
            return;
        }

        double oldValue = budget.ministryExpenses[index];

        System.out.print("Νέα τιμή εξόδων: ");
        input.nextLine(); // καθαρισμός buffer
        double newValue = Double.parseDouble(input.nextLine());


        if (newValue < 0) {
            System.out.println("Το ποσό δεν μπορεί να είναι αρνητικό.");
            return;
        }

        budget.ministryExpenses[index] = newValue;

        // Καταγραφή αλλαγής
        changesLog.append("[" + budget.ministries[index] + "] "
                + oldValue + " → " + newValue + "\n");

        System.out.println("Η αλλαγή αποθηκεύτηκε!");
    } 

    // 3. ΠΡΟΒΟΛΗ ΟΛΩΝ ΤΩΝ ΑΛΛΑΓΩΝ
    public void displayChanges() {
        System.out.println("\n===== ΠΡΟΒΟΛΗ ΑΛΛΑΓΩΝ =====");

        if (changesLog.length() == 0) {
            System.out.println("Δεν έχουν γίνει αλλαγές ακόμα.");
        } else {
            System.out.println(changesLog.toString());
        }
    }


}
 