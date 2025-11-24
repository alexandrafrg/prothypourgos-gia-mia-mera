import java.util.Scanner;

public class BudgetManager {

    private Budget budget;      // το αντικείμενο με τα ποσά
    private String changesLog = "";  // ιστορικό αλλαγών

    public BudgetManager(Budget budget) {
        this.budget = budget;
    }

    // Προβολή τρέχοντος προϋπολογισμού
    public void displayBudget() {
        System.out.println("\n----- ΤΡΕΧΩΝ ΠΡΟΫΠΟΛΟΓΙΣΜΟΣ -----");
        System.out.println("1. Παιδεία: " + budget.education);
        System.out.println("2. Υγεία: " + budget.health);
        System.out.println("3. Άμυνα: " + budget.defense);
        System.out.println("4. Μεταφορές: " + budget.transport);
        System.out.println("---------------------------------\n");
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

    // Προβολή όλων των αλλαγών
    public void displayChanges() {
        if (changesLog.isEmpty()) {
            System.out.println("\nΔεν έχουν γίνει αλλαγές.\n");
        } else {
            System.out.println("\n----- ΑΛΛΑΓΕΣ -----");
            System.out.println(changesLog);
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

    }

    //ΜΕΡΟΣ 2ο της 7ης επιλογής - Σενάριο Αλλαγής Δαπανών

    //ΜΕΡΟΣ 3ο της 7ης επιλογής - Σενάριο Αλλαγής σε Υπουργεία
    


}
