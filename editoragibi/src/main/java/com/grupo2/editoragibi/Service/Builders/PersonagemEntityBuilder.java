package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.Entity.PersonagemEntity;
import com.grupo2.editoragibi.Data.IEscritorRepository;
import com.grupo2.editoragibi.Data.IPersonagemRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PersonagemEntityBuilder implements IBasePersonagemBuilder {

    private IPersonagemRepository iPersonagemRepository;
    private IEscritorRepository iEscritorRepository;

    private PersonagemEntity personagemEntity;

    public PersonagemEntityBuilder(IPersonagemRepository iPersonagemRepository, IEscritorRepository iEscritorRepository) {
        this.iPersonagemRepository = iPersonagemRepository;
        this.iEscritorRepository = iEscritorRepository;
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
            Optional<EscritorEntity> escritorEntity = iEscritorRepository.findById(id);
            if (escritorEntity.isEmpty())
                throw new EscritorInvalidoException("Escritor não está no sistema");
            escritoresPersonagem.add(escritorEntity.get());
        }
    }

    @Override
    public BasePersonagem getResult() {
        return null;
    }
}
