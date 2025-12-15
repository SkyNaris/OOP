from abc import ABC, abstractmethod

# --- 1. Базовий абстрактний клас ---
class ProjectParticipant(ABC):
    def __init__(self, name):
        self.name = name

    # Абстрактний метод, який обов'язково мають реалізувати нащадки
    @abstractmethod
    def role_info(self):
        pass

# --- 2. Клас Дизайнер (Designer) ---
class Designer(ProjectParticipant):
    def role_info(self):
        return "Дизайнер"

    def create_concepts(self):
        print(f"[Дизайнер] {self.name} розробляє та надсилає 3 концепти логотипу.")

    def send_final_files(self):
        print(f"[Дизайнер] {self.name} передає гайдлайн і файли у хмарне сховище.")

# --- 3. Клас Замовник (Client) ---
class Client(ProjectParticipant):
    def role_info(self):
        return "Замовник"

    def fill_brief(self):
        print(f"[Замовник] {self.name} заповнює бриф.")

    def approve_work(self):
        print(f"[Замовник] {self.name} погоджує правки і фінальний варіант.")

# --- 4. Клас Проєкт (Система управління) ---
class DesignProject:
    def __init__(self, client, designer, project_name):
        # Агрегація: проєкт містить посилання на конкретних людей
        self.client = client
        self.designer = designer
        self.project_name = project_name

    def start_workflow(self):
        print(f"\n======== Запуск проєкту: '{self.project_name}' ========")
        
     # Крок 1: Замовник заповнює бриф
        self.client.fill_brief()
        
        # Крок 2: Дизайнер надсилає 3 концепти
        self.designer.create_concepts()
        
        # Крок 3: Замовник погоджує правки і фінал
        self.client.approve_work()
        
        # Крок 4: Дизайнер передає файли у хмарне сховище
        self.designer.send_final_files()
        
        print(f"======== Проєкт '{self.project_name}' успішно завершено! ========\n")


# --- 5. Точка входу в програму (Main) ---
if __name__ == "__main__":
    # Створюємо конкретних учасників (Objects)
    client_oleksiy = Client("Олексій Петренко")
    designer_maria = Designer("Марія Іваненко")

    # Створюємо проєкт і передаємо туди наших учасників
    my_project = DesignProject(client_oleksiy, designer_maria, "Ребрендінг Кав'ярні")

    # Запускаємо імітацію процесу
    my_project.start_workflow()
    