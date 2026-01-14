import java.util.Scanner;
/**
 * Κύρια κλάση εκκίνησης της εφαρμογής "Πρωθυπουργός για μια μέρα".
 * Περιλαμβάνει το κύριο μενού και εκτελεί τις λειτουργίες
 * μέσω του BudgetManager.
 */
public class Main {
    /**
     * Κύρια μέθοδος εκκίνησης της εφαρμογής.
     * Δημιουργεί αντικείμενα Budget και BudgetManager,
     * εμφανίζει το μενού και δέχεται επιλογές χρήστη.
     *
     * @param args τα επιχειρήματα γραμμής εντολών (δεν χρησιμοποιούνται)
     */
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);

        // Δημιουργία αντικειμένων
        Budget budget = new Budget();
        BudgetManager manager = new BudgetManager(budget);


        int choice = -1;
           
        do {
            printMenu(); // Κλήση της μεθόδου εκτύπωσης μενού
 
            while (!input.hasNextInt()) {
                System.out.println("Σφάλμα: Παρακαλώ εισάγετε έναν αριθμό από 0 έως 8.");
                System.out.print("Επιλογή: ");
                input.next(); // "Καθαρίζουμε" την λανθασμένη είσοδο από τη μνήμη
            }
            
            choice = input.nextInt();


            switch (choice) {
                case 1:
                    manager.displayBudget();
                    break;
                case 2:
                    manager.modifyBudget(input);
                    break;
                case 3:
                    manager.displayChanges();
                    break;
                case 4:
                    manager.calculateBalance();
                    break;
                case 5:
                    manager.analyzeMinistryBudget();
                    break;
                case 6:
                    manager.showTopBudgetCategories(input);
                    break;
                case 7:
                    manager.executeScenario(input);
                    break;
                case 8:
                    manager.showDetailedAnalysis(input);
                    break;
                case 0:
                    System.out.println("Έξοδος από το πρόγραμμα...");
                    break;
                default:
                    System.out.println("Μη έγκυρη επιλογή, προσπάθησε ξανά! Από 0 έως 8.");
            }

            System.out.println();

        } while (choice != 0);

        input.close();
    }
    /**
     * Εκτυπώνει το κύριο μενού επιλογών της εφαρμογής.
     */
    private static void printMenu() {
        System.out.println("===== ΠΡΩΘΥΠΟΥΡΓΟΣ ΓΙΑ ΜΙΑ ΜΕΡΑ =====");
        System.out.println("1. Προβολή προϋπολογισμού");
        System.out.println("2. Εισαγωγή αλλαγής σε Υπουργείο");
        System.out.println("3. Προβολή ιστορικού αλλαγών");
        System.out.println("4. Υπολογισμός ισοζυγίου");
        System.out.println("5. Ανάλυση εσόδων/εξόδων ανά υπουργείο");
        System.out.println("6. Εμφάνιση Top-3 κατηγοριών");
        System.out.println("7. Εκτέλεση σεναρίων (Φόροι, Μισθοί, κλπ)");
        System.out.println("8. Πολυεπίπεδη Ανάλυση (% και Μηνιαία)"); 
        System.out.println("0. Έξοδος");
        System.out.print("Επιλογή: ");
    }

}
