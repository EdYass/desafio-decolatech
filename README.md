# Desafio Bootcamp Decola Tech 2025
Crie sua própria API
## 💡 Quiz EduTech API
Uma API para criação, gerenciamento e execução de quizzes educativos, onde usuários podem criar perguntas, responder e acompanhar pontuações.

## 🚀 Tecnologias utilizadas:
✅ Java 17 (LTS)

✅ Spring Boot 3 (Autoconfiguração)

✅ Spring Data JPA (Bancos SQL)

✅ Swagger/OpenAPI (Documentação)

✅ Railway (Deploy)

## 🎯 Todas as Features que serão desenvolvidas:
- Cadastro de usuários (estudantes/professores).
- CRUD de quizzes e perguntas (por categorias, níveis de dificuldade).
- Registro de respostas e cálculo de pontuação.
- Histórico de tentativas dos usuários.
- Filtro para recomendar quizzes baseados em desempenho.

## Diagrama de Classes

```` mermaid
  classDiagram
      direction TB
      
      class Usuario {
          +Long id
          +String nome
          +String email
          +String senha
          +Role role
      }
  
      class Role {
          <<ENUM>>
          ADMIN
          PROFESSOR
          ESTUDANTE
      }
  
      class Quiz {
          +Long id
          +String titulo
          +String descricao
          +Dificuldade dificuldade
          +Usuario criador
          +List~Pergunta~ perguntas
      }
  
      class Dificuldade {
          <<ENUM>>
          FACIL
          MEDIO
          DIFICIL
      }
  
      class Pergunta {
          +Long id
          +String enunciado
          +List~Alternativa~ alternativas
          +Alternativa respostaCorreta
          +Quiz quiz
      }
  
      class Alternativa {
          +Long id
          +String texto
          +Boolean correta
          +Pergunta pergunta
      }
  
      class Tentativa {
          +Long id
          +Usuario usuario
          +Quiz quiz
          +List~Resposta~ respostas
          +Double pontuacao
          +LocalDateTime dataHora
      }
  
      class Resposta {
          +Long id
          +Pergunta pergunta
          +Alternativa alternativaEscolhida
          +Tentativa tentativa
      }
  
      %% Relacionamentos
      
      Usuario "1" --> "0..*" Quiz : cria
      Usuario "1" --> "0..*" Tentativa : realiza
      Quiz "1" --> "0..*" Pergunta : contém
      Pergunta "1" --> "0..*" Alternativa : tem
      Pergunta "1" --> "1" Alternativa : respostaCorreta
      Tentativa "1" --> "0..*" Resposta : contém
      Resposta "1" --> "1" Pergunta : refere-se
      Resposta "1" --> "1" Alternativa : seleciona
````
## Features Presentes até o momento:
- Cadastro de usuários (estudantes/professores). ✅
- CRUD de quizzes e perguntas (por categorias, níveis de dificuldade). ✅

