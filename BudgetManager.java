import java.util.Scanner;

public class BudgetManager {

    //ΚΩΝΝΑ - μη τα σβήσετε
    private Budget budget; 
    private StringBuilder changesLog = new StringBuilder();    //καταγραφή αλλαγών

    public BudgetManager(Budget budget) {
        this.budget = budget;
    }

    // Προβολή τρέχοντος προϋπολογισμού - ΚΩΝΝΑ
    public void displayBudget() {
        System.out.println("\n----- ΠΡΟΫΠΟΛΟΓΙΣΜΟΣ -----");
        System.out.println("Έσοδα: " + budget.getRevenue()); 
        System.out.println("Έξοδα: " + budget.getExpenses());
        System.out.println("Ισοζύγιο: " + (budget.getRevenue() - budget.getExpenses())); //Υπολογίζει και δείχνει έσοδα-έξοδα (τελικό αποτέλεσμα)
        System.out.println();
    }

    // Λειτουργία αλλαγής ποσού
    public void modifyBudget(Scanner input) {

        System.out.println("\nΣε ποια κατηγορία θέλεις αλλαγή;");
        System.out.println("1. Παιδεία");
        System.out.println("2. Υγεία");
        System.out.println("3. Άμυνα");
        System.out.println("4. Μεταφορές");
        System.out.print("Επιλογή: ");

        int choice = input.nextInt();

        System.out.print("Δώσε νέο ποσό: ");
        double newAmount = input.nextDouble();

        if (newAmount < 0) {
            System.out.println("Το ποσό δεν μπορεί να είναι αρνητικό!");
            return;
        }

        switch (choice) {
            case 1:
                changesLog += "Παιδεία: " + budget.education + " → " + newAmount + "\n";
                budget.education = newAmount;
                break;
            case 2:
                changesLog += "Υγεία: " + budget.health + " → " + newAmount + "\n";
                budget.health = newAmount;
                break;
            case 3:
                changesLog += "Άμυνα: " + budget.defense + " → " + newAmount + "\n";
                budget.defense = newAmount;
                break;
            case 4:
                changesLog += "Μεταφορές: " + budget.transport + " → " + newAmount + "\n";
                budget.transport = newAmount;
                break;
            default:
                System.out.println("Μη έγκυρη επιλογή!");
                return;
        }

        System.out.println("Η αλλαγή καταχωρήθηκε!\n");
    }

    // Προβολή αλλαγών - ΚΩΝΝΑ
    public void displayChanges() {
        if (changesLog.isEmpty()) {
            System.out.println("\nΔεν έχουν γίνει αλλαγές.\n");
        } else {
            System.out.println("\n----- ΑΛΛΑΓΕΣ -----");
            System.out.println(changesLog.toString());
        }
    }
}
