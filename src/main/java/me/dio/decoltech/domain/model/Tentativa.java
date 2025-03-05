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
public class Tentativa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Quiz quiz;

    @OneToMany(mappedBy = "tentativa", cascade = CascadeType.ALL)
    private List<Resposta> respostas;

    private Double pontuacao;
}