import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BudgetManagerTest {

    @Test
    public void testCalculateBalance() {
        // 1. Προετοιμασία (Setup)
        Budget testBudget = new Budget();

        // ΚΟΛΠΟ: Αλλάζουμε τα τεράστια ποσά με μικρά νούμερα για να ελέγξουμε την πράξη εύκολα.
        
        // Ορίζουμε τα Έσοδα να είναι 1000 ευρώ
        testBudget.totalRevenue = 1000.0;

        // Ορίζουμε τα Έξοδα (βάζουμε μόνο 2 υπουργεία για ευκολία)
        // Το άθροισμα εξόδων θα είναι: 200 + 300 = 500 ευρώ
        testBudget.ministryExpenses = new double[] { 200.0, 300.0 };

        // Φτιάχνουμε τον Manager
        BudgetManager manager = new BudgetManager(testBudget);

        // 2. Εκτέλεση (Act)
        // Η μέθοδος θα κάνει: Έσοδα (1000) - Έξοδα (500)
        double apotelesma = manager.calculateBalance();

        // 3. Έλεγχος (Assert)
        // Περιμένουμε το αποτέλεσμα να είναι 500.0
        assertEquals(500.0, apotelesma, 0.001);
    }
}