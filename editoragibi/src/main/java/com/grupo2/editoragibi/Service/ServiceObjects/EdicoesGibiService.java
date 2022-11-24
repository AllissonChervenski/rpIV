package com.grupo2.editoragibi.Service.ServiceObjects;

<<<<<<< HEAD

import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Data.Repositories.EdicoesGibiRepository;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IEdicoesGibiRepository;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IHistoriaRepository;
import com.grupo2.editoragibi.Service.Directors.EdicoesGibiDirector;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
=======
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
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5

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
<<<<<<< HEAD
    private final EdicoesGibiRepository edicoesGibiRepository;
=======
    EdicoesGibiRepository edicoesGibiRepository;
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5

    @Qualifier("edicoesGibiDirector")
    @Autowired
    EdicoesGibiDirector edDirector;
<<<<<<< HEAD
    @Autowired
    private final IHistoriaRepository iHistoriaRepository;

    @Autowired
    public EdicoesGibiService(EdicoesGibiRepository edicoesGibiRepository, IHistoriaRepository iHistoriaRepository) {
        this.edicoesGibiRepository = edicoesGibiRepository;
        this.iHistoriaRepository = iHistoriaRepository;
    }

    public List<EdicoesGibi> getEdicoesGibis() throws EdicoesGibiInvalidoException {
        List<EdicoesGibiEntity> edicoesGibiEntities = edicoesGibiRepository.getEdicoesGibis();
        List<EdicoesGibi> edicoesGibi = new ArrayList<>();
        for(EdicoesGibiEntity e: edicoesGibiEntities){
            edicoesGibi.add(edDirector.buildFromEdicoesGibiEntity(e));
=======

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
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
        }

        return edicoesGibi;
    }

<<<<<<< HEAD
    public EdicoesGibi getGibisById(Integer id) throws EdicoesGibiInvalidoException {
=======
    public EdicoesGibi getGibisById(Integer id) throws EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException {
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
        boolean exists = edicoesGibiRepository.existsEdicaoGibi(id);
        if (!exists) {
            throw new EdicoesGibiInvalidoException("A edição não existe");
        }
<<<<<<< HEAD
        return edDirector.buildFromEdicoesGibiEntity(edicoesGibiRepository.getEdicaoGibiById(id).get());
    }

    public EdicoesGibi getEdicoesGibiByEdicao(Integer edicao) throws EdicoesGibiInvalidoException {
        Optional<EdicoesGibiEntity> e = edicoesGibiRepository.getEdicaoByNumero(edicao);
        if(!e.isPresent()){
            throw new EdicoesGibiInvalidoException("A edição não existe");
        }
        return  edDirector.buildFromEdicoesGibiEntity(e.get());
    }

    public void addEdicoesGibi(EdicoesGibiEntity edicoesGibi) throws EdicoesGibiInvalidoException {
        Optional<EdicoesGibiEntity> eOptional = edicoesGibiRepository.getEdicaoGibiById(edicoesGibi.getEdicaoGibi_id());
        if(eOptional.isPresent()){
            throw new EdicoesGibiInvalidoException("A edição já existe");
        }
        else{
            edicoesGibiRepository.save(edicoesGibi);
        }
=======
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
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
    }

    public void deleteEdicoesGibi(Integer edicoesGibiId) throws EdicoesGibiInvalidoException {
        Optional<EdicoesGibiEntity> eOptional = edicoesGibiRepository.getEdicaoGibiById(edicoesGibiId);
<<<<<<< HEAD
        if(!eOptional.isPresent()){
            throw new EdicoesGibiInvalidoException("A edição não existe");
        }
        else{
=======
        if (!eOptional.isPresent()) {
            throw new EdicoesGibiInvalidoException("A edição não existe");
        } else {
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
            edicoesGibiRepository.deleteEdicoesGibisById(edicoesGibiId);
        }
    }

    @Transactional
<<<<<<< HEAD
    public void updateEdicoesGibi(Integer edicoesGibiId, Integer nroEdicao, LocalDate dataPub, HistoriaEntity historiaEntity) throws EdicoesGibiInvalidoException {
        Optional<EdicoesGibiEntity> edicoesGibi = edicoesGibiRepository.getEdicaoGibiById(edicoesGibiId);

        if(nroEdicao != null){
            edicoesGibi.get().setNroEdicao(nroEdicao);
        }

        if(dataPub != null){
            edicoesGibi.get().setDataPub(dataPub);
        }

        if(historiaEntity != null){
            edicoesGibi.get().addHistoriaEntity(historiaEntity);
        }

        edicoesGibiRepository.save(edicoesGibi.get());
    }

    public void addHistoriaEdicao(Integer historiaId, Integer edicaoGibiId) throws EdicoesGibiInvalidoException {
        Optional<EdicoesGibiEntity> edicoesGibi = edicoesGibiRepository.getEdicaoGibiById(edicaoGibiId);
        Optional<HistoriaEntity> historiaEntityOptional = iHistoriaRepository.findById(historiaId);

        historiaEntityOptional.ifPresent(edicoesGibi.get()::addHistoriaEntity);

        edicoesGibiRepository.save(edicoesGibi.get());
    }

    public void deleteHistoriaEdicao(Integer edicaoGibiId) throws EdicoesGibiInvalidoException {
        Optional<EdicoesGibiEntity> edicoesGibi = edicoesGibiRepository.getEdicaoGibiById(edicaoGibiId);
     
        edicoesGibi.get().setHistoriaEntity(null);
=======
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
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5

        edicoesGibiRepository.save(edicoesGibi.get());

    }
}
<<<<<<< HEAD






=======
>>>>>>> e08ba23a7ae72b2cf741c87f80d5cc756ffdadb5
