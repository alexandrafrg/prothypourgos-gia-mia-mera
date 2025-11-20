gimport java.util.Scanner;

public class BudgetManager {

    private Budget budget;      // το αντικείμενο με τα ποσά
    private String changesLog = "";  // ιστορικό αλλαγών

    public BudgetManager(Budget budget) {
        this.budget = budget;
    }

    // Προβολή τρέχοντος προϋπολογισμού
    public void displayBudget() {
        System.out.println("\n----- ΤΡΕΧΩΝ ΠΡΟΫΠΟΛΟΓΙΣΜΟΣ -----");
        System.out.println("1. Παιδεία: " + budget.education);
        System.out.println("2. Υγεία: " + budget.health);
        System.out.println("3. Άμυνα: " + budget.defense);
        System.out.println("4. Μεταφορές: " + budget.transport);
        System.out.println("---------------------------------\n");
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

    // Προβολή όλων των αλλαγών
    public void displayChanges() {
        if (changesLog.isEmpty()) {
            System.out.println("\nΔεν έχουν γίνει αλλαγές.\n");
        } else {
            System.out.println("\n----- ΑΛΛΑΓΕΣ -----");
            System.out.println(changesLog);
        }
    }
}
