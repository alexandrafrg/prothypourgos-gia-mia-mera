import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        // Δημιουργία αντικειμένων
        Budget budget = new Budget();
        BudgetManager manager = new BudgetManager(budget);

        int choice;

        do {
            System.out.println("===== ΠΡΩΘΥΠΟΥΡΓΟΣ ΓΙΑ ΜΙΑ ΜΕΡΑ =====");
            System.out.println("1. Προβολή προϋπολογισμού");
            System.out.println("2. Εισαγωγή αλλαγής");
            System.out.println("3. Προβολή αλλαγών");
            System.out.println("0. Έξοδος");
            System.out.print("Επιλογή: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    manager.displayBudget(); // προβολή προϋπολογισμού
                    break;
                case 2:
                    manager.modifyBudget(input); // αλλαγή ποσών
                    break;
                case 3:
                    manager.displayChanges(); // ιστορικό αλλαγών
                    break;
                case 0:
                    System.out.println("Έξοδος από το πρόγραμμα...");
                    break;
                default:
                    System.out.println("Μη έγκυρη επιλογή, προσπάθησε ξανά!");
            }

            System.out.println(); 

        } while (choice != 0);

        input.close();
    }
}
