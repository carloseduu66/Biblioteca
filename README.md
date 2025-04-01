# 📚 Sistema de Biblioteca

Este é um sistema de gerenciamento de biblioteca desenvolvido em Java, com integração ao banco de dados PostgreSQL. O sistema permite o cadastro de alunos, livros e empréstimos, além de funcionalidades de consulta, atualização e exclusão de registros.

## 📌 Funcionalidades
- Cadastro de **Alunos** e **Livros**.
- Realização de **Empréstimos** de livros para os alunos.
- Consulta e listagem de alunos, livros e empréstimos.
- Atualização e exclusão de registros de alunos, livros e empréstimos.
- Tela de **login** para acesso ao sistema.
- Integração com banco de dados PostgreSQL para persistência de dados.

## 🚀 Tecnologias Utilizadas
- **Java** (JDK 8 ou superior)
- **PostgreSQL** (Banco de Dados)
- **JDBC** para conexão com o banco de dados
- **Eclipse IDE** para desenvolvimento

## 📂 Estrutura do Projeto
```

Biblioteca/
│-- .gitignore
│-- .classpath
│-- .project
│-- Biblioteca/
│   ├── src/
│   │   ├── controller/
│   │   │   └── [DAOs para Aluno, Livro, etc.]
│   │   ├── model/
│   │   │   └── [Classes do Modelo, como Aluno, Livro, etc.]
│   │   └── view/
│   │       └── [Janelas para a interface gráfica]
│   └── bin/
│       └── [Arquivos compilados]
│-- biblioteca.sql  # Script para criação do banco de dados
```

## 🛠 Como Executar Localmente

### Pré-requisitos:
- Instale o **Java JDK 8** ou superior em sua máquina.
- Instale o **PostgreSQL** e crie um banco de dados para o sistema.
- Baixe ou clone o repositório:
  ```sh
  git clone https://github.com/carloseduu66/Biblioteca.git

## 📝 Licença
Este projeto está sob a licença MIT. Sinta-se à vontade para usá-lo e modificá-lo.

---
Criado por [Carlos Eduardo](https://github.com/carloseduu66).
