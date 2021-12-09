package com.grupo2.editoragibi.Service.Domain;

import java.time.LocalDate;

public interface Edicao {
    String titulo = "";
    LocalDate inicioData = null;
    LocalDate encData = null;
    int edicoes = 0;
    int edicaoAtual = 0;


    boolean deleteGibi(Integer id);

    Edicao registraEd();
}
