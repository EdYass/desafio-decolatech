package me.dio.decoltech.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resposta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Pergunta pergunta;

    @ManyToOne
    private Alternativa alternativaEscolhida;

    @ManyToOne
    private Tentativa tentativa;
}
