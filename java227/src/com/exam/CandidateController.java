package com.exam;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateDAO cdao = new CandidateDAO();

    // --- GET (Получение всех) ---
    @GetMapping
    public List<Candidate> getAll() {
        return cdao.getAllCandidates();
    }

    // --- POST (Создание) ---
    @PostMapping
    public String add(@RequestBody Candidate candidate) {
        cdao.createCandidate(candidate);
        return "Кандидат " + candidate.getText() + " успешно создан!";
    }

    // --- PUT (Обновление баллов по имени) ---
    // URL в Postman: http://localhost:8080/api/candidates/Maksat
    @PutMapping("/{name}")
    public String update(@PathVariable String name, @RequestBody Candidate candidate) {
        cdao.updateCandidateScore(name, candidate.getScore());
        return "Обновлено";
    }
    // --- DELETE (Удаление по имени) ---
    // URL в Postman: http://localhost:8080/api/candidates/Maksat
    @DeleteMapping("/{name}")
    public String delete(@PathVariable String name) {
        cdao.deleteCandidate(name);
        return "Кандидат " + name + " удален из базы данных.";
    }
}