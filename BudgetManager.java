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

    // 4. ΥΠΟΛΟΓΙΣΜΟΣ ΙΣΟΖΥΓΙΟΥ
    public void calculateBalance() {
        System.out.println("\n===== ΙΣΟΖΥΓΙΟ =====");

        double revenue = budget.getRevenue();
        double expenses = budget.getExpenses();
        double balance = revenue - expenses;

        System.out.println("Έσοδα: " + revenue);
        System.out.println("Έξοδα: " + expenses);
        System.out.println("Ισοζύγιο: " + balance);
    }
    
    
    // 5. ΑΝΑΛΥΣΗ ΕΣΟΔΩΝ/ΕΞΟΔΩΝ ΑΝΑ ΥΠΟΥΡΓΕΙΟ
    public void analyzeMinistryBudget() {

        System.out.println("\n===== ΑΝΑΛΥΣΗ ΑΝΑ ΥΠΟΥΡΓΕΙΟ =====");

        for (int i = 0; i < budget.ministries.length; i++) {

            double rev = budget.ministryRevenue[i];
            double exp = budget.ministryExpenses[i];
            double diff = rev - exp;

            System.out.println("\n" + budget.ministries[i]);
            System.out.println("Έσοδα: " + rev);
            System.out.println("Έξοδα: " + exp);

            if (diff >= 0) {
                System.out.println("Πλεόνασμα: " + diff);
            } else {
                System.out.println("Έλλειμμα: " + diff);
            }
        }
    }

    // 6. TOP-3 ΚΑΤΗΓΟΡΙΕΣ ΕΣΟΔΩΝ/ΕΞΟΔΩΝ
    public void showTopBudgetCategories(Scanner input) {

        System.out.println("\n1. Top-3 Υπουργεία με τα υψηλότερα έσοδα");
        System.out.println("2. Top-3 Υπουργεία με τα υψηλότερα έξοδα");
        System.out.print("Επιλογή: ");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.println("\n===== TOP-3 ΕΣΟΔΑ =====");
            showTop3(budget.ministries, budget.ministryRevenue);
        } else if (choice == 2) {
            System.out.println("\n===== TOP-3 ΕΞΟΔΑ =====");
            showTop3(budget.ministries, budget.ministryExpenses);
        } else {
            System.out.println("Μη έγκυρη επιλογή.");
        }
    }
}
 