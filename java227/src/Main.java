public class Main {
    public static void main(String[] args) {
        String[] options1 = {"A1", "A2", "A3", "A4"};
        Question q1 = new Question(
                "Q1",
                options1,
                0,
                5.0
        );

        String[] options2 = {"A1", "A2", "A3", "A4"};
        Question q2 = new Question(
                "Q2",
                options2,
                1,
                3.0
        );

        System.out.println("Список Вопросов:");
        System.out.println(q1.toString());
        System.out.println(q2.toString());

        System.out.println("\nТестирование Методов:");
        System.out.println("Ответ на Q1 (индекс 0) правильный? " + q1.checkAnswer(0));
        System.out.println("Ответ на Q2 (индекс 2) правильный? " + q2.checkAnswer(2));

        System.out.println("\nСравнение Объектов");
        System.out.println("Q1 равен Q1 (по ID)? " + q1.equals(q1));
        System.out.println("Q1 равен Q2 (по ID)? " + q1.equals(q2));

    Candidate c1 = new Candidate(
            "C1", 85.0
    );
    Candidate c2 = new Candidate(
            "C2", 92.5
    );

    System.out.println(c1.toString());
    System.out.println(c2.toString());

    if (c1.getScore() > c2.getScore()) {
        System.out.println(c1.getName() + " набрал больше баллов!");
    }
    else {
        System.out.println(c2.getName() + " набрал больше баллов!");
    }

    System.out.println("Это один и тот же человек? " + c1.equals(c2));

        Exam javaTest = new Exam(
                "E1", 70.0
        );

        System.out.println(javaTest);

        if (javaTest.isPassed(c1.getScore())) {
            System.out.println("Результат: " + c1.getName() + " успешно сдал экзамен!");
        } else {
            System.out.println("Результат: Нужно больше практиковаться.");
        }

        Exam anotherTest = new Exam("Java Basics", 70.0);
        System.out.println("Экзамены идентичны? " + javaTest.equals(anotherTest));
}}
