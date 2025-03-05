package me.dio.decoltech.domain.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.dio.decoltech.domain.model.Quiz;
import me.dio.decoltech.domain.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
@Tag(name = "Quiz")
public class QuizController {
    private final QuizService quizService;

    @GetMapping("/listar_quizzes")
    public List<Quiz> listarQuizzes() {
        return quizService.listarQuizzes();
    }

    @PostMapping("/criar_quizzes")
    public Quiz criarQuiz(@RequestBody Quiz quiz) {
        return quizService.criarQuiz(quiz);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> obterQuizPorId(@PathVariable Long id) {
        return quizService.obterQuizPorId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarQuiz(@PathVariable Long id) {
        quizService.deletarQuiz(id);
        return ResponseEntity.noContent().build();
    }
}

