USE escola;

-- CREATE DATABASE IF NOT EXISTS escola;

CREATE TABLE IF NOT EXISTS aluno(
	numero INT(10) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(80)
);

CREATE TABLE IF NOT EXISTS veiculo(
	matricula INT(10) PRIMARY KEY NOT NULL,
    marca VARCHAR(20) NOT NULL,
    numeroAluno INT(10) NOT NULL,
    FOREIGN KEY (numeroAluno) REFERENCES aluno(numero)
);

CREATE TABLE IF NOT EXISTS professor(
	numero INT(10) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(80) NOT NULL
);

CREATE TABLE IF NOT EXISTS tutoria(
	numeroAluno INT(10) NOT NULL,
    numeroProfessor INT(10) NOT NULL,
    FOREIGN KEY (numeroAluno) REFERENCES aluno(numero),
    FOREIGN KEY (numeroProfessor) REFERENCES professor(numero)
);