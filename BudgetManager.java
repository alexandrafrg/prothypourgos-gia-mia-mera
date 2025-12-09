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
    }private void showTop3(String[] names, double[] values) {

        double[] sorted = Arrays.copyOf(values, values.length);
        Arrays.sort(sorted);

        for (int i = sorted.length - 1; i >= sorted.length - 3; i--) {
            double value = sorted[i];
            int indexOriginal = findIndex(values, value);

            System.out.println(names[indexOriginal] + " → " + value);
        }
    }

    private int findIndex(double[] arr, double value) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == value) return i;
        return -1;
    }
    // 7. ΕΚΤΕΛΕΣΗ ΣΕΝΑΡΙΩΝ
    public void executeScenario() {

            //ΜΕΡΟΣ 1ο της 7ης επιλογής - Σενάριο Αλλαγής Εσόδων 
    
    private void scenarioRevenue(Scanner scanner) { 
        
        System.out.println("===== ΣΕΝΑΡΙΑ ΕΣΟΔΩΝ =====");
        System.out.println("1. Αλλαγή Φόρων");
        System.out.println("2. Αλλαγή Κοινωνικών Εισφορών");
        System.out.println("3. Αλλαγή Πωλήσεων αγαθών/υπηρεσιών");
        System.out.println("4. Αλλαγή λοιπών τρεχόντων εσόδων");
        System.out.println("0. Επιστροφή");
        System.out.print("Επιλογή: ");

        int c = scanner.nextInt();

        double percent, oldVal, newVal;

        switch (c) {
            case 1:
                System.out.print("Ποσοστό μεταβολής στους Φόρους (%): ");
                percent = scanner.nextDouble();
                oldVal = budget.taxes;
                newVal = oldVal * (1 + percent/100.0);
                budget.taxes = newVal;
                System.out.println("Νέα τιμή φόρων: " + newVal);
                break;

           case 2:
                System.out.print("Ποσοστό μεταβολής στις κοινωνικές εισφορές (%): ");
                percent = scanner.nextDouble();
                oldVal = budget.socialContributions;
                newVal = oldVal * (1 + percent/100.0);
                budget.socialContributions = newVal;
                System.out.println("Νέα τιμή εισφορών: " + newVal);
                break;

            case 3:
                System.out.print("Ποσοστό μεταβολής στις πωλήσεις (%): ");
                percent = scanner.nextDouble();
                oldVal = budget.salesGoodsServices;
                newVal = oldVal * (1 + percent/100.0);
                budget.salesGoodsServices = newVal;
                System.out.println("Νέο ποσό πωλήσεων: " + newVal);
                break;
                
            case 4:
            System.out.print("Ποσοστό μεταβολής στα λοιπά έσοδα (%): ");
                percent = scanner.nextDouble();
                oldVal = budget.otherCurrentRevenue;
                newVal = oldVal * (1 + percent/100.0);
                budget.otherCurrentRevenue = newVal;
                System.out.println("Νέο ποσό λοιπών εσόδων: " + newVal);
                break;
                
            case 0:
                return;

            default:
                System.out.println("Μη έγκυρη επιλογή.");
        }

    }

    //ΜΕΡΟΣ 2ο της 7ης επιλογής - Σενάριο Αλλαγής Δαπανών

    private void scenarioExpenditure(Scanner scanner) {

        System.out.println("===== ΣΕΝΑΡΙΑ ΔΑΠΑΝΩΝ =====");
        System.out.println("1. Μισθοί δημοσίου");
        System.out.println("2. Συντάξεις / κοινωνικές παροχές")
        System.out.println("3. Λειτουργικά έξοδα (αγορές αγαθών/υπηρεσιών)");
        System.out.println("4. Μεταβιβάσεις");
        System.out.println("5. Επιδοτήσεις");
        System.out.println("6. Πιστώσεις υπό κατανομή");
        System.out.println("0. Επιστροφή");
        System.out.print("Επιλογή: ");
        
        int c = scanner.nextInt();
        double percent, oldVal, newVal;
        
        switch (c) {
            
            case 1:
                System.out.print("Μεταβολή μισθών δημοσίου (%): ");
                percent = scanner.nextDouble();
                oldVal = budget.employeeCompensation;
                newVal = oldVal * (1 + percent/100.0);
                budget.employeeCompensation = newVal;
                System.out.println("Νέοι μισθοί: " + newVal);
                break;
                
            case 2:
                System.out.print("Μεταβολή συντάξεων/παροχών (%): ");
                percent = scanner.nextDouble();
                oldVal = budget.socialBenefits;
                newVal = oldVal * (1 + percent/100.0);
                budget.socialBenefits = newVal;
                System.out.println("Νέες παροχές: " + newVal);
                break;
                
            case 3:
                System.out.print("Μεταβολή λειτουργικών εξόδων (%): ");
                percent = scanner.nextDouble();
                oldVal = budget.goodsServicesPurchases;
                newVal = oldVal * (1 + percent/100.0);
                budget.goodsServicesPurchases = newVal;
                System.out.println("Νέα λειτουργικά έξοδα: " + newVal);
                break;
                
            case 4:
                System.out.print("Μεταβολή μεταβιβάσεων (%): ");
                percent = scanner.nextDouble();
                oldVal = budget.transfersExpenses;
                newVal = oldVal * (1 + percent/100.0);
                budget.transfersExpenses = newVal;
                System.out.println("Νέες μεταβιβάσεις: " + newVal);
                break;
            
            case 5:
                System.out.print("Μεταβολή επιδοτήσεων (%): ");
                percent = scanner.nextDouble();
                oldVal = budget.subsidies;
                newVal = oldVal * (1 + percent/100.0);
                budget.subsidies = newVal;
                System.out.println("Νέες επιδοτήσεις: " + newVal);
                break;
            
            case 6:
                System.out.print("Μεταβολή πιστώσεων (%): ");
                percent = scanner.nextDouble();
                oldVal = budget.allocatedCredits;
                newVal = oldVal * (1 + percent/100.0);
                budget.allocatedCredits = newVal;
                System.out.println("Νέες πιστώσεις: " + newVal);
                break;
                
            case 0:
                eturn;
            
            default:
                System.out.println("Μη έγκυρη επιλογή.");
                
        }
    }

    //ΜΕΡΟΣ 3ο της 7ης επιλογής - Σενάριο Αλλαγής σε Υπουργεία

    private void scenarioMinistries(Scanner scanner) {

        System.out.println("===== ΑΛΛΑΓΕΣ ΑΝΑ ΥΠΟΥΡΓΕΙΟ =====");
        
         // 1. Εμφάνιση όλων των υπουργείων
    for (int i = 0; i < budget.ministries.length; i++) {
        System.out.println((i + 1) + ". " + budget.ministries[i]);
    }

    // 2. Επιλογή υπουργείου
    System.out.print("Επιλέξτε υπουργείο: ");
    int choice = scanner.nextInt() - 1;   // κάνουμε -1 για index πίνακα

    if (choice < 0 || choice >= budget.ministries.length) {
        System.out.println("Μη έγκυρη επιλογή.");
        return;
    }

    // 3. Επιλογή τύπου αλλαγής
    System.out.println("Τι θέλετε να αλλάξετε;");
    System.out.println("1. Έσοδα υπουργείου");
    System.out.println("2. Έξοδα υπουργείου");
    System.out.print("Επιλογή: ");
    int type = scanner.nextInt();

    // 4. Ποσοστό μεταβολής
    System.out.print("Ποσοστό μεταβολής (%): ");
    double percent = scanner.nextDouble();

    // 5. Ανάλογα με τον τύπο, αλλάζουμε έσοδα ή έξοδα
    if (type == 1) {
        
        double oldVal = budget.ministryRevenue[choice];
        double newVal = oldVal * (1 + percent / 100.0);

        budget.ministryRevenue[choice] = newVal;

        System.out.println("\n--- Αλλαγή ΕΣΟΔΩΝ ---");
        System.out.println("Υπουργείο: " + budget.ministries[choice]);
        System.out.println("Πριν: " + oldVal + " €");
        System.out.println("Μετά: " + newVal + " €");

    } else if (type == 2) {

        double oldVal = budget.ministryExpenses[choice];
        double newVal = oldVal * (1 + percent / 100.0);

        budget.ministryExpenses[choice] = newVal;

        System.out.println("\n--- Αλλαγή ΕΞΟΔΩΝ ---");
        System.out.println("Υπουργείο: " + budget.ministries[choice]);
        System.out.println("Πριν: " + oldVal + " €");
        System.out.println("Μετά: " + newVal + " €");

    } else {
        System.out.println("Μη έγκυρη επιλογή.");
    }
}

    }

    //ΜΕΡΟΣ 4ο της 7ης επιλογής - Σενάριο Ταυτόχρονων Αλλαγών

}
 