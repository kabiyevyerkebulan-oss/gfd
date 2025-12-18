public class Main {
    public static void main(String[] args) {
        String[] options1 = {"JDK", "JRE", "JVM", "IDE"};
        Question q1 = new Question(
                1,
                "Какое сокращение означает Java Development Kit?",
                options1,
                0, // JDK
                5.0
        );

        String[] options2 = {"int", "String", "boolean", "char"};
        Question q2 = new Question(
                2,
                "Какой тип данных не является примитивным в Java?",
                options2,
                1, // String
                3.0
        );

        // Создадим копию q1 для демонстрации сравнения
        Question q1Copy = new Question(
                1,
                "Копия Q1 (текст изменен)",
                options1,
                0,
                5.0
        );

        // 2. Вывод их в консоль
        System.out.println("--- Список Вопросов ---");
        System.out.println(q1.toString());
        System.out.println(q2.toString());
        System.out.println(q1Copy.toString());

        System.out.println("\n--- Тестирование Методов ---");
        // Проверка ответа на Q1 (0 - правильный)
        System.out.println("Ответ на Q1 (индекс 0) правильный? " + q1.checkAnswer(0)); // true
        // Проверка ответа на Q2 (2 - неправильный)
        System.out.println("Ответ на Q2 (индекс 2) правильный? " + q2.checkAnswer(2)); // false

        // 3. Сравнение нескольких объектов
        System.out.println("\n--- Сравнение Объектов ---");
        // q1 и q1Copy имеют одинаковый ID
        System.out.println("Q1 равен Q1Copy (по ID)? " + q1.equals(q1Copy)); // true
        // q1 и q2 имеют разный ID
        System.out.println("Q1 равен Q2 (по ID)? " + q1.equals(q2)); // false

        // Демонстрация сеттера
        q1.setScoreValue(10.0);
        System.out.println("\nНовое значение баллов для Q1: " + q1.getScoreValue()); // 10.0
    }
    }
}
