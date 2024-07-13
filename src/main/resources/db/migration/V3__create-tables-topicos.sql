CREATE TABLE topicos (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         titulo VARCHAR(255) NOT NULL,
                         mensagem TEXT,
                         data_criacao DATE,
                         status VARCHAR(20),
                         autor_id BIGINT,
                         curso_id BIGINT,
                         FOREIGN KEY (autor_id) REFERENCES usuarios(id),
                         FOREIGN KEY (curso_id) REFERENCES cursos(id)
);