package com.exam;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {
    private final CandidateDAO cdao = new CandidateDAO();

    // Получить историю всех экзаменов
    @GetMapping
    public List<String> getHistory() {
        return cdao.getAllExamsResults();
    }

    // Назначить экзамен кандидату
    @PostMapping("/{candidateName}")
    public String startExam(@PathVariable String candidateName) {
        // 1. Ищем кандидата (в реальности берем из БД, тут для примера создаем)
        Candidate c = new Candidate(candidateName, 0);

        // 2. Создаем экзамен
        Exam newExam = new Exam("Midterm Test", c);

        // 3. Добавляем тестовый вопрос (имитация)
        newExam.addQuestion(new Question("Java OOP?", null, 0, 100.0));

        // 4. Сохраняем в базу
        cdao.createExam(newExam);

        return "Экзамен для " + candidateName + " успешно проведен и записан в базу!";
    }
}