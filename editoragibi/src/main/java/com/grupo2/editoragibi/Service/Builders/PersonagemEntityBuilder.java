package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.Entity.PersonagemEntity;
import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component("personagemEntityBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PersonagemEntityBuilder implements IBasePersonagemBuilder {

    @Autowired
    EscritorRepository escritorRepository;

    private PersonagemEntity personagemEntity;

    public PersonagemEntityBuilder() {
        reset();
    }

    public void reset() {
        personagemEntity = new PersonagemEntity();
    }

    @Override
    public void setPersonagemId(int id) {
        personagemEntity.setPersonagemId(id);
    }

    @Override
    public void setNomePersonagem(String nomePersonagem) throws PersonagemInvalidoException {
        personagemEntity.setNomePersonagem(nomePersonagem);
    }

    @Override
    public void setHistoriaPersonagem(String historiaPersonagem) {
        personagemEntity.setHistoricoPersonagem(historiaPersonagem);
    }

    @Override
    public void setPatentePersonagem(String patentePersonagem) {
        personagemEntity.setPatentePersonagem(patentePersonagem);
    }

    @Override
    public void setDataCriacao(LocalDate dataCriacao) throws PersonagemInvalidoException {
        personagemEntity.setDataCriacao(dataCriacao);
    }

    @Override
    public void setEscritores(List<Integer> escritoresIds) throws PersonagemInvalidoException, EscritorInvalidoException {
        List<EscritorEntity> escritoresPersonagem = personagemEntity.getEscritores();
        for (Integer id : escritoresIds) {
            escritoresPersonagem.add(escritorRepository.getEscritorById(id));
        }
    }

    @Override
    public void setEscritor(BaseEscritor escritor) {
        if (escritor instanceof EscritorEntity)
            personagemEntity.getEscritores().add((EscritorEntity) escritor);
    }

    @Override
    public BasePersonagem getResult() {
        PersonagemEntity toReturn = personagemEntity;
        reset();
        return toReturn;
    }
}
