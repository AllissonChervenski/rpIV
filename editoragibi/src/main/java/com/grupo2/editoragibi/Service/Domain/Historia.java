package com.grupo2.editoragibi.Service.Domain;

import com.grupo2.editoragibi.Data.DesenhistaRepository;
import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Data.HistoriaRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BaseHistoria;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Historia extends BaseHistoria {

    List<Personagem> personagens = new ArrayList<>();

    public void setTituloHistoria(String tituloHistoria) throws HistoriaInvalidaException {
        if (tituloHistoria == null || !Pattern.matches("^[a-zà-úA-ZÀ-Ú\\s]([a-zà-úA-ZÀ-Ú])[a-zà-úA-ZÀ-Ú\\s]{1,20}$", tituloHistoria))
            throw new HistoriaInvalidaException("Titulo inválido");
        this.tituloHistoria = tituloHistoria;
    }

    public void setTotalPaginas(int totalPaginas) throws HistoriaInvalidaException {
        if (totalPaginas < 1)
            throw new HistoriaInvalidaException("Número inválido");
        this.totalPaginas = totalPaginas;
    }

    public void setDataProducao(LocalDate dataProducao) throws HistoriaInvalidaException {
        if (dataProducao.isAfter(LocalDate.now()))
            throw new HistoriaInvalidaException("Data inválida");
        this.dataProducao = dataProducao;
    }

    @Override
    public void setArtefinalizador(BaseDesenhista artefinalizador) throws HistoriaInvalidaException, DesenhistaInvalidoException {
        if (artefinalizador == null)
            throw new DesenhistaInvalidoException("É nessessário informar o artefinalizador dessa história");
        this.artefinalizador = artefinalizador;
    }

    @Override
    public void setDesenhista(BaseDesenhista desenhista) throws DesenhistaInvalidoException {
        if (desenhista == null)
            throw new DesenhistaInvalidoException("É nessessário informar o desenhista dessa história");
        this.desenhista = desenhista;
    }

    @Override
    public void setEscritor(BaseEscritor escritor) throws PersonagemInvalidoException, EscritorInvalidoException {
        if (escritor == null)
            throw new EscritorInvalidoException("É nessessário informar o escritor dessa história");
        this.escritor = escritor;
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }
}
