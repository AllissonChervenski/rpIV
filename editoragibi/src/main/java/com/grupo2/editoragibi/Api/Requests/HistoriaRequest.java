package com.grupo2.editoragibi.Api.Requests;

import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BaseHistoria;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class HistoriaRequest extends BaseHistoria {

    @NotNull
    private int artefinalizadorId;

    @NotNull
    private int desenhistaId;

    @NotNull
    private int escritorId;

    @NotNull
    private List<Integer> personagensIds;

    @Override
    public void setTituloHistoria(String tituloHistoria) throws HistoriaInvalidaException {
        this.tituloHistoria = tituloHistoria;
    }

    @Override
    public void setTotalPaginas(int totalPaginas) throws HistoriaInvalidaException {
        this.totalPaginas = totalPaginas;
    }

    @Override
    public void setDataProducao(LocalDate dataProducao) throws HistoriaInvalidaException {
        this.dataProducao = dataProducao;
    }

    @Override
    public void setArtefinalizador(BaseDesenhista artefinalizador) throws HistoriaInvalidaException, DesenhistaInvalidoException {
        this.artefinalizadorId = artefinalizador.getDesenhistaId();
    }

    @Override
    public void setDesenhista(BaseDesenhista desenhista) throws DesenhistaInvalidoException {
        this.desenhistaId = desenhista.getDesenhistaId();
    }

    @Override
    public void setEscritor(BaseEscritor escritor) throws PersonagemInvalidoException, EscritorInvalidoException {
        this.escritorId = escritor.getEscritorId();
    }
}
