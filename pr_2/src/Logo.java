/**
 * Клас логотипу
 */
public class Logo {
    private int conceptNum;
    
    /**
     * Конструктор класу Logo
     * @param num номер концепту
     */
    public Logo(int num) {
        this.conceptNum = num;
    }
    
    /**
     * Метод показу концепту
     */
    public void showConcept() {
        System.out.println("Показ концепту #" + conceptNum);
    }
}