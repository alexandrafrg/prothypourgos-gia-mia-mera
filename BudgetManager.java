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

    //εισαγωγη αλαγης ΝΕΦΕΛΗ
    public void modifyBudget(Scanner input) {
        System.out.println("Εισαγωγή Αλλαγής");
        for (int i = 0; i < budget.ministries.length; i++) {
            System.out.println((i + 1) + ". " + budget.ministries[i]);
        }
        System.out.print("Διαλέξτε υπουργείο: ");
        int index = input.nextInt() - 1;
        if (index < 0 || index >= budget.ministries.length) {
            System.out.println("Μη έγκυρη επιλογή!");
            return;
        }
        System.out.println("1. Έσοδα");
        System.out.println("2. Έξοδα");
        System.out.print("Τι θέλετε να αλλάξετε; ");
        int type = input.nextInt();
        if (type != 1 && type != 2) {
            System.out.println("Μη έγκυρη επιλογή!");
            return;   
        }
        System.out.print("Δώσε νέο ποσό: ");
        double newAmount = input.nextDouble();
        if (newAmount < 0) {
            System.out.println("Το ποσό δεν μπορεί να είναι αρνητικό!");
            return;
        }
        double oldValue;
        if (type == 1) {              
            oldValue = budget.ministryRevenue[index];
            budget.totalRevenue -= oldValue;
            budget.totalRevenue += newAmount;
            budget.ministryRevenue[index] = newAmount;
            System.out.println("Ενημερώθηκαν τα ΕΣΟΔΑ του: " + budget.ministries[index]);
        }
        else {
            oldValue = budget.ministryExpenses[index];
            budget.totalExpenditure -= oldValue;
            budget.totalExpenditure += newAmount;
            budget.ministryExpenses[index] = newAmount;
            System.out.println("Ενημερώθηκαν τα ΕΞΟΔΑ του: " + budget.ministries[index]);
        }
        System.out.println("Αλλαγή: " + oldValue + " → " + newAmount);
        System.out.println("Η αλλαγήκαταχωρήθηκε!");
    }  
    //τελος

    
    // Προβολή αλλαγών - ΚΩΝΝΑ
    public void displayChanges() {
        if (changesLog.isEmpty()) {
            System.out.println("\nΔεν έχουν γίνει αλλαγές.\n");
        } else {
            System.out.println("\n----- ΑΛΛΑΓΕΣ -----");
            System.out.println(changesLog.toString());
        }
    }

    //Η 7Η ΕΠΙΛΟΓΗ του μενού
    //Η μέθοδος που εκτελεί υποθετικά σενάρια και υπολογίζει τις επιπτώσεις τους
    public void executeScenario() {

         Scanner scanner = new Scanner(System.in);
         int choice;

         do {
            //Εμφανίζει το μενού για να επιλέξει ο χρήστης τι είδους σενάριο θέλει να εκτελέσει
            System.out.println("===== ΕΚΤΕΛΕΣΗ ΣΕΝΑΡΙΩΝ =====");
            System.out.println("1. Αλλαγές ΕΣΟΔΩΝ");
            System.out.println("2. Αλλαγές ΔΑΠΑΝΩΝ");
            System.out.println("3. Αλλαγές ανά Υπουργείο");
            System.out.println("0. Επιστροφή στο κεντρικό μενού");
            System.out.println("Επιλέξτε")
            choice = scanner.nextInt();

            switch(choice) {

                case 1: //Ο χρήστης θέλει να εκτελέσει σενάριο αλλαγής εσόδων
                scenarioRevenue(scanner);
                break;

                case 2: //Ο χρήστης θέλει να εκτελέσει σενάριο αλλαγής δαπανών
                scenarioExpenditure(scanner);
                break;

                case 3: //Ο χρήστης θέλει να εκτελέσει σενάριο αλλαγής σε υπουργεία 
                scenarioMinistries(scanner);
                break;

                case 0: // Ο χρήστης θέλει να βγει από την μέθοδο 
                System.out.println("Επιστροφή στο κύριο μενού");
                break;

                default: // Ο χρήστης δεν επελέξε έγκυρη επιλογή 
                System.out.println("Μη έγκυρη επιλογή.");
            }

         } while (choice != 0);
    }
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
        
        int i = 1;
        
        for (String ministry : budget.getMinistryBudget().keySet()) {
        System.out.println(i + ". " + ministry);
        i++;
        
        }
        
        System.out.print("Επίλεξε υπουργείο: ");
        int choice = scanner.nextInt();
        
        String selectedMinistry = "";
        int counter = 1;
        
        for (String ministry : budget.getMinistryBudget().keySet()) {
            
            if (counter == choice) {
                selectedMinistry = ministry;
            break;
        }
        
        counter++
        
        }
        
        System.out.print("Ποσοστό μεταβολής (%): ");
        double percent = scanner.nextDouble();
        
        double oldVal = budget.getMinistryBudget().get(selectedMinistry);
        double newVal = oldVal * (1 + percent / 100.0);
        
        budget.updateMinistryAmount(selectedMinistry, newVal);
        
        System.out.println("Το υπουργείο '" + selectedMinistry + "' ενημερώθηκε.");
        System.out.println("Πριν: " + oldVal + " €  →  Μετά: " + newVal + " €");

    }

    //ΜΕΡΟΣ 4ο της 7ης επιλογής - Σενάριο Ταυτόχρονων Αλλαγώ
    //Θα υλοποιηθεί σε επόμενη φάση , όχι ακόμα
}
//Η 4η επιλογή - Υπολογισμός Ισοζυγίου
public double calculateBalance(Budget b) {

    double totalRevenue = b.totalRevenue;

    // Άθροισμα όλων των εξόδων του Budget
    double totalExpenses =
            b.compensationEmployees +
            b.useGoodsServices +
            b.interestPayments +
            b.subsidies +
            b.socialBenefits +
            b.otherCurrentExpenses +
            b.fixedAssets +
            b.capitalTransfers +
            b.loans +
            b.equityShares +
            b.depositsLiabilities;

    double balance = totalRevenue - totalExpenses;

    System.out.println("===== ΥΠΟΛΟΓΙΣΜΟΣ ΙΣΟΖΥΓΙΟΥ =====");
    System.out.println("Συνολικά Έσοδα: " + totalRevenue);
    System.out.println("Συνολικές Δαπάνες: " + totalExpenses);

    if (balance > 0) {
        System.out.println("Πλεόνασμα: " + balance);
    } else if (balance < 0) {
        System.out.println("Έλλειμμα: " + balance);
    } else {
        System.out.println("Το ισοζύγιο είναι μηδενικό.");
    }

    return balance;
}
//ΤΕΛΟΣ 4ΗΣ ΕΠΙΛΟΓΗΣ
//ΜΥΡΤΩ
public class BudgetManager {

