package com.grupo2.editoragibi.Api.Requests;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class HistoriaRequest {

    @NotNull
    private String tituloHistoria;

    @NotNull
    private int totalPaginas;

    @NotNull
    private LocalDate dataProducao;

    @NotNull
    private int artefinalizadorId;

    @NotNull
    private int desenhistaId;

    @NotNull
    private int escritorId;

    @NotNull
    private List<Integer> personagensIds;
}
