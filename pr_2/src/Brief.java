/**
 * Клас брифу
 */
public class Brief {
    private String details;
    
    /**
     * Конструктор класу Brief
     * @param details деталі брифу
     */
    public Brief(String details) {
        this.details = details;
    }
    
    /**
     * Отримати деталі брифу
     * @return деталі брифу
     */
    public String getDetails() {
        return details;
    }
}