    private Budget budget;

    public BudgetManager(Budget budget) {
        this.budget = budget;
    }

    // ΑΝΑΛΥΣΗ ΕΣΟΔΩΝ
    public void analyzeRevenuePerMinistry() {
        System.out.println("ΑΝΑΛΥΣΗ ΕΣΟΔΩΝ ΑΝΑ ΥΠΟΥΡΓΕΙΟ");

        List<Map.Entry<String, Double>> list = new ArrayList<>();
        for (int i = 0; i < budget.ministries.length; i++) {
            list.add(Map.entry(budget.ministries[i], budget.ministryRevenue[i]));
        }

        // Ταξινόμηση από μεγαλύτερο σε μικρότερο
        list.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        for (Map.Entry<String, Double> entry : list) {
            System.out.printf("%-40s : %, .2f €\n", entry.getKey(), entry.getValue());
        }
    }

    //ΑΝΑΛΥΣΗ ΕΞΟΔΩΝ
    public void analyzeExpenditurePerMinistry() {
        System.out.println("ΑΝΑΛΥΣΗ ΕΞΟΔΩΝ ΑΝΑ ΥΠΟΥΡΓΕΙΟ");

        List<Map.Entry<String, Double>> list = new ArrayList<>();
        for (int i = 0; i < budget.ministries.length; i++) {
            list.add(Map.entry(budget.ministries[i], budget.ministryExpenses[i]));
        }

        list.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        for (Map.Entry<String, Double> entry : list) {
            System.out.printf("%-40s : %, .2f €\n", entry.getKey(), entry.getValue());
        }
    }

