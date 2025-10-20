/**
 * Клас замовника
 */
public class Customer extends Person {
    private Brief brief;
    
    /**
     * Конструктор класу Customer
     * @param name ім'я замовника
     */
    public Customer(String name) {
        super(name);
    }
    
    /**
     * Метод заповнення брифу
     * @return заповнений бриф
     */
    public Brief fillBrief() {
        System.out.println("Замовник " + getName() + " заповнює бриф");
        brief = new Brief("Деталі проєкту");
        return brief;
    }
    
    /**
     * Метод прийняття концептів
     */
    public void acceptConcepts() {
        System.out.println("Замовник " + getName() + " приймає концепти");
    }
    
    /**
     * Метод погодження правок
     */
    public void approveEdits() {
        System.out.println("Замовник " + getName() + " погоджує правки");
    }
}