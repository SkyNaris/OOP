/**
 * Клас гайдлайну
 */
public class Guideline {
    private String fileUrl;
    
    /**
     * Конструктор класу Guideline
     * @param url посилання на файл
     */
    public Guideline(String url) {
        this.fileUrl = url;
    }
    
    /**
     * Метод завантаження гайдлайну
     */
    public void download() {
        System.out.println("Завантаження гайдлайну з: " + fileUrl);
    }
}