    // TOP-3 ΚΑΤΗΓΟΡΙΕΣ ΕΣΟΔΩΝ
    public void showTop3RevenueCategories() {
        Map<String, Double> categories = new HashMap<>();
        categories.put("Φόροι", budget.taxes);
        categories.put("Κοινωνικές εισφορές", budget.socialContributions);
        categories.put("Μεταβιβάσεις", budget.transfers);
        categories.put("Πωλήσεις αγαθών & υπηρεσιών", budget.salesGoodsServices);
        categories.put("Λοιπά τρέχοντα έσοδα", budget.otherCurrentRevenue);

        categories.put("Πάγια περιουσιακά στοιχεία", budget.fixedAssetsRevenue);
        categories.put("Χρεωστικοί τίτλοι (έσοδα)", budget.debtSecuritiesRevenue);
        categories.put("Δάνεια (έσοδα)", budget.loansRevenue);
        categories.put("Συμμετοχικοί τίτλοι & μερίδια", budget.equityShares);
        categories.put("Υποχρεώσεις από καταθέσεις", budget.depositsLiabilities);
        categories.put("Χρεωστικοί τίτλοι (υποχρεώσεις)", budget.debtSecuritiesLiabilities);
        categories.put("Δάνεια (υποχρεώσεις)", budget.loansLiabilities);
        categories.put("Παράγωγα", budget.financialDerivatives);

        // Ταξινόμηση και Top-3
        List<Map.Entry<String, Double>> sorted = categories.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .toList();

        System.out.println("TOP 3 ΚΑΤΗΓΟΡΙΕΣ ΕΣΟΔΩΝ");
        int rank = 1;
        for (var e : sorted) {
            System.out.printf("%d) %-40s : %, .2f €\n", rank++, e.getKey(), e.getValue());
        }
    }

    // TOP-3 ΚΑΤΗΓΟΡΙΕΣ ΕΞΟΔΩΝ
    public void showTop3ExpenditureCategories() {
        Map<String, Double> categories = new HashMap<>();
        categories.put("Παροχές σε εργαζομένους", budget.employeeCompensation);
        categories.put("Κοινωνικές παροχές", budget.socialBenefits);
        categories.put("Μεταβιβάσεις", budget.transfersExpenses);
        categories.put("Αγορές αγαθών & υπηρεσιών", budget.goodsServicesPurchases);
        categories.put("Επιδοτήσεις", budget.subsidies);
        categories.put("Τόκοι", budget.interestPayments);
        categories.put("Λοιπές δαπάνες", budget.otherExpenses);
        categories.put("Πιστώσεις υπό κατανομή", budget.allocatedCredits);
        categories.put("Πάγια περιουσιακά στοιχεία", budget.fixedAssetsExpenditure);
        categories.put("Τιμαλφή", budget.valuables);
        categories.put("Δάνεια", budget.loansExpenses);
        categories.put("Συμμετοχικοί τίτλοι/μερίδια", budget.equitySharesExpenses);
        categories.put("Χρεωστικοί τίτλοι", budget.debtSecuritiesExpenses);
        categories.put("Δάνεια (54)", budget.loansExpenses54);

        // Ταξινόμηση και Top-3
        List<Map.Entry<String, Double>> sorted = categories.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .toList();

        System.out.println("TOP 3 ΚΑΤΗΓΟΡΙΕΣ ΕΞΟΔΩΝ");
        int rank = 1;
        for (var e : sorted) {
            System.out.printf("%d) %-40s : %, .2f €\n", rank++, e.getKey(), e.getValue());
        }
    }
}
