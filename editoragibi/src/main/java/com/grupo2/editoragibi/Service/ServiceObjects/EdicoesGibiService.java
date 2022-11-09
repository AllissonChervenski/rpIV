package com.grupo2.editoragibi.Service.ServiceObjects;


import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Data.Repositories.EdicoesGibiRepository;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IEdicoesGibiRepository;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IHistoriaRepository;
import com.grupo2.editoragibi.Service.Directors.EdicoesGibiDirector;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;

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
    private final EdicoesGibiRepository edicoesGibiRepository;

    @Qualifier("edicoesGibiDirector")
    @Autowired
    EdicoesGibiDirector edDirector;
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
        }

        return edicoesGibi;
    }

    public EdicoesGibi getGibisById(Integer id) throws EdicoesGibiInvalidoException {
        boolean exists = edicoesGibiRepository.existsEdicaoGibi(id);
        if (!exists) {
            throw new EdicoesGibiInvalidoException("A edição não existe");
        }
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
    }

    public void deleteEdicoesGibi(Integer edicoesGibiId) throws EdicoesGibiInvalidoException {
        Optional<EdicoesGibiEntity> eOptional = edicoesGibiRepository.getEdicaoGibiById(edicoesGibiId);
        if(!eOptional.isPresent()){
            throw new EdicoesGibiInvalidoException("A edição não existe");
        }
        else{
            edicoesGibiRepository.deleteEdicoesGibisById(edicoesGibiId);
        }
    }

    @Transactional
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

        edicoesGibiRepository.save(edicoesGibi.get());

    }
}





