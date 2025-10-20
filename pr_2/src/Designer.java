/**
 * Клас дизайнера
 */
public class Designer extends Person implements ILogoProcess {
    private Logo[] concepts;
    private Guideline guideline;
    
    /**
     * Конструктор класу Designer
     * @param name ім'я дизайнера
     */
    public Designer(String name) {
        super(name);
        concepts = new Logo[3];
        for (int i = 0; i < 3; i++) {
            concepts[i] = new Logo(i + 1);
        }
    }
    
    @Override
    public void sendConcepts() {
        System.out.println("Дизайнер " + getName() + " надсилає концепти:");
        for (Logo logo : concepts) {
            logo.showConcept();
        }
    }
    
    @Override
    public void sendFinalFiles() {
        System.out.println("Дизайнер " + getName() + " надсилає фінальні файли");
    }
    
    /**
     * Метод створення гайдлайну
     * @return створений гайдлайн
     */
    public Guideline createGuideline() {
        guideline = new Guideline("file://guideline.pdf");
        System.out.println("Дизайнер " + getName() + " створює гайдлайн");
        return guideline;
    }
}