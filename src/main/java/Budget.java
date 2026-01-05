public class Budget {
    //ΕΣΟΔΑ ΠΡΟΥΠΟΛΟΓΙΣΜΟΥ
    private double totalRevenue = 1304827000000.0; // Σύνολο Εσόδων
    private double taxes = 62055000000.0;              //Φόροι
    private double socialContributions = 60000000.0;   //Κοινωνικές εισφορές
    private double transfers = 8131000000.0;           //Μεταβιβάσεις
    private double salesGoodsServices = 2405000000.0;  //Πωλήσεις αγαθών & υπηρεσιών
    private double otherCurrentRevenue = 2775000000.0; //Λοιπά τρέχοντα έσοδα

    private double fixedAssetsRevenue = 37000000.0;    //Πάγια περιουσιακά στοιχεία
    private double debtSecuritiesRevenue = 11000000.0; //Χρεωστικοί τίτλοι
    private double loansRevenue = 20000000.0;          //Δάνεια
    private double equityShares = 467000000.0;         //Συμμετοχικοί τίτλοι & μερίδια
    private double depositsLiabilities = 66000000.0;   //Υποχρεώσεις από νόμισμα/καταθέσεις
    private double debtSecuritiesLiabilities = 25973000000.0; //Χρεωστικοί τίτλοι
    private double loansLiabilities = 1202027000000.0; //Δάνεια
    private double financialDerivatives = 800000000.0; //Παράγωγα

    //ΕΞΟΔΑ ΠΡΟΥΠΟΛΟΓΙΣΜΟΥ
    private double totalExpenditure = 1307907506000.0;       //Σύνολο εξόδων
    private double employeeCompensation = 14889199000.0;     //Παροχές σε εργαζομένους
    private double socialBenefits = 425136000.0;             //Κοινωνικές παροχές
    private double transfersExpenses = 34741365000.0;        //Μεταβιβάσεις
    private double goodsServicesPurchases = 2039542000.0;    //Αγορές αγαθών και υπηρεσιών
    private double subsidies = 80630000.0;                   //Επιδοτήσεις
    private double interestPayments = 7701101000.0;          //Τόκοι 
    private double otherExpenses = 101553000.0;              //Λοιπές δαπάνες
    private double allocatedCredits = 17283053000.0;         //Πιστώσεις υπό κατανομή
    private double fixedAssetsExpenditure = 2609600000.0;    //Πάγια περιουσιακά στοιχεία
    private double valuables = 85000.0;                      //Τιμαλφή
    private double loansExpenses = 3741000000.0;             //Δάνεια
    private double equitySharesExpenses = 1755112000.0;      //Συμμετοχικοί τίτλοι/μερίδια
    private double debtSecuritiesExpenses = 19375000000.0;   //Χρεωστικοί τίτλοι
    private double loansExpenses54 = 1203165130000.0;        //Δάνεια
    
    //ΠΙΝΑΚΑΣ ΜΕ ΥΠΟΥΡΓΕΙΑ
    public Ministry[] ministries;

    // ΑΡΧΙΚΟ ΙΣΟΖΥΓΙΟ
    private double result = -3080506000.0; //Έσοδα - Έξοδα (αρχικό - πριν τις αλλαγές)

    // CONSTRUCTOR : αρχικοποιεί όλα τα υπουργεία
    public Budget() {
        ministries = new Ministry[] {
            new Ministry("Υπουργείο Εσωτερικών", 3449276000.0, 3830276000.0),
            new Ministry("Υπουργείο Εξωτερικών", 390237000.0, 420237000.0),
            new Ministry("Υπουργείο Εθνικής Άμυνας", 6061000000.0, 6130000000.0),
            new Ministry("Υπουργείο Υγείας", 6608424000.0, 7177424000.0),
            new Ministry("Υπουργείο Δικαιοσύνης", 577803000.0, 650803000.0),
            new Ministry("Υπουργείο Παιδείας", 5594000000.0, 6606000000.0),
            new Ministry("Υπουργείο Πολιτισμού", 257419000.0, 575419000.0),
            new Ministry("Υπουργείο Εθνικής Οικονομίας & Οικονομικών", 1243381464000.0, 1246518464000.0),
            new Ministry("Υπουργείο Αγροτικής Ανάπτυξης & Τροφίμων", 222403000.0, 1281403000.0),
            new Ministry("Υπουργείο Περιβάλλοντος & Ενέργειας", 319227000.0, 2341227000.0),
            new Ministry("Υπουργείο Εργασίας & Κοινωνικής Ασφάλισης", 18215084000.0, 18678084000.0),
            new Ministry("Υπουργείο Κοινωνικής Συνοχής & Οικογένειας", 3786553000.0, 3989553000.0),
            new Ministry("Υπουργείο Ανάπτυξης", 123045000.0, 818045000.0),
            new Ministry("Υπουργείο Υποδομών & Μεταφορών", 881810000.0, 2694810000.0),
            new Ministry("Υπουργείο Ναυτιλίας & Νησιωτικής Πολιτικής", 336864000.0, 651864000.0),
            new Ministry("Υπουργείο Τουρισμού", 39293000.0, 189293000.0),
            new Ministry("Υπουργείο Ψηφιακής Διακυβέρνησης", 151928000.0, 1073928000.0),
            new Ministry("Υπουργείο Μετανάστευσης & Ασύλου", 141871000.0, 475871000.0),
            new Ministry("Υπουργείο Προστασίας του Πολίτη", 2217820000.0, 2285820000.0),
            new Ministry("Υπουργείο Κλιματικής Κρίσης & Πολιτικής Προστασίας", 760116000.0, 1221116000.0)
        };
    }

    // ΥΠΟΛΟΓΙΣΜΟΣ ΣΥΝΟΛΙΚΩΝ ΕΣΟΔΩΝ ΤΩΝ ΥΠΟΥΡΓΕΙΩΝ
    public double getMinistriesRevenue() {
        double sum = 0;
        for (Ministry m : ministries) {
            sum += m.getRevenue();
        }
        return sum;
    }

    // ΥΠΟΛΟΓΙΣΜΟΣ ΣΥΝΟΛΙΚΩΝ ΕΞΟΔΩΝ ΤΩΝ ΥΠΟΥΡΓΕΙΩΝ
    public double getMinistriesExpenses() {
        double sum = 0;
        for (Ministry m : ministries) {
            sum += m.getExpenses();
        }
        return sum;
    }

    // ΣΥΝΟΛΙΚΑ ΕΣΟΔΑ ΠΡΟΥΠΟΛΟΓΙΣΜΟΥ (ΥΠΟΥΡΓΕΙΑ + ΥΠΟΛΟΙΠΑ)
    public double getTotalRevenue() {
        return totalRevenue + getMinistriesRevenue();
    }

    // ΣΥΝΟΛΙΚΑ ΕΣΟΔΑ ΠΡΟΥΠΟΛΟΓΙΣΜΟΥ (ΥΠΟΥΡΓΕΙΑ + ΥΠΟΛΟΙΠΑ)
    public double getTotalExpenditure() {
        return totalExpenditure + getMinistriesExpenses();
    }

    // ΥΠΟΛΟΓΙΣΜΟΣ ΙΣΟΖΥΓΙΟ (έσοδα - έξοδα)
    public double calculateBalance() {
        return getTotalRevenue() - getTotalExpenditure();
    }
    public double getRevenue() {
        return getTotalRevenue();
    }

    public double getExpenses() {
        return getTotalExpenditure();
    }
}
