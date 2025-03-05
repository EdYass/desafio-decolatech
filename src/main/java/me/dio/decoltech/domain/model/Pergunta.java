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
public class Pergunta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enunciado;

    @ManyToOne
    private Quiz quiz;

    @OneToMany(mappedBy = "pergunta", cascade = CascadeType.ALL)
    private List<Alternativa> alternativas;

    @ManyToOne
    private Alternativa respostaCorreta;
}