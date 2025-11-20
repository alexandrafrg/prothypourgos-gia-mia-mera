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
            
            //καινουριος κωδικας
        do {
            System.out.println("===== ΠΡΩΘΥΠΟΥΡΓΟΣ ΓΙΑ ΜΙΑ ΜΕΡΑ =====");
            System.out.println("1. Προβολή προϋπολογισμού");
            System.out.println("2. Εισαγωγή αλλαγής");
            System.out.println("3. Προβολή αλλαγών");
            System.out.println("4. Έλεγχος ισοζυγίου & περιορισμών");
            System.out.println("5. Ανάλυση εσόδων/εξόδων (Top-3)");
            System.out.println("6. Σενάρια & μαζικές αλλαγές");
            System.out.println("7. Ειδοποιήσεις για αποκλίσεις");
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
                    manager.checkBalanceAndConstraints(); 
                    break;

                case 5:
                    manager.showTopCategories(); 
                    break;

                case 6:
                    manager.applyScenario(input); 
                    break;

                case 7:
                    manager.showDeviationAlerts(); 
                    break;

                case 0:
                    System.out.println("Έξοδος από το πρόγραμμα...");
                    break;

                default:
                    System.out.println("Μη έγκυρη επιλογή, προσπάθησε ξανά!");
            }

        }
        //τελος καινουριου


            System.out.println(); 

        } while (choice != 0);

        input.close();
    }
}
