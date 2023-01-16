package com.grupo2.editoragibi.Service.ServiceObjects;

import com.grupo2.editoragibi.Api.Requests.EdicoesGibiRequest;
import com.grupo2.editoragibi.Data.Entity.DesenhistaEntity;
import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Data.Entity.PersonagemEntity;
import com.grupo2.editoragibi.Data.Repositories.EdicoesGibiRepository;
import com.grupo2.editoragibi.Data.Repositories.HistoriaRepository;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IEdicoesGibiRepository;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IHistoriaRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.Directors.EdicoesGibiDirector;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EdicoesGibiService {
    @Autowired
    EdicoesGibiRepository edicoesGibiRepository;

    @Qualifier("edicoesGibiDirector")
    @Autowired
    EdicoesGibiDirector edDirector;

    @Qualifier("edicoesGibiEntityDirector")
    @Autowired
    EdicoesGibiDirector edicoesEntityDirector;

    @Autowired
    IHistoriaRepository iHistoriaRepository;


    public List<EdicoesGibi> getEdicoesGibis() throws EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException {
        List<EdicoesGibiEntity> edicoesGibiEntities = edicoesGibiRepository.getEdicoesGibis();
        List<EdicoesGibi> edicoesGibi = new ArrayList<>();
        for (EdicoesGibiEntity e : edicoesGibiEntities) {
            edicoesGibi.add((EdicoesGibi) edDirector.buildFromEdicoesGibiEntity(e));
        }

        return edicoesGibi;
    }

    public EdicoesGibi getGibisById(Integer id) throws EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException {
        boolean exists = edicoesGibiRepository.existsEdicaoGibi(id);
        if (!exists) {
            throw new EdicoesGibiInvalidoException("A edição não existe");
        }
        return (EdicoesGibi) edDirector.buildFromEdicoesGibiEntity(edicoesGibiRepository.getEdicaoGibiById(id).get());
    }

    public EdicoesGibi getEdicoesGibiByEdicao(Integer edicao) throws EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException {
        Optional<EdicoesGibiEntity> e = edicoesGibiRepository.getEdicaoByNumero(edicao);
        if (!e.isPresent()) {
            throw new EdicoesGibiInvalidoException("A edição não existe");
        }
        return (EdicoesGibi) edDirector.buildFromEdicoesGibiEntity(e.get());
    }

    public EdicoesGibi addEdicoesGibi(EdicoesGibiRequest edicoesGibi) throws EdicoesGibiInvalidoException, GibiInvalidoException, PersonagemInvalidoException, EscritorInvalidoException, HistoriaInvalidaException, DesenhistaInvalidoException {
        for (EdicoesGibiEntity e : edicoesGibiRepository.getEdicoesGibis())
            if (e.getDataPub().equals(edicoesGibi.getDataPub()) &&
                    e.getNroEdicao() == edicoesGibi.getNroEdicao()) {
                throw new EdicoesGibiInvalidoException("A edição já existe");
            }
        EdicoesGibi edicoes = (EdicoesGibi) edicoesEntityDirector.buildFromEdicoesGibiRequest(edicoesGibi);
        EdicoesGibiEntity edicoesGibiEntity = (EdicoesGibiEntity) edicoesEntityDirector.buildFromEdicoesGibi(edicoes);
        return  edicoesGibiRepository.save(edicoesGibiEntity);
    }

    
    public void deleteEdicoesGibi(Integer edicoesGibiId) throws EdicoesGibiInvalidoException {
        Optional<EdicoesGibiEntity> eOptional = edicoesGibiRepository.getEdicaoGibiById(edicoesGibiId);
        if (!eOptional.isPresent()) {
            throw new EdicoesGibiInvalidoException("A edição não existe");
        } else {
            edicoesGibiRepository.deleteEdicoesGibisById(edicoesGibiId);
        }
    }

    @Transactional
    public EdicoesGibi updateEdicoesGibi(Integer edicoesGibiId, Integer nroEdicao, LocalDate dataPub,
                                         int numeroExemplaresImpressas,
                                         boolean isPublicada,
                                         HistoriaEntity historiaEntity,
                                         GibiEntity gibiEntity, EscritorEntity escritorEntity, PersonagemEntity personagemEntity,
                                         DesenhistaEntity desenhistaEntity /*EditoraEntity editoraEntity*/)
            throws EdicoesGibiInvalidoException, HistoriaInvalidaException, GibiInvalidoException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException {
        Optional<EdicoesGibiEntity> edicoesGibi = edicoesGibiRepository.getEdicaoGibiById(edicoesGibiId);

        if (nroEdicao != null) {
            edicoesGibi.get().setNroEdicao(nroEdicao);
        }

        if (dataPub != null) {
            edicoesGibi.get().setDataPub(dataPub);
        }

        if (historiaEntity != null) {
            edicoesGibi.get().setHistoria(historiaEntity);
        }

        if(gibiEntity != null){
            edicoesGibi.get().setGibi(gibiEntity);
        }
        if(escritorEntity != null){
            edicoesGibi.get().setHistoria(historiaEntity);
        }
        /*if(editoraEntity != null){
            edicoesGibi.get().setEditora(editoraEntity);
        }
        */
        if(personagemEntity != null && edicoesGibi.get().getPersonagem().contains(personagemEntity)){
            edicoesGibi.get().getPersonagem();
        }
        return (EdicoesGibi) edDirector.buildFromEdicoesGibiEntity(edicoesGibiRepository.save(edicoesGibi.get()));
    }

    // Associação
    public void addHistoriaEdicao(Integer historiaId, Integer edicaoGibiId) throws EdicoesGibiInvalidoException, HistoriaInvalidaException {
        Optional<EdicoesGibiEntity> edicoesGibi = edicoesGibiRepository.getEdicaoGibiById(edicaoGibiId);
        Optional<HistoriaEntity> historiaEntityOptional = iHistoriaRepository.findById(historiaId);
        if ((!edicoesGibi.isEmpty() && edicoesGibi.get() != null)
                && (!historiaEntityOptional.isEmpty() && historiaEntityOptional != null))
            edicoesGibi.get().setHistoria(historiaEntityOptional.get());
        edicoesGibiRepository.save(edicoesGibi.get());
    }

    public void deleteHistoriaEdicao(Integer edicaoGibiId) throws EdicoesGibiInvalidoException, HistoriaInvalidaException {
        Optional<EdicoesGibiEntity> edicoesGibi = edicoesGibiRepository.getEdicaoGibiById(edicaoGibiId);

        edicoesGibi.get().setHistoria(null);

        edicoesGibiRepository.save(edicoesGibi.get());

    }
}