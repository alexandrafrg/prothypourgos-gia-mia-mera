import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

class BudgetManagerTest {
    @Test
    void testModifyBudgetInteraction() {
        Budget b = new Budget();
        BudgetManager manager = new BudgetManager(b);
        
        // Επιλέγουμε το πρώτο υπουργείο της λίστας
        Ministry target = b.getMinistries()[0];
        
        // Προσομοίωση εισόδου χρήστη: "1" για το υπουργείο και "9999" για τα νέα έξοδα
        String simulatedInput = "1\n9999\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner scanner = new Scanner(System.in);

        // Εκτέλεση της μεθόδου τροποποίησης
        manager.modifyBudget(scanner);

        // Επαλήθευση ότι η τιμή άλλαξε όντως στο αντικείμενο
        assertEquals(9999.0, target.getExpenses(), "Η αλλαγή εξόδων μέσω του Manager απέτυχε");
    }
}