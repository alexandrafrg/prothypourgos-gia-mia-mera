import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        // Δημιουργία αντικειμένων
        Budget budget = new Budget();
        BudgetManager manager = new BudgetManager(budget);

        int choice;
            
            //καινουριος κωδικας
        do {
            System.out.println("===== ΠΡΩΘΥΠΟΥΡΓΟΣ ΓΙΑ ΜΙΑ ΜΕΡΑ =====");
            System.out.println("1. Προβολή προϋπολογισμού");
            System.out.println("2. Εισαγωγή αλλαγής");
            System.out.println("3. Προβολή αλλαγών");
            System.out.println("4. Υπολογισμός ισοζυγίου");
            System.out.println("5. Ανάλυση εσόδων/εξόδων ανά υπουργείο");
            System.out.println("6. Εμφάνιση Top-3 κατηγοριών εσόδων/εξόδων");
            System.out.println("7. Εκτέλεση σεναρίων");
            System.out.println("0. Έξοδος");
            System.out.print("Επιλογή: ");
 

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
                    manager.calculateBalance(budget); 
                    break;

                case 5:
                    manager.analyzeMinistryBudget(); 
                    break;

                case 6:
                    manager.showTopBudgetCategories(input); 
                    break;

                case 7:
                    manager.executeScenario(); 
                    break;

                case 0:
                    System.out.println("Έξοδος από το πρόγραμμα...");
                    break;

                default:
                    System.out.println("Μη έγκυρη επιλογή, προσπάθησε ξανά! Από 0 έως 7.");
            }
        //τελος καινουριου


            System.out.println(); 

        } while (choice != 0);

        input.close();
    }
}


