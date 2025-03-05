package me.dio.decoltech.domain.respository;

import me.dio.decoltech.domain.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {
}