import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BudgetTest {
    @Test
    void testBudgetCalculations() {
        Budget b = new Budget();
        
        // Έλεγχος αν τα συνολικά έσοδα είναι μεγαλύτερα από τους φόρους (αφού υπάρχουν και άλλες πηγές)
        assertTrue(b.getRevenue() > b.getTaxes(), "Τα έσοδα πρέπει να περιλαμβάνουν όλες τις κατηγορίες");
        
        // Έλεγχος αν η μέθοδος calculateBalance εκτελεί σωστά την αφαίρεση
        double expected = b.getRevenue() - b.getExpenses();
        assertEquals(expected, b.calculateBalance(), 0.01, "Το συνολικό ισοζύγιο υπολογίζεται λάθος");
    }
}
