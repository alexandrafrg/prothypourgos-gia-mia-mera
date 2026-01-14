import java.util.Arrays;
import java.util.Scanner;
/**
 * Διαχειρίζεται τον κρατικό προϋπολογισμό της εφαρμογής.
 * Περιλαμβάνει λειτουργίες προβολής, τροποποίησης
 * και ανάλυσης οικονομικών δεδομένων.
 */
public class BudgetManager {

    private Budget budget;
    private StringBuilder changesLog = new StringBuilder();
    /**
    * Δημιουργεί έναν διαχειριστή προϋπολογισμού.
    *
    * @param budget το αντικείμενο Budget που θα διαχειρίζεται
    */
    public BudgetManager(Budget budget) {
        this.budget = budget;
    } 

    // 1. ΠΡΟΒΟΛΗ ΠΡΟΥΠΟΛΟΓΙΣΜΟΥ
    /**
    * Εμφανίζει τον προϋπολογισμό και τα οικονομικά στοιχεία
    * όλων των υπουργείων.
    */
    public void displayBudget() {
        System.out.println("\n===== ΠΡΟΒΟΛΗ ΠΡΟΥΠΟΛΟΓΙΣΜΟΥ =====");
        System.out.println("Συνολικά Έσοδα: " + budget.getRevenue());
        System.out.println("Συνολικά Έξοδα: " + budget.getExpenses());
        System.out.println("Ισοζύγιο: " + (budget.getRevenue() - budget.getExpenses()));

        System.out.println("\nΑνάλυση ανά Υπουργείο:");
        
        Ministry[] ministries = budget.getMinistries();

        for (int i = 0; i < ministries.length; i++) {
            Ministry m = ministries[i];
            
            System.out.println((i + 1) + ". " + m.getName() +
            "\n   Έσοδα: " + m.getRevenue() +
            "\n   Έξοδα: " + m.getExpenses() + "\n");
        }

    }

