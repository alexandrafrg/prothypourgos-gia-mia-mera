public class Budget {
    //ΕΣΟΔΑ ΠΡΟΥΠΟΛΟΓΙΣΜΟΥ
    private double taxes = 62055000000.0;              //Φόροι
    private double socialContributions = 60000000.0;   //Κοινωνικές εισφορές
    private double transfers = 8131000000.0;           //Μεταβιβάσεις
    private double salesGoodsServices = 2405000000.0;  //Πωλήσεις αγαθών & υπηρεσιών
    private double otherCurrentRevenue = 2775000000.0; //Λοιπά τρέχοντα έσοδα
    private double fixedAssetsRevenue = 37000000.0;           // Πάγια περιουσιακά στοιχεία
    private double debtSecuritiesRevenue = 11000000.0;        // Χρεωστικοί τίτλοι
    private double loansRevenue = 20000000.0;                 // Δάνεια
    private double equityShares = 467000000.0;                // Συμμετοχικοί τίτλοι
    private double depositsLiabilities = 66000000.0;          // Υποχρεώσεις από νόμισμα
    private double debtSecuritiesLiabilities = 25973000000.0; // Χρεωστικοί τίτλοι (Liabilities)
    private double loansLiabilities = 120202700000.0;         // Δάνεια (Liabilities)
    private double financialDerivatives = 80000000.0;         // Παράγωγα

    //ΕΞΟΔΑ ΠΡΟΥΠΟΛΟΓΙΣΜΟΥ
    private double employeeCompensation = 14889199000.0;      //Παροχές σε εργαζομένους
    private double socialBenefits = 425136000.0;              //Κοινωνικές παροχές
    private double transfersExpenses = 34741365000.0;         //Μεταβιβάσεις
    private double goodsServicesPurchases = 2039542000.0;     //Αγορές αγαθών και υπηρεσιών
    private double subsidies = 80630000.0;                    //Επιδοτήσεις
    private double allocatedCredits = 17283053000.0;          //Πιστώσεις υπό κατανομή
    private double interestPayments = 7701101000.0;           // Τόκοι
    private double otherExpenses = 101553000.0;               // Λοιπές δαπάνες
    private double fixedAssetsExpenditure = 2609600000.0;     // Πάγια περιουσιακά (Έξοδα)
    private double valuables = 85000.0;                       // Τιμαλφή
    private double loansExpenses = 3741000000.0;              // Δάνεια (Έξοδα)
    private double equitySharesExpenses = 1755112000.0;        //Συμμετοχικοί τίτλοι/μερίδια
    private double debtSecuritiesExpenses = 19375000000.0;     //Χρεωστικοί τίτλοι


    
    //ΠΙΝΑΚΑΣ ΜΕ ΥΠΟΥΡΓΕΙΑ
    private Ministry[] ministries;

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

    public Ministry[] getMinistries() { return ministries; }
    
    // Getters/Setters για Έσοδα
    public double getTaxes() { return taxes; }
    public void setTaxes(double taxes) { this.taxes = taxes; }

    public double getSocialContributions() { return socialContributions; }
    public void setSocialContributions(double val) { this.socialContributions = val; }

    public double getSalesGoodsServices() { return salesGoodsServices; }
    public void setSalesGoodsServices(double val) { this.salesGoodsServices = val; }

    public double getOtherCurrentRevenue() { return otherCurrentRevenue; }
    public void setOtherCurrentRevenue(double val) { this.otherCurrentRevenue = val; }

    public double getTransfers() { return transfers; }
    public void setTransfers(double val) { this.transfers = val; }

    public double getFixedAssetsRevenue() { return fixedAssetsRevenue; }
    public void setFixedAssetsRevenue(double val) { this.fixedAssetsRevenue = val; }

    public double getDebtSecuritiesRevenue() { return debtSecuritiesRevenue; }
    public void setDebtSecuritiesRevenue(double val) { this.debtSecuritiesRevenue = val; }

    public double getLoansRevenue() { return loansRevenue; }
    public void setLoansRevenue(double val) { this.loansRevenue = val; }

    public double getEquityShares() { return equityShares; }
    public void setEquityShares(double val) { this.equityShares = val; }

    public double getDepositsLiabilities() { return depositsLiabilities; }
    public void setDepositsLiabilities(double val) { this.depositsLiabilities = val; }

    public double getDebtSecuritiesLiabilities() { return debtSecuritiesLiabilities; }
    public void setDebtSecuritiesLiabilities(double val) { this.debtSecuritiesLiabilities = val; }

    public double getLoansLiabilities() { return loansLiabilities; }
    public void setLoansLiabilities(double val) { this.loansLiabilities = val; }

    public double getFinancialDerivatives() { return financialDerivatives; }
    public void setFinancialDerivatives(double val) { this.financialDerivatives = val; }

    // Getters/Setters για Έξοδα
    public double getEmployeeCompensation() { return employeeCompensation; }
    public void setEmployeeCompensation(double val) { this.employeeCompensation = val; }

    public double getSocialBenefits() { return socialBenefits; }
    public void setSocialBenefits(double val) { this.socialBenefits = val; }

    public double getGoodsServicesPurchases() { return goodsServicesPurchases; }
    public void setGoodsServicesPurchases(double val) { this.goodsServicesPurchases = val; }

    public double getTransfersExpenses() { return transfersExpenses; }
    public void setTransfersExpenses(double val) { this.transfersExpenses = val; }

    public double getSubsidies() { return subsidies; }
    public void setSubsidies(double val) { this.subsidies = val; }

    public double getAllocatedCredits() { return allocatedCredits; }
    public void setAllocatedCredits(double val) { this.allocatedCredits = val; }

    public double getInterestPayments() { return interestPayments; }
    public void setInterestPayments(double val) { this.interestPayments = val; }

    public double getOtherExpenses() { return otherExpenses; }
    public void setOtherExpenses(double val) { this.otherExpenses = val; }

    public double getFixedAssetsExpenditure() { return fixedAssetsExpenditure; }
    public void setFixedAssetsExpenditure(double val) { this.fixedAssetsExpenditure = val; }

    public double getValuables() { return valuables; }
    public void setValuables(double val) { this.valuables = val; }

    public double getLoansExpenses() { return loansExpenses; }
    public void setLoansExpenses(double val) { this.loansExpenses = val; }

    public double getEquitySharesExpenses() { return equitySharesExpenses; }
    public void setEquitySharesExpenses(double val) { this.equitySharesExpenses = val; }

    public double getDebtSecuritiesExpenses() { return debtSecuritiesExpenses; }
    public void setDebtSecuritiesExpenses(double val) { this.debtSecuritiesExpenses = val; }
    

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
    
    // Υπολογισμός Εσόδων: Κατηγορίες Εσόδων + Έσοδα Υπουργείων
    public double getRevenue() {
        return taxes 
             + socialContributions 
             + transfers 
             + salesGoodsServices 
             + otherCurrentRevenue 
             + fixedAssetsRevenue 
             + debtSecuritiesRevenue 
             + loansRevenue 
             + equityShares 
             + depositsLiabilities 
             + debtSecuritiesLiabilities 
             + loansLiabilities 
             + financialDerivatives
             + getMinistriesRevenue();
    }

    // Υπολογισμός Εξόδων: Κατηγορίες Εξόδων + Έξοδα Υπουργείων
    public double getExpenses() {
        return employeeCompensation 
             + socialBenefits 
             + transfersExpenses 
             + goodsServicesPurchases 
             + subsidies 
             + allocatedCredits 
             + interestPayments 
             + otherExpenses 
             + fixedAssetsExpenditure 
             + valuables 
             + loansExpenses 
             + equitySharesExpenses 
             + debtSecuritiesExpenses
             + getMinistriesExpenses();
    }

    
    // ΥΠΟΛΟΓΙΣΜΟΣ ΙΣΟΖΥΓΙΟΥ (έσοδα - έξοδα)
    public double calculateBalance() {
        return getRevenue() - getExpenses();
    }
    
}
