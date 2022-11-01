package com.grupo2.editoragibi.Service.ServiceObjects;


import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Data.Repositories.EdicoesGibiRepository;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IEdicoesGibiRepository;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IHistoriaRepository;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EdicoesGibiService {
    @Autowired
    private final EdicoesGibiRepository edicoesGibiRepository;

    @Autowired
    private final IHistoriaRepository iHistoriaRepository;

    @Autowired
    public EdicoesGibiService(EdicoesGibiRepository edicoesGibiRepository, IHistoriaRepository iHistoriaRepository) {
        this.edicoesGibiRepository = edicoesGibiRepository;
        this.iHistoriaRepository = iHistoriaRepository;
    }

    public List<EdicoesGibiEntity> getEdicoesGibis() throws EdicoesGibiInvalidoException {
        return edicoesGibiRepository.getEdicoesGibis();
    }

    public EdicoesGibiEntity getGibisById(Integer id) throws EdicoesGibiInvalidoException {
        boolean exists = edicoesGibiRepository.existsEdicaoGibi(id);
        if (!exists) {
            throw new IllegalStateException("Edicao do id " + id + " não existe");
        }
        return edicoesGibiRepository.getEdicaoGibiById(id);
    }

    public EdicoesGibiEntity getEdicoesGibiByEdicao(Integer edicao) throws EdicoesGibiInvalidoException {
        return edicoesGibiRepository.getEdicaoByNumero(edicao);
    }

  /*   public void addEdicoesGibi(EdicoesGibiEntity edicoesGibi) {
        Optional<EdicoesGibiEntity> edicoesGibiOptional = edicoesGibiRepository.findEdicoesGibiByEdicao(edicoesGibi.getNroEdicao());
        if (edicoesGibiOptional.isPresent()) {
                throw new IllegalStateException("Edicao :" + edicoesGibi.getNroEdicao() + "Data: " + " já existente");
            }
        else {
                edicoesGibiRepository.save(edicoesGibi);
            }
        }
*/
    public void deleteEdicoesGibi(Integer edicoesGibiId) throws EdicoesGibiInvalidoException {
       edicoesGibiRepository.deleteEdicoesGibisById(edicoesGibiId);
    }

    @Transactional
    public void updateEdicoesGibi(Integer edicoesGibiId, Integer nroEdicao, LocalDate dataPub, HistoriaEntity historiaEntity) throws EdicoesGibiInvalidoException {
        EdicoesGibiEntity edicoesGibi = edicoesGibiRepository.getEdicaoGibiById(edicoesGibiId);

        if(nroEdicao != null){
            edicoesGibi.setNroEdicao(nroEdicao);
        }

        if(dataPub != null){
            edicoesGibi.setDataPub(dataPub);
        }

        if(historiaEntity != null){
            edicoesGibi.addHistoriaEntity(historiaEntity);
        }

        edicoesGibiRepository.save(edicoesGibi);
    }

    public void addHistoriaEdicao(Integer historiaId, Integer edicaoGibiId) throws EdicoesGibiInvalidoException {
        EdicoesGibiEntity edicoesGibi = edicoesGibiRepository.getEdicaoGibiById(edicaoGibiId);
        Optional<HistoriaEntity> historiaEntityOptional = iHistoriaRepository.findById(historiaId);

        historiaEntityOptional.ifPresent(edicoesGibi::addHistoriaEntity);

        edicoesGibiRepository.save(edicoesGibi);
    }

    public void deleteHistoriaEdicao(Integer edicaoGibiId) throws EdicoesGibiInvalidoException {
        EdicoesGibiEntity edicoesGibi = edicoesGibiRepository.getEdicaoGibiById(edicaoGibiId);
     
        edicoesGibi.setHistoriaEntity(null);

        edicoesGibiRepository.save(edicoesGibi);

    }
}