    // 2. ΕΙΣΑΓΩΓΗ ΑΛΛΑΓΗΣ ΣΕ ΥΠΟΥΡΓΕΙΟ
    /**
    * Τροποποιεί τα έξοδα επιλεγμένου υπουργείου.
    *
    * @param input ο Scanner για είσοδο δεδομένων από τον χρήστη
    */
    public void modifyBudget(Scanner input) {

        System.out.println("\n===== ΕΙΣΑΓΩΓΗ ΑΛΛΑΓΗΣ =====");

        Ministry[] ministries = budget.getMinistries();
        for (int i = 0; i < ministries.length; i++) {
            System.out.println((i + 1) + ". " + ministries[i].getName() + 
            " (Τρέχοντα Έξοδα: " + ministries[i].getExpenses() + ")");
        } 

        System.out.print("Διάλεξε υπουργείο: ");
        if (!input.hasNextInt()) {
            input.next();
            System.out.println("Μη έγκυρη είσοδος.");
            return;
        }
        
        int index = input.nextInt() - 1;

        if (index < 0 || index >= ministries.length) {
            System.out.println("Μη έγκυρη επιλογή.");
            return;
        }

        Ministry m = ministries[index];
        double oldValue = m.getExpenses();

        System.out.print("Νέα τιμή εξόδων: ");
        if (!input.hasNextDouble()) {
            input.next();
            System.out.println("Μη έγκυρη είσοδος.");
            return;
        }
        
        double newValue = input.nextDouble();
        
        if (newValue < 0) {
            System.out.println("Το ποσό δεν μπορεί να είναι αρνητικό.");
            return;
        }

        m.setExpenses(newValue);           
        changesLog.append("[" + m.getName() + "] " + oldValue + " → " + newValue + "\n");
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
    /**
    * Υπολογίζει το ισοζύγιο του προϋπολογισμού.
    *
    * @return το καθαρό ισοζύγιο (έσοδα - έξοδα)
    */
    public double calculateBalance() {
        System.out.println("\n===== ΙΣΟΖΥΓΙΟ & ΕΛΕΓΧΟΣ ΠΕΡΙΟΡΙΣΜΩΝ =====");
        double balance = budget.calculateBalance();

        System.out.printf("Έσοδα: %.2f%n", budget.getRevenue());
        System.out.printf("Έξοδα: %.2f%n", budget.getExpenses());
        System.out.printf("Καθαρό Ισοζύγιο: %.2f%n", balance);

        //ΕΛΕΓΧΟΣ 
        if (balance < 0) {
            System.out.println("ΚΑΤΑΣΤΑΣΗ: ΕΛΛΕΙΜΜΑ");
            // Έλεγχος αν το έλλειμμα ξεπερνά το 3% των εσόδων 
            if (Math.abs(balance) > (budget.getRevenue() * 0.03)) {
                System.out.println("ΠΡΟΣΟΧΗ: Το έλλειμμα υπερβαίνει τα όρια ασφαλείας!");
                System.out.println("Προτείνεται μείωση δαπανών στα Υπουργεία.");
            }
        } else if (balance > 0) {
            System.out.println("ΚΑΤΑΣΤΑΣΗ: ΠΛΕΟΝΑΣΜΑ");
        } else {
            System.out.println("ΚΑΤΑΣΤΑΣΗ: ΙΣΟΣΚΕΛΙΣΜΕΝΟΣ");
        }
        return balance;
    }


    // 5. ΑΝΑΛΥΣΗ ΕΣΟΔΩΝ/ΕΞΟΔΩΝ ΑΝΑ ΥΠΟΥΡΓΕΙΟ
    /**
    * Πραγματοποιεί ανάλυση εσόδων και εξόδων
    * για κάθε υπουργείο ξεχωριστά και εμφανίζει
    * αν υπάρχει πλεόνασμα ή έλλειμμα.
    */
    public void analyzeMinistryBudget() {

        System.out.println("\n===== ΑΝΑΛΥΣΗ ΑΝΑ ΥΠΟΥΡΓΕΙΟ =====");

        for (Ministry m : budget.getMinistries()) {
            double diff = m.getBalance();
            System.out.println("\n" + m.getName());
            System.out.println("Έσοδα: " + m.getRevenue());
            System.out.println("Έξοδα: " + m.getExpenses());
            System.out.println(diff >= 0 ? "Πλεόνασμα: " + diff : "Έλλειμμα: " + diff);
        }
    }

    // 6. TOP-3 ΚΑΤΗΓΟΡΙΕΣ ΕΣΟΔΩΝ/ΕΞΟΔΩΝ
    /**
    * Εμφανίζει τις τρεις πρώτες κατηγορίες υπουργείων
    * με τα υψηλότερα έσοδα ή έξοδα, ανάλογα με την
    * επιλογή του χρήστη.
    *
    * @param input ο Scanner για την εισαγωγή δεδομένων από τον χρήστη
    */
    public void showTopBudgetCategories(Scanner input) {

        System.out.println("\n1. Top-3 Υπουργεία με τα υψηλότερα έσοδα");
        System.out.println("2. Top-3 Υπουργεία με τα υψηλότερα έξοδα");
        System.out.print("Επιλογή: ");
        
        if (!input.hasNextInt()) {
            input.next();
            System.out.println("Μη έγκυρη είσοδος.");
            return;
        }

        int choice = input.nextInt();

        if (choice == 1) {
            showTop3(true);
        } else if (choice == 2) {
             showTop3(false);
        } else {
            System.out.println("Μη έγκυρη επιλογή.");
        }

    }

    private void showTop3(boolean isRevenue) {
        Ministry[] sorted = Arrays.copyOf(budget.getMinistries(), budget.getMinistries().length);
        
        Arrays.sort(sorted, (a, b) -> Double.compare(
            isRevenue ? b.getRevenue() : b.getExpenses(),
            isRevenue ? a.getRevenue() : a.getExpenses()
        ));
        
        System.out.println("\n--- TOP 3 ---");
        for (int i = 0; i < 3 && i < sorted.length; i++) {
            double value = isRevenue ? sorted[i].getRevenue() : sorted[i].getExpenses();
            System.out.println((i + 1) + ". " + sorted[i].getName() + ": " + value + " €");
        }
    }


    // 7. ΕΚΤΕΛΕΣΗ ΣΕΝΑΡΙΩΝ
    /**
    * Εκτελεί σενάρια μεταβολών στον προϋπολογισμό
    * μέσω διαδραστικού μενού, όπως αλλαγές σε έσοδα,
    * δαπάνες και στοιχεία υπουργείων.
    *
    * @param scanner ο Scanner για την εισαγωγή δεδομένων από τον χρήστη
    */
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

            if (!scanner.hasNextInt()) { 
                scanner.next(); 
                System.out.println("Μη έγκυρη είσοδος.");
                continue; 
            }

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

        if (!scanner.hasNextInt()) {
            scanner.next(); 
            return; 
        }

        int c = scanner.nextInt();
        if (c == 0) return; 

        double oldVal = 0;
        String label = "";

        switch (c) {
            case 1: oldVal = budget.getTaxes(); label = "Φόρων"; break;
            case 2: oldVal = budget.getSocialContributions(); label = "Εισφορών"; break;
            case 3: oldVal = budget.getSalesGoodsServices(); label = "Πωλήσεων"; break;
            case 4: oldVal = budget.getOtherCurrentRevenue(); label = "Λοιπών Εσόδων"; break;
            default: System.out.println("Μη έγκυρη επιλογή."); return;
        }

        System.out.print("Ποσοστό μεταβολής (%): ");
        if (!scanner.hasNextDouble()) {
            scanner.next(); 
            return;
        }
        double percent = scanner.nextDouble();
        double newVal = oldVal * (1 + percent / 100.0); // Υπολογισμός μεταβολής

        // Έλεγχος περιορισμού για αρνητικές τιμές
        if (newVal < 0) {
            System.out.println("Σφάλμα: Η μεταβολή αυτή οδηγεί σε αρνητικά έσοδα! Η πράξη ακυρώθηκε.");
        } else {
            // Ενημέρωση Budget
            switch (c) {
                case 1: budget.setTaxes(newVal); break;
                case 2: budget.setSocialContributions(newVal); break;
                case 3: budget.setSalesGoodsServices(newVal); break;
                case 4: budget.setOtherCurrentRevenue(newVal); break;
            }
            System.out.println("Επιτυχής αλλαγή! Νέα τιμή " + label + ": " + newVal + " €");
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

        if (!scanner.hasNextInt()) { scanner.next(); return; }
        int c = scanner.nextInt();
        if (c == 0) return; // Επιστροφή στο προηγούμενο μενού

        double oldVal = 0;
        String label = "";

        // 1. Επιλογή κατηγορίας δαπάνης
        switch (c) {
            case 1: oldVal = budget.getEmployeeCompensation(); label = "Μισθών"; break;
            case 2: oldVal = budget.getSocialBenefits(); label = "Συντάξεων"; break;
            case 3: oldVal = budget.getGoodsServicesPurchases(); label = "Λειτουργικών"; break;
            case 4: oldVal = budget.getTransfersExpenses(); label = "Μεταβιβάσεων"; break;
            case 5: oldVal = budget.getSubsidies(); label = "Επιδοτήσεων"; break;
            case 6: oldVal = budget.getAllocatedCredits(); label = "Πιστώσεων"; break;
            default:
                System.out.println("Μη έγκυρη επιλογή.");
                return;
        }

        // 2. Εισαγωγή ποσοστού
        System.out.print("Ποσοστό μεταβολής (%): ");
        if (!scanner.hasNextDouble()) { scanner.next(); return; }
        double percent = scanner.nextDouble();
        double newVal = oldVal * (1 + percent / 100.0);

        // 3. ΕΛΕΓΧΟΣ ΠΕΡΙΟΡΙΣΜΟΥ 
        // Εξασφαλίζουμε ότι καμία δαπάνη δεν θα γίνει αρνητική
        if (newVal < 0) {
            System.out.println("Σφάλμα: Οι δαπάνες δεν μπορούν να έχουν αρνητική τιμή! Η πράξη ακυρώθηκε.");
        } else {
            // 4. Ενημέρωση του Budget
            switch (c) {
                case 1: budget.setEmployeeCompensation(newVal); break;
                case 2: budget.setSocialBenefits(newVal); break;
                case 3: budget.setGoodsServicesPurchases(newVal); break;
                case 4: budget.setTransfersExpenses(newVal); break;
                case 5: budget.setSubsidies(newVal); break;
                case 6: budget.setAllocatedCredits(newVal); break;
            }
            System.out.println("Επιτυχής αλλαγή! Νέα τιμή " + label + ": " + newVal + " €");
        }

    }
      
        
    //ΜΕΡΟΣ 3ο της 7ης επιλογής - Σενάριο Αλλαγής σε Υπουργεία

    private void scenarioMinistries(Scanner scanner) {

        System.out.println("===== ΑΛΛΑΓΕΣ ΑΝΑ ΥΠΟΥΡΓΕΙΟ =====");
        Ministry[] ministries = budget.getMinistries();

        // 1. Εμφάνιση όλων των υπουργείων
        for (int i = 0; i < ministries.length; i++) {
            System.out.println((i + 1) + ". " + ministries[i].getName());
        }
        
        // 2. Επιλογή υπουργείου
        System.out.print("Επιλέξτε υπουργείο: ");
        if (!scanner.hasNextInt()) { scanner.next(); return; }
        int choice = scanner.nextInt() - 1;   // κάνουμε -1 για index πίνακα

        if (choice < 0 || choice >= ministries.length) {
            System.out.println("Μη έγκυρη επιλογή.");
            return;
        }

        // 3. Επιλογή τύπου αλλαγής
        System.out.println("Τι θέλετε να αλλάξετε;");
        System.out.println("1. Έσοδα υπουργείου");
        System.out.println("2. Έξοδα υπουργείου");
        System.out.print("Επιλογή: ");
        if (!scanner.hasNextInt()) { scanner.next(); return; }
        int type = scanner.nextInt();

        // 4. Ποσοστό μεταβολής
        System.out.print("Ποσοστό μεταβολής (%): ");
        if (!scanner.hasNextDouble()) { scanner.next(); return; }
        double percent = scanner.nextDouble();

        // 5. Ανάλογα με τον τύπο, αλλάζουμε έσοδα ή έξοδα
        Ministry m = ministries[choice];
        if (type == 1) {
            double oldVal = m.getRevenue();           
            double newVal = oldVal * (1 + percent / 100.0); 
            if(newVal < 0) {
                 System.out.println("Αδύνατη ενέργεια: Αρνητικά έσοδα.");
                 return;
            }
            m.setRevenue(newVal);        

            System.out.println("\n--- Αλλαγή ΕΣΟΔΩΝ ---");
            System.out.println("Υπουργείο: " + m.getName());
            System.out.println("Πριν: " + oldVal + " €");
            System.out.println("Μετά: " + newVal + " €");
        } else if (type == 2) {
            double oldVal = m.getExpenses();
            double newVal = oldVal * (1 + percent / 100.0);
            if(newVal < 0) {
                 System.out.println("Αδύνατη ενέργεια: Αρνητικά έξοδα.");
                 return;
            }
            m.setExpenses(newVal);
            
            System.out.println("\n--- Αλλαγή ΕΞΟΔΩΝ ---");
            System.out.println("Υπουργείο: " + m.getName());
            System.out.println("Πριν: " + oldVal + " €");
            System.out.println("Μετά: " + newVal + " €");
        }

    }

    // ΜΕΡΟΣ 4ο της 7ης επιλογής - Σενάριο Ταυτόχρονων Αλλαγών

    private void scenarioCombined(Scanner scanner) {

        System.out.println("===== ΤΑΥΤΟΧΡΟΝΕΣ ΑΛΛΑΓΕΣ =====");

        // Αποθήκευση αρχικών τιμών προυπολογισμού (πριν εκτελεστεί το σενάριο)
        double initialBalance = budget.calculateBalance();

        boolean done = false;

        while (!done) {
            System.out.println("\n--- Επιλέξτε τι θέλετε να αλλάξετε ---");
            System.out.println("1. Αλλαγές στα ΕΣΟΔΑ (φόροι, εισφορές κ.λπ.)");
            System.out.println("2. Αλλαγές στις ΔΑΠΑΝΕΣ (μισθοί, συντάξεις κ.λπ.)");
            System.out.println("3. Αλλαγές ανά ΥΠΟΥΡΓΕΙΟ (έσοδα/έξοδα υπουργείου)");
            System.out.println("0. Τέλος σεναρίου & εμφάνιση αποτελεσμάτων");
            System.out.print("Επιλογή: ");

            if (!scanner.hasNextInt()) { scanner.next(); continue; }
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
        double finalBalance = budget.calculateBalance();
        System.out.println("\n===== ΠΕΡΙΛΗΨΗ =====");
        System.out.printf("Αρχικό Ισοζύγιο: %.2f%n", initialBalance);
        System.out.printf("Τελικό Ισοζύγιο: %.2f%n", finalBalance);
        System.out.printf("Μεταβολή: %.2f%n", (finalBalance - initialBalance));
    }


    // 8. ΠΟΛΥΕΠΙΠΕΔΗ ΑΝΑΛΥΣΗ (% και Μηνιαία)
    /**
    * Παρουσιάζει αναλυτική κατανομή εσόδων ή εξόδων
    * του προϋπολογισμού σε ποσοστά καθώς και
    * εκτιμώμενα μηνιαία ποσά.
    *
    * @param scanner ο Scanner για την εισαγωγή δεδομένων από τον χρήστη
    */
    public void showDetailedAnalysis(Scanner scanner) {
        System.out.println("\n===== ΠΟΛΥΕΠΙΠΕΔΗ ΑΝΑΛΥΣΗ ΠΡΟΥΠΟΛΟΓΙΣΜΟΥ =====");
        System.out.println("1. Ανάλυση Δομής Εσόδων");
        System.out.println("2. Ανάλυση Δομής Εξόδων");
        System.out.print("Επιλογή: ");

        if (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Μη έγκυρη είσοδος.");
            return;
        }
        int choice = scanner.nextInt();

        java.util.ArrayList<CategoryItem> items = new java.util.ArrayList<>();
        double total = 0;

        if (choice == 1) {
            // --- ΑΝΑΛΥΣΗ ΕΣΟΔΩΝ ---
            total = budget.getRevenue(); // Παίρνει το νέο σωστό σύνολο

            // Έσοδα
            items.add(new CategoryItem("Φόροι", budget.getTaxes()));
            items.add(new CategoryItem("Κοινωνικές Εισφορές", budget.getSocialContributions()));
            items.add(new CategoryItem("Μεταβιβάσεις (Έσοδα)", budget.getTransfers()));
            items.add(new CategoryItem("Πωλήσεις Αγαθών/Υπηρ.", budget.getSalesGoodsServices()));
            items.add(new CategoryItem("Λοιπά Τρέχοντα Έσοδα", budget.getOtherCurrentRevenue()));
            items.add(new CategoryItem("Πάγια Περιουσιακά", budget.getFixedAssetsRevenue()));
            items.add(new CategoryItem("Χρεωστικοί Τίτλοι (Έσοδα)", budget.getDebtSecuritiesRevenue()));
            items.add(new CategoryItem("Δάνεια (Έσοδα)", budget.getLoansRevenue()));
            items.add(new CategoryItem("Συμμετοχικοί Τίτλοι", budget.getEquityShares()));
            items.add(new CategoryItem("Υποχρεώσεις (Νόμισμα)", budget.getDepositsLiabilities()));
            items.add(new CategoryItem("Χρεωστικοί Τίτλοι (Liab.)", budget.getDebtSecuritiesLiabilities()));
            items.add(new CategoryItem("Δάνεια (Liab.)", budget.getLoansLiabilities()));
            items.add(new CategoryItem("Παράγωγα", budget.getFinancialDerivatives()));

            // Έσοδα από Υπουργεία
            items.add(new CategoryItem("Έσοδα Υπουργείων", budget.getMinistriesRevenue()));

            System.out.println("\n--- ΚΑΤΑΝΟΜΗ ΕΣΟΔΩΝ (%) ---");

        } else if (choice == 2) {
            // --- ΑΝΑΛΥΣΗ ΕΞΟΔΩΝ ---
            total = budget.getExpenses(); 

            // Έξοδα
            items.add(new CategoryItem("Μισθοί & Παροχές", budget.getEmployeeCompensation()));
            items.add(new CategoryItem("Κοινωνικές Παροχές", budget.getSocialBenefits()));
            items.add(new CategoryItem("Μεταβιβάσεις (Έξοδα)", budget.getTransfersExpenses()));
            items.add(new CategoryItem("Αγορές Αγαθών/Υπηρ.", budget.getGoodsServicesPurchases()));
            items.add(new CategoryItem("Επιδοτήσεις", budget.getSubsidies()));
            items.add(new CategoryItem("Πιστώσεις υπό κατανομή", budget.getAllocatedCredits()));
            items.add(new CategoryItem("Τόκοι (Εξυπηρέτηση Χρέους)", budget.getInterestPayments()));
            items.add(new CategoryItem("Λοιπές Δαπάνες", budget.getOtherExpenses()));
            items.add(new CategoryItem("Πάγια Περιουσιακά (Έξοδα)", budget.getFixedAssetsExpenditure()));
            items.add(new CategoryItem("Τιμαλφή", budget.getValuables()));
            items.add(new CategoryItem("Δάνεια (Έξοδα)", budget.getLoansExpenses()));
            items.add(new CategoryItem("Συμμετοχικοί Τίτλοι (Έξοδα)", budget.getEquitySharesExpenses()));
            items.add(new CategoryItem("Χρεωστικοί Τίτλοι (Έξοδα)", budget.getDebtSecuritiesExpenses()));

            // Έξοδα από Υπουργεία
            items.add(new CategoryItem("Λειτουργικά Υπουργείων", budget.getMinistriesExpenses()));

            System.out.println("\n--- ΚΑΤΑΝΟΜΗ ΕΞΟΔΩΝ (%) ---");

        } else {
            System.out.println("Μη έγκυρη επιλογή.");
            return;
        }

        // Ταξινόμηση (από το μεγαλύτερο στο μικρότερο)
        items.sort((a, b) -> Double.compare(b.amount, a.amount));

        // Εκτύπωση Πίνακα
        System.out.printf("%-35s | %-15s | %-10s | %-15s%n", "ΚΑΤΗΓΟΡΙΑ", "ΠΟΣΟ (€)", "ΠΟΣΟΣΤΟ", "ΜΗΝΙΑΙΟ (Εκτ.)");
        System.out.println("---------------------------------------------------------------------------------------");

        for (CategoryItem item : items) {
            double percent = (total == 0) ? 0 : (item.amount / total) * 100.0;
            double monthly = item.amount / 12.0;
            System.out.printf("%-35s | %,15.0f | %6.2f%%   | %,15.0f%n", 
                item.name, item.amount, percent, monthly);
        }
        
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("%-35s | %,15.0f | %6.2f%%%n", "ΣΥΝΟΛΟ", total, 100.0);
    }

    // Βοηθητική κλάση για την αποθήκευση δεδομένων 
    private class CategoryItem {
        String name;
        double amount;
        public CategoryItem(String name, double amount) {
            this.name = name;
            this.amount = amount;
        }
    }

}
