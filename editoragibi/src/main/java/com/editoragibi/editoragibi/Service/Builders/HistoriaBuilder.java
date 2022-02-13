package com.editoragibi.editoragibi.Service.Builders;

import com.editoragibi.editoragibi.Data.DesenhistaRepository;
import com.editoragibi.editoragibi.Data.EscritorRepository;
import com.editoragibi.editoragibi.Data.PersonagemRepository;
import com.editoragibi.editoragibi.Service.BaseObjects.BaseHistoria;
import com.editoragibi.editoragibi.Service.Directors.DesenhistaDirector;
import com.editoragibi.editoragibi.Service.Directors.EscritorDirector;
import com.editoragibi.editoragibi.Service.Directors.PersonagemDirector;
import com.editoragibi.editoragibi.Service.Domain.Desenhista;
import com.editoragibi.editoragibi.Service.Domain.Escritor;
import com.editoragibi.editoragibi.Service.Domain.Historia;
import com.editoragibi.editoragibi.Service.Domain.Personagem;
import com.editoragibi.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.editoragibi.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.editoragibi.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.editoragibi.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component("historiaBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HistoriaBuilder implements IBaseHistoriaBuilder {

    @Autowired
    DesenhistaDirector desenhistaDirector;

    @Autowired
    EscritorDirector escritorDirector;

    @Autowired
    PersonagemDirector personagemDirector;

    @Autowired
    DesenhistaRepository desenhistaRepository;

    @Autowired
    EscritorRepository escritorRepository;

    @Autowired
    PersonagemRepository personagemRepository;

    private Historia historia;

    public HistoriaBuilder() {
        reset();
    }

    private void reset() {
        historia = new Historia();
    }

    @Override
    public void setHistoriaId(int historiaId) {
        historia.setHistoriaId(historiaId);
    }

    @Override
    public void setTituloHistoria(String tituloHistoria) throws HistoriaInvalidaException {
        try {
            historia.setTituloHistoria(tituloHistoria);
        } catch (HistoriaInvalidaException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setTotalPaginas(int totalPaginas) throws HistoriaInvalidaException {
        try {
            historia.setTotalPaginas(totalPaginas);
        } catch (HistoriaInvalidaException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setDataProducao(LocalDate dataProducao) throws HistoriaInvalidaException {
        try {
            historia.setDataProducao(dataProducao);
        } catch (HistoriaInvalidaException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setArtefinalizador(int artefinalizadorId) throws DesenhistaInvalidoException, HistoriaInvalidaException {
        try {
            Desenhista artefinalizador = (Desenhista) desenhistaDirector.buildFromDesenhistaEntity(desenhistaRepository.getDesenhistaById(artefinalizadorId));
            historia.setArtefinalizador(artefinalizador);
        } catch (Exception e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setDesenhista(int desenhistaId) throws DesenhistaInvalidoException {
        try {
            Desenhista desenhista = (Desenhista) desenhistaDirector.buildFromDesenhistaEntity(desenhistaRepository.getDesenhistaById(desenhistaId));
            historia.setDesenhista(desenhista);
        } catch (DesenhistaInvalidoException e) {
            reset();
            throw e;
        }
    }

    @Override
    public void setEscritor(int escritorId) throws PersonagemInvalidoException, EscritorInvalidoException {
        try {
            Escritor escritor = (Escritor) escritorDirector.buildFromEscritorEntity(escritorRepository.getEscritorById(escritorId));
            historia.setEscritor(escritor);
        } catch (Exception e) {
            reset();
            throw e;
        }

    }

    @Override
    public void setPersonagens(List<Integer> personagensIds) throws PersonagemInvalidoException, EscritorInvalidoException {
        List<Personagem> personagens = historia.getPersonagens();
        for (Integer id : personagensIds) {
            personagens.add((Personagem) personagemDirector.buildFromPersonagemEntity(personagemRepository.getPersonagemById(id)));
        }
    }

    @Override
    public BaseHistoria getResult() {
        Historia toReturn = historia;
        reset();
        return toReturn;
    }
}
