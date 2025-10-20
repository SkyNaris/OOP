/**
 * Абстрактний клас особи
 */
public abstract class Person {
    private String name;
    
    /**
     * Конструктор класу Person
     * @param name ім'я особи
     */
    public Person(String name) {
        this.name = name;
    }
    
    /**
     * Отримати ім'я особи
     * @return ім'я особи
     */
    public String getName() {
        return name;
    }
    
    /**
     * Фінальний метод завершення контракту
     */
    public static final void finalizeContract() {
        System.out.println("Контракт завершено");
    }
}