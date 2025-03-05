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
public class Quiz {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Dificuldade dificuldade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario criador;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Pergunta> perguntas;
}

