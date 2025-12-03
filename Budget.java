
public class Budget {
    //ΕΣΟΔΑ ΠΡΟΥΠΟΛΟΓΙΣΜΟΥ
    public double totalRevenue = 1304827000000.0; // Σύνολο Εσόδων
    public double taxes = 62055000000.0;              //Φόροι
    public double socialContributions = 60000000.0;   //Κοινωνικές εισφορές
    public double transfers = 8131000000.0;           //Μεταβιβάσεις
    public double salesGoodsServices = 2405000000.0;  //Πωλήσεις αγαθών & υπηρεσιών
    public double otherCurrentRevenue = 2775000000.0; //Λοιπά τρέχοντα έσοδα

    public double fixedAssetsRevenue = 37000000.0;    //Πάγια περιουσιακά στοιχεία
    public double debtSecuritiesRevenue = 11000000.0; //Χρεωστικοί τίτλοι
    public double loansRevenue = 20000000.0;          //Δάνεια
    public double equityShares = 467000000.0;         //Συμμετοχικοί τίτλοι & μερίδια
    public double depositsLiabilities = 66000000.0;   //Υποχρεώσεις από νόμισμα/καταθέσεις
    public double debtSecuritiesLiabilities = 25973000000.0; //Χρεωστικοί τίτλοι
    public double loansLiabilities = 1202027000000.0; //Δάνεια
    public double financialDerivatives = 800000000.0; //Παράγωγα

    //ΕΞΟΔΑ ΠΡΟΥΠΟΛΟΓΙΣΜΟΥ
    public double totalExpenditure = 1307907506000.0;       //Σύνολο εξόδων
    public double employeeCompensation = 14889199000.0;     //Παροχές σε εργαζομένους
    public double socialBenefits = 425136000.0;             //Κοινωνικές παροχές
    public double transfersExpenses = 34741365000.0;        //Μεταβιβάσεις
    public double goodsServicesPurchases = 2039542000.0;    //Αγορές αγαθών και υπηρεσιών
    public double subsidies = 80630000.0;                   //Επιδοτήσεις
    public double interestPayments = 7701101000.0;          //Τόκοι
    public double otherExpenses = 101553000.0;              //Λοιπές δαπάνες
    public double allocatedCredits = 17283053000.0;         //Πιστώσεις υπό κατανομή
    public double fixedAssetsExpenditure = 2609600000.0;    //Πάγια περιουσιακά στοιχεία
    public double valuables = 85000.0;                      //Τιμαλφή
    public double loansExpenses = 3741000000.0;             //Δάνεια
    public double equitySharesExpenses = 1755112000.0;      //Συμμετοχικοί τίτλοι/μερίδια
    public double debtSecuritiesExpenses = 19375000000.0;   //Χρεωστικοί τίτλοι
    public double loansExpenses54 = 1203165130000.0;        //Δάνεια

    //ΙΣΟΖΥΓΙΟ
    public double result = -3080506000.0; //Έσοδα - Έξοδα (αρχικό - πριν τις αλλαγές)

    //ΛΟΓΑΡΙΑΣΜΟΙ ΑΝΑ ΥΠΟΥΡΓΕΙΟ 

    //ΠΙΝΑΚΑΣ ΜΕ ΤΑ ΟΝΟΜΑΤΑ ΤΩΝ ΥΠΟΥΡΓΕΙΩΝ 

    public String[] ministries = {
        "Υπουργείο Εσωτερικών",
        "Υπουργείο Εξωτερικών",
        "Υπουργείο Εθνικής Άμυνας",
        "Υπουργείο Υγείας",
        "Υπουργείο Δικαιοσύνης",
        "Υπουργείο Παιδείας",
        "Υπουργείο Πολιτισμού",
        "Υπουργείο Εθνικής Οικονομίας & Οικονομικών",
        "Υπουργείο Αγροτικής Ανάπτυξης & Τροφίμων",
        "Υπουργείο Περιβάλλοντος & Ενέργειας",
        "Υπουργείο Εργασίας & Κοινωνικής Ασφάλισης",
        "Υπουργείο Κοινωνικής Συνοχής & Οικογένειας",
        "Υπουργείο Ανάπτυξης",
        "Υπουργείο Υποδομών & Μεταφορών",
        "Υπουργείο Ναυτιλίας & Νησιωτικής Πολιτικής",
        "Υπουργείο Τουρισμού",
        "Υπουργείο Ψηφιακής Διακυβέρνησης",
        "Υπουργείο Μετανάστευσης & Ασύλου",
        "Υπουργείο Προστασίας του Πολίτη",
        "Υπουργείο Κλιματικής Κρίσης & Πολιτικής Προστασίας"
    };

    //ΠΙΝΑΚΑΣ ΜΕ ΤΑ ΕΣΟΔΑ ΤΩΝ ΥΠΟΥΡΓΕΙΩΝ
    
    public double[] ministryRevenue = {
        3449276000.0,
        390237000.0,
        6061000000.0,
        6608424000.0,
        577803000.0,
        5594000000.0,
        257419000.0,
        1243381464000.0,
        222403000.0,
        319227000.0,
        18215084000.0,
        3786553000.0,
        123045000.0,
        881810000.0,
        336864000.0,
        39293000.0,
        151928000.0,
        141871000.0,
        2217820000.0,
        760116000.0
    };

    //ΠΙΝΑΚΑΣ ΜΕ ΤΑ ΕΞΟΔΑ ΤΩΝ ΥΠΟΥΡΓΕΙΩΝ
    
    public double[] ministryExpenses = {
        3830276000.0,
        420237000.0,
        6130000000.0,
        7177424000.0,
        650803000.0,
        6606000000.0,
        575419000.0,
        1246518464000.0,
        1281403000.0,
        2341227000.0,
        18678084000.0,
        3989553000.0,
        818045000.0,
        2694810000.0,
        651864000.0,
        189293000.0,
        1073928000.0,
        475871000.0,
        2285820000.0,
        1221116000.0
    };
    public int compensationEmployees;
    public int useGoodsServices;
    public int otherCurrentExpenses;
    public int fixedAssets;
    public int capitalTransfers;
    public int loans;
    public double getRevenue() {
        return totalRevenue;
    }
    public double getExpenses() {
        double sum = 0;
        for (double expense : ministryExpenses) {
            sum += expense;
        }
        return sum;
    }
}

