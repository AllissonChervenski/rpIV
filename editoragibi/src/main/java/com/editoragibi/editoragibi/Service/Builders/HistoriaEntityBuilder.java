package com.editoragibi.editoragibi.Service.Builders;

import com.editoragibi.editoragibi.Data.DesenhistaRepository;
import com.editoragibi.editoragibi.Data.Entity.HistoriaEntity;
import com.editoragibi.editoragibi.Data.Entity.PersonagemEntity;
import com.editoragibi.editoragibi.Data.EscritorRepository;
import com.editoragibi.editoragibi.Data.PersonagemRepository;
import com.editoragibi.editoragibi.Service.BaseObjects.BaseHistoria;
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

@Component("HistoriaEntityBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HistoriaEntityBuilder implements IBaseHistoriaBuilder {

    @Autowired
    DesenhistaRepository desenhistaRepository;

    @Autowired
    EscritorRepository escritorRepository;

    @Autowired
    PersonagemRepository personagemRepository;

    private HistoriaEntity historiaEntity;

    public HistoriaEntityBuilder() {
        reset();
    }

    private void reset() {
        historiaEntity = new HistoriaEntity();
    }

    @Override
    public void setHistoriaId(int historiaId) {
        historiaEntity.setHistoriaId(historiaId);
    }

    @Override
    public void setTituloHistoria(String tituloHistoria) {
        historiaEntity.setTituloHistoria(tituloHistoria);
    }

    @Override
    public void setTotalPaginas(int totalPaginas) {
        historiaEntity.setTotalPaginas(totalPaginas);
    }

    @Override
    public void setDataProducao(LocalDate dataProducao) {
        historiaEntity.setDataProducao(dataProducao);
    }

    @Override
    public void setArtefinalizador(int artefinalizadorId) throws DesenhistaInvalidoException, HistoriaInvalidaException {
        historiaEntity.setArtefinalizador(desenhistaRepository.getDesenhistaById(artefinalizadorId));
    }

    @Override
    public void setDesenhista(int desenhistaId) throws DesenhistaInvalidoException {
        historiaEntity.setDesenhista(desenhistaRepository.getDesenhistaById(desenhistaId));
    }

    @Override
    public void setEscritor(int escritorId) throws PersonagemInvalidoException, EscritorInvalidoException {
        historiaEntity.setEscritor(escritorRepository.getEscritorById(escritorId));
    }

    @Override
    public void setPersonagens(List<Integer> personagensIds) throws PersonagemInvalidoException, EscritorInvalidoException {
        List<PersonagemEntity> personagemEntities = historiaEntity.getPersonagens();
        for (Integer id : personagensIds) {
            personagemEntities.add(personagemRepository.getPersonagemById(id));
        }
    }

    @Override
    public BaseHistoria getResult() {
        HistoriaEntity toReturn = historiaEntity;
        reset();
        return toReturn;
    }
}
