import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

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
            Ministry m = budget.ministries[i];
            
            System.out.println((i + 1) + ". " + m.getName() +
            "\n   Έσοδα: " + m.getRevenue() +
            "\n   Έξοδα: " + m.getExpenses() + "\n");
        }

    }

    // 2. ΕΙΣΑΓΩΓΗ ΑΛΛΑΓΗΣ ΣΕ ΥΠΟΥΡΓΕΙΟ
    public void modifyBudget(Scanner input) {

        System.out.println("\n===== ΕΙΣΑΓΩΓΗ ΑΛΛΑΓΗΣ =====");

        for (int i = 0; i < budget.ministries.length; i++) {
            Ministry m = budget.ministries[i];
            System.out.println((i + 1) + ". " + m.getName() + " (Τρέχον: " + m.getExpenses() + ")");
        } 

        System.out.print("Διάλεξε υπουργείο: ");
        int index = input.nextInt() - 1;

        if (index < 0 || index >= budget.ministries.length) {
            System.out.println("Μη έγκυρη επιλογή.");
            return;
        }

        Ministry m = budget.ministries[index];
        double oldValue = m.getExpenses();

        System.out.print("Νέα τιμή εξόδων: ");
        input.nextLine(); 
        double newValue = Double.parseDouble(input.nextLine());

        if (newValue < 0) {
            System.out.println("Το ποσό δεν μπορεί να είναι αρνητικό.");
            return;
        }

        m.setExpenses(newValue);           

        changesLog.append("[" + m.getName() + "] "  
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
    public double calculateBalance() {
        System.out.println("\n===== ΙΣΟΖΥΓΙΟ =====");

        double revenue = budget.getRevenue();
        double expenses = budget.getExpenses();
        double balance = revenue - expenses;

        System.out.println("Έσοδα: " + revenue);
        System.out.println("Έξοδα: " + expenses);
        System.out.println("Ισοζύγιο: " + balance);

        return balance;
    }

    // 5. ΑΝΑΛΥΣΗ ΕΣΟΔΩΝ/ΕΞΟΔΩΝ ΑΝΑ ΥΠΟΥΡΓΕΙΟ
    public void analyzeMinistryBudget() {

        System.out.println("\n===== ΑΝΑΛΥΣΗ ΑΝΑ ΥΠΟΥΡΓΕΙΟ =====");

        for (int i = 0; i < budget.ministries.length; i++) {
            Ministry m = budget.ministries[i];   
            double rev = m.getRevenue();         
            double exp = m.getExpenses();        
            double diff = m.getBalance();

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
            showTop3Revenue(budget.ministries);
        } else if (choice == 2) {
             showTop3Expenses(budget.ministries);
        } else {
             System.out.println("Μη έγκυρη επιλογή.");
        }

    }

    private void showTop3(String[] names, double[] values) {

        double[] sorted = Arrays.copyOf(values, values.length);
        Arrays.sort(sorted);

        for (int i = sorted.length - 1; i >= sorted.length - 3; i--) {
            double value = sorted[i];
            int indexOriginal = findIndex(values, value);

            System.out.println(names[indexOriginal] + " → " + value);

        }
    }

    private int findIndex(double[] arr, double value) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }

    // 7. ΕΚΤΕΛΕΣΗ ΣΕΝΑΡΙΩΝ
    public void executeScenario(Scanner scanner) {

        //ΜΕΝΟΥ ΓΙΑ ΤΗΝ ΕΚΤΕΛΕΣΗ ΣΕΝΑΡΙΩΝ

        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== ΜΕΝΟΥ ΣΕΝΑΡΙΩΝ =====");
            System.out.println("1. Σενάριο Αλλαγής Εσόδων");
            System.out.println("2. Σενάριο Αλλαγής Δαπανών");
            System.out.println("3. Σενάριο Αλλαγών σε Υπουργεία");
            System.out.println("4. Σενάριο Ταυτόχρονων Αλλαγών");
            System.out.println("0. Επιστροφή");
            System.out.print("Επιλογή: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scenarioRevenue(scanner);
                    break;

                case 2:
                    scenarioExpenditure(scanner);
                    break;

                case 3:
                    scenarioMinistries(scanner);
                    break;

                case 4:
                    scenarioCombined(scanner);
                    break;

                case 0:
                    exit = true;
                    break;

                default:
                    System.out.println("Μη έγκυρη επιλογή.");
            }
        }
    }


    //ΜΕΡΟΣ 1ο της 7ης επιλογής - Σενάριο Αλλαγής Εσόδων 
    
    private void scenarioRevenue(Scanner scanner) { 
        System.out.println("===== ΣΕΝΑΡΙΑ ΕΣΟΔΩΝ =====");
        System.out.println("1. Αλλαγή Φόρων\n2. Αλλαγή Κοινωνικών Εισφορών\n3. Αλλαγή Πωλήσεων\n4. Αλλαγή λοιπών εσόδων\n0. Επιστροφή");
        System.out.print("Επιλογή: ");

        int c = scanner.nextInt();
        if (c == 0) return; // Επιστροφή στην προηγούμενη οθόνη

        double oldVal = 0;
        String label = "";

        // Επιλογή μόνο του πεδίου που θα αλλάξει
        switch (c) {
            case 1: oldVal = budget.taxes; label = "Φόρων"; break;
            case 2: oldVal = budget.socialContributions; label = "Εισφορών"; break;
            case 3: oldVal = budget.salesGoodsServices; label = "Πωλήσεων"; break;
            case 4: oldVal = budget.otherCurrentRevenue; label = "Λοιπών Εσόδων"; break;
            default: System.out.println("Μη έγκυρη επιλογή."); return;
        }

        System.out.print("Ποσοστό μεταβολής (%): ");
        double percent = scanner.nextDouble();
        double newVal = oldVal * (1 + percent / 100.0); // Υπολογισμός μεταβολής

        // ΣΥΜΠΛΗΡΩΣΗ: Έλεγχος περιορισμού για αρνητικές τιμές
        if (newVal < 0) {
            System.out.println("Σφάλμα: Η μεταβολή αυτή οδηγεί σε αρνητικά έσοδα! Η πράξη ακυρώθηκε.");
        } else {
            updateRevenueField(c, newVal); // Ενημέρωση του budget
            System.out.println("Επιτυχής αλλαγή! Νέα τιμή " + label + ": " + newVal + " €");
        }
    }

    // Βοηθητική μέθοδος για την ανάθεση της τιμής
    private void updateRevenueField(int choice, double value) {
        switch (choice) {
            case 1: budget.taxes = value; break;
            case 2: budget.socialContributions = value; break;
            case 3: budget.salesGoodsServices = value; break;
            case 4: budget.otherCurrentRevenue = value; break;
        }
    }



    //ΜΕΡΟΣ 2ο της 7ης επιλογής - Σενάριο Αλλαγής Δαπανών

    private void scenarioExpenditure(Scanner scanner) {
        System.out.println("\n===== ΣΕΝΑΡΙΑ ΔΑΠΑΝΩΝ =====");
        System.out.println("1. Μισθοί δημοσίου");
        System.out.println("2. Συντάξεις / κοινωνικές παροχές");
        System.out.println("3. Λειτουργικά έξοδα (αγορές αγαθών/υπηρεσιών)");
        System.out.println("4. Μεταβιβάσεις");
        System.out.println("5. Επιδοτήσεις");
        System.out.println("6. Πιστώσεις υπό κατανομή");
        System.out.println("0. Επιστροφή");
        System.out.print("Επιλογή: ");

        int c = scanner.nextInt();
        if (c == 0) return; // Επιστροφή στο προηγούμενο μενού

        double oldVal = 0;
        String label = "";

        // 1. Ενοποίηση επιλογής κατηγορίας δαπάνης
        switch (c) {
            case 1: oldVal = budget.employeeCompensation; label = "Μισθών"; break;
            case 2: oldVal = budget.socialBenefits; label = "Συντάξεων"; break;
            case 3: oldVal = budget.goodsServicesPurchases; label = "Λειτουργικών"; break;
            case 4: oldVal = budget.transfersExpenses; label = "Μεταβιβάσεων"; break;
            case 5: oldVal = budget.subsidies; label = "Επιδοτήσεων"; break;
            case 6: oldVal = budget.allocatedCredits; label = "Πιστώσεων"; break;
            default:
                System.out.println("Μη έγκυρη επιλογή.");
                return;
        }

        // 2. Ενοποιημένη εισαγωγή ποσοστού
        System.out.print("Ποσοστό μεταβολής (%): ");
        double percent = scanner.nextDouble();
        double newVal = oldVal * (1 + percent / 100.0);

        // 3. ΕΛΕΓΧΟΣ ΠΕΡΙΟΡΙΣΜΟΥ 
        // Εξασφαλίζουμε ότι καμία δαπάνη δεν θα γίνει αρνητική
        if (newVal < 0) {
            System.out.println("Σφάλμα: Οι δαπάνες δεν μπορούν να έχουν αρνητική τιμή! Η πράξη ακυρώθηκε.");
        } else {
            // 4. Ενημέρωση του Budget
            updateExpenditureField(c, newVal);
            System.out.println("Επιτυχής αλλαγή! Νέα τιμή " + label + ": " + newVal + " €");
        }
    }

    // Βοηθητική μέθοδος για την ανάθεση της τιμής στο σωστό πεδίο των δαπανών
    private void updateExpenditureField(int choice, double value) {
        switch (choice) {
            case 1: budget.employeeCompensation = value; break;
            case 2: budget.socialBenefits = value; break;
            case 3: budget.goodsServicesPurchases = value; break;
            case 4: budget.transfersExpenses = value; break;
            case 5: budget.subsidies = value; break;
            case 6: budget.allocatedCredits = value; break;
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
            Ministry m = budget.ministries[choice];  
            double oldVal = m.getRevenue();           
            double newVal = oldVal * (1 + percent / 100.0); 
            m.setRevenue(newVal);        

            System.out.println("\n--- Αλλαγή ΕΣΟΔΩΝ ---");
            System.out.println("Υπουργείο: " + m.getName());
            System.out.println("Πριν: " + oldVal + " €");
            System.out.println("Μετά: " + newVal + " €");
        } else if (type == 2) {
            double oldVal = m.getExpenses();
            double newVal = oldVal * (1 + percent / 100.0);
            m.setExpenses(newVal);
            
            System.out.println("\n--- Αλλαγή ΕΞΟΔΩΝ ---");
            System.out.println("Υπουργείο: " + m.getName());
            System.out.println("Πριν: " + oldVal + " €");
            System.out.println("Μετά: " + newVal + " €");
        } else {
            System.out.println("Μη έγκυρη επιλογή.");
        }

    }

    // ΜΕΡΟΣ 4ο της 7ης επιλογής - Σενάριο Ταυτόχρονων Αλλαγών

    private void scenarioCombined(Scanner scanner) {

        System.out.println("===== ΤΑΥΤΟΧΡΟΝΕΣ ΑΛΛΑΓΕΣ =====");

        // Αποθήκευση αρχικών τιμών προυπολογισμού (πριν εκτελεστεί το σενάριο)
        double initialRevenue = budget.getRevenue();
        double initialExpenses = budget.getExpenses();
        double initialBalance = initialRevenue - initialExpenses;

        boolean done = false;

        // Το σενάριο αρχίζει να εκτελείται

        while (!done) {
            System.out.println("\n--- Επιλέξτε τι θέλετε να αλλάξετε ---");
            System.out.println("1. Αλλαγές στα ΕΣΟΔΑ (φόροι, εισφορές κ.λπ.)");
            System.out.println("2. Αλλαγές στις ΔΑΠΑΝΕΣ (μισθοί, συντάξεις κ.λπ.)");
            System.out.println("3. Αλλαγές ανά ΥΠΟΥΡΓΕΙΟ (έσοδα/έξοδα υπουργείου)");
            System.out.println("0. Τέλος σεναρίου & εμφάνιση αποτελεσμάτων");
            System.out.print("Επιλογή: ");

            int choice = scanner.nextInt(); // Σε κάθε επανάληψη ο χρήστης επιλέγει τι είδους αλλαγή θέλει να κάνει

            switch (choice) {
                case 1:
                    scenarioRevenue(scanner); // Χρησιμοποιείται η μέθοδος που έχει γραφεί ήδη παραπάνω
                    break;
                case 2:
                    scenarioExpenditure(scanner); // Το ίδιο και εδώ
                    break;
                case 3:
                    scenarioMinistries(scanner); // Το ίδιο και εδώ
                    break;
                case 0:
                    done = true;
                    break;
                default:
                    System.out.println("Μη έγκυρη επιλογή.");
            }
        }

        // Τιμές μετά το σενάριο
        double finalRevenue = budget.getRevenue();
        double finalExpenses = budget.getExpenses();
        double finalBalance = finalRevenue - finalExpenses;

        // Σύνοψη αποτελεσμάτων
        System.out.println("\n===== ΠΕΡΙΛΗΨΗ ΣΕΝΑΡΙΟΥ ΤΑΥΤΟΧΡΟΝΩΝ ΑΛΛΑΓΩΝ =====");
        System.out.println("Αρχικά έσοδα : " + initialRevenue);
        System.out.println("Αρχικά έξοδα : " + initialExpenses);
        System.out.println("Αρχικό ισοζύγιο : " + initialBalance);
        System.out.println("----------------------------------------");
        System.out.println("Τελικά έσοδα : " + finalRevenue);
        System.out.println("Τελικά έξοδα : " + finalExpenses);
        System.out.println("Τελικό ισοζύγιο : " + finalBalance);
        System.out.println("----------------------------------------");
        System.out.println("Μεταβολή ισοζυγίου : " + (finalBalance - initialBalance));
    }
        
    private void showTop3Revenue(Ministry[] ministries) {
        Ministry[] sorted = Arrays.copyOf(ministries, ministries.length);
        Arrays.sort(sorted, (a, b) -> Double.compare(b.getRevenue(), a.getRevenue())); 
        System.out.println("\n===== TOP-3 Υπουργεία με τα υψηλότερα έσοδα =====");
            
        for (int i = 0; i < Math.min(3, sorted.length); i++) {
            System.out.println(sorted[i].getName() + " → " + sorted[i].getRevenue());
        }
    }
        
    private void showTop3Expenses(Ministry[] ministries) {
        Ministry[] sorted = Arrays.copyOf(ministries, ministries.length);
        Arrays.sort(sorted, (a, b) -> Double.compare(b.getExpenses(), a.getExpenses()));
        System.out.println("\n===== TOP-3 Υπουργεία με τα υψηλότερα έξοδα =====");
        
        for (int i = 0; i < Math.min(3, sorted.length); i++) {
            System.out.println(sorted[i].getName() + " → " + sorted[i].getExpenses());
        }
    }

}
