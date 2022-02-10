package com.grupo2.editoragibi.Api.Requests;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class EscritorRequest {

    @NotNull
    private String nomeEscritor;

    @NotNull
    private String enderecoEscritor;

    @NotNull
    private String telefoneEscritor;

    @NotNull
    private String emailEscritor;

    @NotNull
    private LocalDate dataContratacao;

    @NotNull
    private LocalDate dataDemissao;
}
