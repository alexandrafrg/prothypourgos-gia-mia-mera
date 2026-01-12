import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MinistryTest {
    @Test
    void testMinistryBalance() {
        // Δημιουργούμε ένα δοκιμαστικό υπουργείο: Έσοδα 1000, Έξοδα 800
        Ministry m = new Ministry("Test Ministry", 1000.0, 800.0);
        
        // Έλεγχος αν το υπόλοιπο είναι όντως 200
        assertEquals(200.0, m.getBalance(), "Ο υπολογισμός ισοζυγίου του υπουργείου είναι λάθος");
        
        // Αλλαγή εξόδων και επανέλεγχος
        m.setExpenses(1200.0);
        assertEquals(-200.0, m.getBalance(), "Το υπόλοιπο μετά την αύξηση εξόδων είναι λάθος");
    }
}