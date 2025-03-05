package me.dio.decoltech.domain.service;


import lombok.RequiredArgsConstructor;
import me.dio.decoltech.domain.controller.exception.QuizNotFoundException;
import me.dio.decoltech.domain.model.Quiz;
import me.dio.decoltech.domain.respository.QuizRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    public List<Quiz> listarQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz criarQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public ResponseEntity<Quiz> obterQuizPorId(Long id) {
        return quizRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new QuizNotFoundException("Quiz não encontrado"));
    }

    public Quiz atualizarQuiz(Long id, Quiz quizAtualizado) {
        return quizRepository.findById(id).map(quiz -> {
            quiz.setTitulo(quizAtualizado.getTitulo());
            quiz.setDescricao(quizAtualizado.getDescricao());
            quiz.setDificuldade(quizAtualizado.getDificuldade());
            return quizRepository.save(quiz);
        }).orElseThrow(() -> new QuizNotFoundException("Quiz não encontrado"));
    }

    public void deletarQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}