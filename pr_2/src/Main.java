/**
 * Головний клас програми
 */
public class Main {
    public static void main(String[] args) {
        // Створення об'єктів
        Customer customer = new Customer("Іван");
        Designer designer = new Designer("Марія");
        
        // Демонстрація процесу
        Brief brief = customer.fillBrief();
        System.out.println("Деталі брифу: " + brief.getDetails());
        
        designer.sendConcepts();
        customer.acceptConcepts();
        customer.approveEdits();
        
        designer.sendFinalFiles();
        Guideline guideline = designer.createGuideline();
        guideline.download();
        
        // Завершення контракту
        Person.finalizeContract();
    }
}