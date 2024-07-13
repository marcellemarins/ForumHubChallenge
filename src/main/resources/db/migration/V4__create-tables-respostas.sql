CREATE TABLE respostas (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           mensagem TEXT,
                           data_criacao DATE,
                           topico_id BIGINT,
                           autor_id BIGINT,
                           solucao VARCHAR(255),
                           FOREIGN KEY (topico_id) REFERENCES topicos(id),
                           FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);