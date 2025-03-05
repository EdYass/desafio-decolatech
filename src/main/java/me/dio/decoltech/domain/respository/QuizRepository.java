package me.dio.decoltech.domain.respository;

import me.dio.decoltech.domain.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
