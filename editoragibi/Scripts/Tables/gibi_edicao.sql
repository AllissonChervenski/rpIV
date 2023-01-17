create table gibi_edicao(
    id INT PRIMARY KEY AUTO_INCREMENT,
    gibi_id INT NOT NULL,
    edicao_id INT NOT NULL,
    FOREIGN KEY (gibi_id) REFERENCES gibi(gibi_id),
    FOREIGN KEY (edicao_id) REFERENCES edicao(edicao_id)
)