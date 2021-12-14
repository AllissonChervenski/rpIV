package com.grupo2.editoragibi.Api.Requests;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class PersonagemRequest {

    @NotNull
    private String nomePersonagem;

    @NotNull
    private String historicoPersonagem;

    @NotNull
    private String patentePersonagem;

    @NotNull
    private LocalDate dataCriacao;

    @NotNull
    public List<Integer> escritoresIds;
}
