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

public class Historia extends BaseHistoria {

    private DesenhistaRepository desenhistaRepository;
    private EscritorRepository escritorRepository;

    List<Personagem> personagens = new ArrayList<>();

    public Historia(DesenhistaRepository desenhistaRepository, EscritorRepository escritorRepository) {
        this.desenhistaRepository = desenhistaRepository;
        this.escritorRepository = escritorRepository;
    }

    public void addPersonagem(Personagem personagem) {
        personagens.add(personagem);
    }

    public void setArtefinalizador(int artefinalizadorId) throws HistoriaInvalidaException, DesenhistaInvalidoException {
        this.artefinalizador = desenhistaRepository.getDesenhistaById(artefinalizadorId);
    }

    public void setDesenhista(int desenhistaId) throws DesenhistaInvalidoException {
        this.desenhista = desenhistaRepository.getDesenhistaById(desenhistaId);
    }

    public void setEscritor(int escritorId) throws PersonagemInvalidoException, EscritorInvalidoException {
        //TODO
        //this.escritor = escritorRepository.getEscritorById(escritorId);
    }

    public void setTituloHistoria(String tituloHistoria) throws HistoriaInvalidaException {
        if (tituloHistoria == null || tituloHistoria.isBlank() || tituloHistoria.length() > 20)
            throw new HistoriaInvalidaException("Titulo inválido");
        this.tituloHistoria = tituloHistoria;
    }

    public void setTotalPaginas(int totalPaginas) throws HistoriaInvalidaException {
        if (totalPaginas <= 1)
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
         this.artefinalizador = (Desenhista) artefinalizador;
    }

    @Override
    public void setDesenhista(BaseDesenhista desenhista) throws DesenhistaInvalidoException {
        this.desenhista = (Desenhista) desenhista;
    }

    @Override
    public void setEscritor(BaseEscritor escritor) throws PersonagemInvalidoException, EscritorInvalidoException {
        this.escritor = (Escritor) escritor;
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }
}
